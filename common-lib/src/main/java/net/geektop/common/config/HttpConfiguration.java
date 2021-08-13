package net.geektop.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;
import java.time.Duration;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.web.config
 * @date 2020/10/23 10:49
 */
@Configuration
public class HttpConfiguration {

  @Bean(name = "http11Client")
  public HttpClient getHttp11Client() {
    return HttpClient.newBuilder()
      .version(HttpClient.Version.HTTP_1_1)
      .connectTimeout(Duration.ofSeconds(15L))
      .build();
  }

  @Bean(name = "http2Client")
  public HttpClient getHttp2Client() {
    return HttpClient.newBuilder()
      .version(HttpClient.Version.HTTP_2)
      .connectTimeout(Duration.ofSeconds(15L))
      .build();
  }

}
