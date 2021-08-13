package net.geektop.common.system;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.system
 * @date 2020/12/9 00:47
 */
@Getter
@AllArgsConstructor
public enum Platform {
  IPHONE("iPhone"),
  IPAD("iPad"),
  WINDOWS("Windows NT"),
  LINUX("Linux"),
  MAC_OS("Macintosh"),
  ANDROID("Android");

  private final String name;
}
