package net.geektop.web.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.web.validation
 * @date 2020/10/20 11:28
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = NameValidator.class)
@Documented
public @interface Name {

  String message() default "{Name.invalid}";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };

}
