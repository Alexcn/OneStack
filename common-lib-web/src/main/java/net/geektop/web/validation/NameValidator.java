package net.geektop.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.web.validation
 * @date 2020/10/20 11:28
 */
public class NameValidator implements ConstraintValidator<Name, String> {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    final String format = "[^\\u4E00-\\u9FA5\\uF900-\\uFA2D\\w]";
    final Pattern pattern = Pattern.compile(format);
    final Matcher matcher = pattern.matcher(value);
    return !matcher.find();
  }
}
