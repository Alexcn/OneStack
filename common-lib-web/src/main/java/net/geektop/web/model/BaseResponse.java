package net.geektop.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.geektop.web.constant.ResultCode;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.web.model
 * @date 2020/4/27 23:46
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {
  @Builder.Default
  private String message = ResultCode.SUCCESS.getMessage();
  @Builder.Default
  private int code = ResultCode.SUCCESS.getCode();
}
