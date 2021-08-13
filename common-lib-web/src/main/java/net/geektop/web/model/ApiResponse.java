package net.geektop.web.model;

import lombok.*;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.model
 * @date 2020/1/13 18:36
 */
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class ApiResponse<T> extends BaseResponse {
  @Getter
  private final T data;

  public static <T> ApiResponse<T> success(T result) {
    return new ApiResponse<>(result);
  }

}
