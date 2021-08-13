package net.geektop.web.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.web.validation
 * @date 2020/11/25 18:47
 */
@Documented
@Constraint(validatedBy = StockCodeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface StockCode {
  String message() default "{StockCode.invalid}";

  boolean isRequired() default false;

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };
}
