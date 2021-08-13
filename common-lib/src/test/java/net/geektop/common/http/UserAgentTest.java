package net.geektop.common.http;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.http
 * @date 2020/12/10 01:02
 */
@SpringBootTest
class UserAgentTest {

  @Test
  void fake() {
    final String fakeAgent = UserAgent.fake();
    assertFalse(fakeAgent.contains("%s"));
    assertFalse(fakeAgent.contains("{"));
  }

  @Test
  void testFake() {
  }

  @Test
  void fakeMobile() {
  }
}
