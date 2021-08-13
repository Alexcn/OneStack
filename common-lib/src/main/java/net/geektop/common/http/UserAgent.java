package net.geektop.common.http;

import net.geektop.common.system.Platform;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.http
 * @date 2020/12/8 23:25
 */
public final class UserAgent {

  private static final String LEADING = "Mozilla/5.0";
  private static final String BOT = "GeektopBot/2.1 (+http://www.geektop.net/bot.html)";
  private static final String COMMON_TAIL = "AppleWebKit/603.1.30 (KHTML, like Gecko) Version/10.0 Mobile/14E304 Safari/602.1";
  private static final String COMMON_VERSION = "AppleWebKit/537.36";
  private static final String SAFARI_VERSION = "Safari/537.36";

  public static String fake() {
    return String.format("%s (%s 10.0; Win64; x64) %s (KHTML, like Gecko) Chrome/86.0.4240.193 %s",
      LEADING, Platform.WINDOWS.getName(), COMMON_VERSION, SAFARI_VERSION);
  }

  public static String fake(Platform platform) {
    if (platform == Platform.MAC_OS)
      return String.format("%s (%s; Intel Mac OS X 10.16; rv:82.0) Gecko/20100101 %s/82.0",
        LEADING, Platform.MAC_OS, AgentName.FIREFOX);
    return fake();
  }

  public static String fakeMobile() {
    return String.format("%s (%s; CPU iPhone OS 10_3_1 like Mac OS X) %s", LEADING, Platform.IPHONE, COMMON_TAIL);
  }

}
