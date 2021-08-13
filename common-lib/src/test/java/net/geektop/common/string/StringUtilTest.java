package net.geektop.common.string;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.string
 * @date 2020/11/23 20:36
 */
@SpringBootTest
class StringUtilTest {

  private static final Logger logger = LoggerFactory.getLogger(StringUtilTest.class);

  @Test
  void isNotBlank() {
    assertFalse(StringUtil.isNotBlank(StringPool.SPACE));
    assertFalse(StringUtil.isNotBlank(StringPool.TAB));
    assertFalse(StringUtil.isNotBlank(StringPool.NEWLINE));
    assertFalse(StringUtil.isNotBlank(StringPool.SPACE + StringPool.NEWLINE + StringPool.TAB));
    assertTrue(StringUtil.isNotBlank(StringPool.SPACE + StringPool.TAB + "abc"));
  }

  @Test
  void isBlank() {
    Map<String, String> of = ImmutableMap.of(
      "aaa", "fff",
      "ddd", "345");
  }

  @Test
  void isEmpty() {
  }

  @Test
  void isNotEmpty() {
  }

  @Test
  void randomString() {
    final String s = StringUtil.randomString(new Random().nextLong());
    Assertions.assertTrue(s.length() > 1);
  }

  @Test
  void testRandomString() {
    final String s = StringUtil.randomString();
    Assertions.assertTrue(s.length() > 20);
  }

  @Test
  void format() {
  }

  @Test
  void repeat() {
  }
}
