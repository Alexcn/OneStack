package net.geektop.common.excel;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.excel
 * @date 2020/2/19 00:53
 */
@AllArgsConstructor
public class WriteExcel<T> {
  private final T data;
  public InputStream export(List<String> headerNames, List<T> dataList) throws IOException {
    return null;
  }

  public InputStream exportMultiHeader(List<Map<String, List<String>>> headerNames, List<T> dataList) throws IOException {
    return null;
  }
}
