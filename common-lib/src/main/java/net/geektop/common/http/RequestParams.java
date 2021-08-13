package net.geektop.common.http;

import java.net.URI;
import java.util.Map;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.http
 * @date 2020/11/27 23:06
 */
public abstract class RequestParams {

  public interface Builder {

    Builder uri(String uri);

    Builder params(String key, String value);

    Builder params(Map<String, String> params);

    URI build();

  }

  public static RequestParams.Builder newBuilder() {
    return new RequestParamsImpl();
  }

}
