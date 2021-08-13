package net.geektop.common.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.http
 * @date 2020/12/9 00:49
 */
@Getter
@AllArgsConstructor
public enum AgentName {
  CHROME("Chrome"),
  FIREFOX("Firefox"),
  SAFARI("Safari"),
  EDGE("Edg"),
  OPERA("Opera"),
  IE("MSIE");

  private final String name;
}
