package net.geektop.web.exception;

import org.springframework.http.HttpStatus;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.web.exception
 * @date 2020/4/10 00:08
 */
public abstract class AbstractException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  private final HttpStatus status;

  private final int code;

  private final String message;

  private final String detailMessage;

  public AbstractException(HttpStatus status, ErrorCode errorCode) {
    this.status = status;
    this.code = errorCode.getCode();
    this.message = errorCode.getMessage();
    this.detailMessage = errorCode.getDetailMessage();
  }

  public AbstractException(HttpStatus status) {
    this.status = status;
    code = 0;
    message = null;
    detailMessage = null;
  }

  public AbstractException(HttpStatus status, ErrorCode errorCode, Throwable cause) {
    super(cause);
    this.status = status;
    this.code = errorCode.getCode();
    this.message = errorCode.getMessage();
    detailMessage = (cause.getMessage() != null ? cause.getMessage() : "") + toStackTrace(cause);
  }

  private String toStackTrace(Throwable e) {
    StringWriter errorStackTrace = new StringWriter();
    e.printStackTrace(new PrintWriter(errorStackTrace));
    return errorStackTrace.toString();

  }

  public HttpStatus getStatus() {
    return status;
  }

  public ErrorCode getCode() {
    return new ErrorCode(code,message,detailMessage);
  }

  @Override
  public String getMessage() {
    return message;
  }

  public String getDetailMessage() {
    return detailMessage;
  }
}
