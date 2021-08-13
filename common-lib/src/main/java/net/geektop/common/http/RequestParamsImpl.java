package net.geektop.common.http;

import java.net.URI;
import java.util.Map;

import static java.util.Objects.requireNonNull;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.http
 * @date 2020/11/29 22:56
 */
public class RequestParamsImpl implements RequestParams.Builder {

  private String uri;

  public RequestParamsImpl() {
  }

  public RequestParamsImpl(String uri) {
    requireNonNull(uri, "uri must be non-null");
    this.uri = uri;
  }

  @Override
  public RequestParamsImpl uri(String uri) {
    requireNonNull(uri, "uri must be non-null");
    this.uri = uri;
    return this;
  }

  // TODO can call many times
  @Override
  public RequestParamsImpl params(String key, String value) {
    this.uri = this.uri + "?" + key + "=" + value;
    return this;
  }

  @Override
  public RequestParamsImpl params(Map<String, String> params) {
    return null;
  }

  @Override
  public URI build() {
    return null;
  }

}
