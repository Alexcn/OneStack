package net.geektop.web.exception;

import lombok.Getter;
import net.geektop.web.constant.ResultCode;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.exception
 * @date 2020/1/13 18:35
 */
public class CommonException extends RuntimeException {
  private static final long serialVersionUID = 2359767895161832954L;

  @Getter
  private final ResultCode resultCode;

  public CommonException(String message) {
    super(message);
    this.resultCode = ResultCode.FAILURE;
  }

  public CommonException(ResultCode resultCode) {
    super(resultCode.getMessage());
    this.resultCode = resultCode;
  }

  public CommonException(ResultCode resultCode, String message) {
    super(message);
    this.resultCode = resultCode;
  }

  public CommonException(ResultCode resultCode, Throwable cause) {
    super(cause);
    this.resultCode = resultCode;
  }

  public CommonException(String message, Throwable cause) {
    super(message, cause);
    this.resultCode = ResultCode.FAILURE;
  }

  /**
   * for better performance
   *
   * @return Throwable
   */
  @Override
  public Throwable fillInStackTrace() {
    return this;
  }

  public Throwable doFillInStackTrace() {
    return super.fillInStackTrace();
  }
}
