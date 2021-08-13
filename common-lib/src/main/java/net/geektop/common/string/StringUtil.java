package net.geektop.common.string;

import com.google.common.primitives.Longs;
import org.apache.commons.lang3.StringUtils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Base64;
import java.util.Map;
import java.util.UUID;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.string
 * @date 2020/10/22 18:37
 */
public class StringUtil {

  public static boolean isNotBlank(CharSequence cs) {
    return StringUtils.isNotBlank(cs);
  }

  public static boolean isBlank(CharSequence cs) {
    return StringUtils.isBlank(cs);
  }

  public static boolean isEmpty(CharSequence cs) {
    return StringUtils.isEmpty(cs);
  }

  public static boolean isNotEmpty(CharSequence cs) {
    return StringUtils.isNotEmpty(cs);
  }


  public static String randomString(long num) {
    final byte[] bytes = Longs.toByteArray(num);
    return Base64.getEncoder().encodeToString(bytes);
  }

  public static String randomString() {
    final UUID uuid = UUID.randomUUID();
    final byte[] bytes = new byte[16];
    ByteBuffer.wrap(bytes)
      .order(ByteOrder.BIG_ENDIAN)
      .putLong(uuid.getMostSignificantBits())
      .putLong(uuid.getLeastSignificantBits());
    return Base64.getEncoder().encodeToString(bytes);
  }

  public static String format(CharSequence cs, Map<String, String> objectMap) {
    String result = cs.toString();
    for (Map.Entry<String, String> entry : objectMap.entrySet()) {
      String key = '{' + entry.getKey() + '}';
      if (StringUtils.contains(cs, key)) {
        result = result.replace(key, entry.getValue());
      }
    }
    return result;
  }

  public static String repeat(char c, int count) {
    return StringUtils.repeat(c, count);
  }

  private StringUtil() {
    throw new AssertionError();
  }
}
