package net.geektop.common.http;

import com.google.common.net.HttpHeaders;

import java.net.URI;
import java.net.http.HttpRequest;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.crawler.common.http
 * @date 2020/12/12 23:49
 */
public class RequestUtils {

  public static HttpRequest buildCrawlerGetRequest(String uri) {
    return buildCrawlerGetRequest(URI.create(uri));
  }

  public static HttpRequest buildCrawlerGetRequest(String url, String referer) {
    return HttpRequest.newBuilder()
      .GET()
      .uri(URI.create(url))
      .header(HttpHeaders.USER_AGENT, UserAgent.fake())
      .header(HttpHeaders.REFERER, referer)
      .build();
  }

  public static HttpRequest buildCrawlerGetRequest(URI uri) {
    return HttpRequest.newBuilder()
      .GET()
      .uri(uri)
      .header(HttpHeaders.USER_AGENT, UserAgent.fake())
      .build();
  }

}
