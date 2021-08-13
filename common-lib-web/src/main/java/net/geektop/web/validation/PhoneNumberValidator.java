package net.geektop.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.web.validation
 * @date 2020/10/20 12:09
 */
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

  // test https://tool.oschina.net/regex/
  private final static String REGEX_MOBILE = "0?(13|14|15|17|18|19)[0-9]{9}";

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    final Pattern pattern = Pattern.compile(REGEX_MOBILE);
    final Matcher matcher = pattern.matcher(value);
    return matcher.find();
  }

}
