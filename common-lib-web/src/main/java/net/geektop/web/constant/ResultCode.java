package net.geektop.web.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.constant
 * @date 2020/1/13 18:32
 */

@Getter
@AllArgsConstructor
public enum ResultCode {
  SUCCESS(HttpServletResponse.SC_OK, "Successful"),

  FAILURE(HttpServletResponse.SC_BAD_REQUEST, "Bad Request"),

  UN_AUTHORIZED(HttpServletResponse.SC_UNAUTHORIZED, "Request Unauthorized"),

  NOT_FOUND(HttpServletResponse.SC_NOT_FOUND, "404 Not Found"),

  MSG_NOT_READABLE(HttpServletResponse.SC_BAD_REQUEST, "Message Can't be Read"),

  METHOD_NOT_SUPPORTED(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Method Not Supported"),

  MEDIA_TYPE_NOT_SUPPORTED(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Media Type Not Supported"),

  REQ_REJECT(HttpServletResponse.SC_FORBIDDEN, "Request Rejected"),

  INTERNAL_SERVER_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error"),

  PARAM_MISS(HttpServletResponse.SC_BAD_REQUEST, "Missing Required Parameter"),

  PARAM_TYPE_ERROR(HttpServletResponse.SC_BAD_REQUEST, "Parameter Type Mismatch"),

  PARAM_BIND_ERROR(HttpServletResponse.SC_BAD_REQUEST, "Parameter Binding Error"),

  PARAM_VALID_ERROR(HttpServletResponse.SC_BAD_REQUEST, "Parameter Validation Error"),

  JSON_PARSE_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Json Parse Error");

  private final int code;
  private final String message;
}
