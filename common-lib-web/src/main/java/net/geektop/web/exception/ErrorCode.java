package net.geektop.web.exception;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.web.exception
 * @date 2020/4/10 00:10
 */

public class ErrorCode {

  private final int code;
  private final String message;
  private final String detailMessage;

  public ErrorCode(int code, String message, String detailMessage) {
    this.code = code;
    this.message = message;
    this.detailMessage = detailMessage;
  }

  public ErrorCode(String message, String detailMessage) {
    this.code = 0;
    this.message = message;
    this.detailMessage = detailMessage;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public String getDetailMessage() {
    return detailMessage;
  }
}
