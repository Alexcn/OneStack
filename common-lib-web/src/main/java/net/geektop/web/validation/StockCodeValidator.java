package net.geektop.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.web.validation
 * @date 2020/11/25 18:47
 */
public class StockCodeValidator implements ConstraintValidator<StockCode, String> {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value.chars().noneMatch(Character::isWhitespace);
  }
}
