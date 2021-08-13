package net.geektop.web.handler;

import lombok.extern.slf4j.Slf4j;
import net.geektop.web.model.ApiResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.web.handler
 * @date 2020/3/28 18:17
 */

@Slf4j
//@ControllerAdvice(annotations = RestController.class)
//public class ApiResultHandler implements ResponseBodyAdvice<Object> {
public class ApiResultHandler{

//  private static final Class[] annotationList = {
//    RequestMapping.class,
//    GetMapping.class,
//    PostMapping.class,
//    DeleteMapping.class,
//    PutMapping.class
//  };
//
//  public boolean supports(MethodParameter returnType, @NotNull Class convertType) {
//    AnnotatedElement element = returnType.getAnnotatedElement();
//    return Arrays.stream(annotationList).anyMatch(annotationList
//      -> annotationList.isAnnotation() && element.isAnnotationPresent(annotationList));
//  }
//
//  public Object beforeBodyWrite(@Nullable Object body, @NotNull MethodParameter returnType, @NotNull MediaType selectedContentType,
//                                @NotNull Class selectedConverterType, @NotNull ServerHttpRequest request, ServerHttpResponse response) {
//    response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
//    if(body instanceof ApiResponse) {
//      return body;
//    }
//    return null;
//    else if (body instanceof Exception) {
//      return ApiResponse.builder()
//        .message(((Exception) body).getMessage())
//        .data(null)
//        .build();
//    }
//    else {
//      return ApiResponse.builder()
//        .message("Success")
//        .data(body)
//        .build();
//    }
//  }
}
