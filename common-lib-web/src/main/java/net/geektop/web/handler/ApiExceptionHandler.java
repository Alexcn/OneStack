package net.geektop.web.handler;

import lombok.extern.slf4j.Slf4j;
import net.geektop.web.exception.CommonException;
import net.geektop.web.model.BaseResponse;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.sql.SQLException;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.handler
 * @date 2020/1/13 10:58
 */

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {
  @ExceptionHandler(MissingServletRequestParameterException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BaseResponse handlerError(MissingServletRequestParameterException e) {
    String message = String.format("Missing Request Parameter: %s", e.getParameterName());
    return BaseResponse
      .builder()
      .message(message)
      .code(HttpStatus.BAD_REQUEST.value())
      .build();
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BaseResponse handleError(MethodArgumentTypeMismatchException e) {
    log.warn("Method Argument Type Mismatch", e);
    String message = String.format("Method Argument Type Mismatch: %s", e.getName());
    return BaseResponse
      .builder()
      .message(message)
      .code(HttpStatus.BAD_REQUEST.value())
      .build();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BaseResponse handleError(MethodArgumentNotValidException e) {
    log.warn("Method Argument Not Valid", e);
    BindingResult result = e.getBindingResult();
    FieldError error = result.getFieldError();
    String message = String.format("%s:%s", error.getField(), error.getDefaultMessage());
    return BaseResponse
      .builder()
      .message(message)
      .code(HttpStatus.BAD_REQUEST.value())
      .build();
  }

  @ExceptionHandler(BindException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BaseResponse handleError(BindException e) {
    log.warn("Bind Exception", e);
    FieldError error = e.getFieldError();
    assert error != null;
    String message = String.format("%s:%s", error.getField(), error.getDefaultMessage());
    return BaseResponse
      .builder()
      .message(message)
      .code(HttpStatus.BAD_REQUEST.value())
      .build();
  }

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BaseResponse handleError(ConstraintViolationException e) {
    log.warn("Constraint Violation", e);
    ConstraintViolation<?> violation = e.getConstraintViolations().iterator().next();
    String path = ((PathImpl) violation.getPropertyPath()).getLeafNode().getName();
    String message = String.format("%s:%s", path, violation.getMessage());
    return BaseResponse
      .builder()
      .message(message)
      .code(HttpStatus.BAD_REQUEST.value())
      .build();
  }

  @ExceptionHandler(NoHandlerFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public BaseResponse handleError(NoHandlerFoundException e) {
    log.error("404 Not Found", e);
    return BaseResponse
      .builder()
      .message(e.getMessage())
      .code(HttpStatus.NOT_FOUND.value())
      .build();
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BaseResponse handleError(HttpMessageNotReadableException e) {
    log.error("Message Not Readable", e);
    return BaseResponse
      .builder()
      .message(e.getMessage())
      .code(HttpStatus.BAD_REQUEST.value())
      .build();
  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
  public BaseResponse handleError(HttpRequestMethodNotSupportedException e) {
    log.error("Request Method Not Supported", e);
    return BaseResponse
      .builder()
      .message(e.getMessage())
      .code(HttpStatus.METHOD_NOT_ALLOWED.value())
      .build();
  }

  @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
  @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
  public BaseResponse handleError(HttpMediaTypeNotSupportedException e) {
    log.error("Media Type Not Supported", e);
    return BaseResponse
      .builder()
      .message(e.getMessage())
      .code(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value())
      .build();
  }

  @ExceptionHandler(ValidationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BaseResponse handleError(ValidationException e) {
    log.error("Parameter error", e);
    return BaseResponse.builder()
      .message(e.getMessage())
      .code(HttpStatus.BAD_REQUEST.value())
      .build();
  }

  @ExceptionHandler(DuplicateKeyException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public BaseResponse handleError(DuplicateKeyException e) {
    log.error("Data Duplicate", e);
    return BaseResponse.builder()
      .message("Data Duplicate")
      .code(HttpStatus.BAD_REQUEST.value())
      .build();
  }

  @ExceptionHandler(SQLException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public BaseResponse handleError(SQLException e) {
    log.error("database error: ", e);
    return BaseResponse
      .builder()
      .message(e.getMessage())
      .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
      .build();
  }

  @ExceptionHandler(CommonException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public BaseResponse handleError(CommonException e) {
    log.error("Service Exception", e);
    return BaseResponse
      .builder()
      .message(e.getMessage())
      .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
      .build();
  }

  @ExceptionHandler(Throwable.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public BaseResponse handleError(Throwable e) {
    log.error("Internal Server Error", e);
    return BaseResponse
      .builder()
      .message(e.getMessage())
      .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
      .build();
  }

}
