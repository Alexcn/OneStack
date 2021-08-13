package net.geektop.common.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.excel
 * @date 2020/2/19 00:53
 */
//@SpringBootTest
public class WriteExcelTest {

  private static final Logger logger = LoggerFactory.getLogger(WriteExcelTest.class);

  @Test
  public void writeTest() throws IOException {
    try (final OutputStream out = new FileOutputStream("/tmp/withoutHeader.xlsx")) {
      final ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, false);
      final Sheet sheet1 = new Sheet(1, 0);
      List<List<String>> data = new ArrayList<>();
      for (int i = 0; i < 100; i++) {
        List<String> item = new ArrayList<>();
        item.add("item0" + i);
        item.add("item1" + i);
        item.add("item2" + i);
        data.add(item);
      }
      writer.write0(data, sheet1);
      writer.finish();
    }
  }

  @Test
  public void writeExcelNew() throws IOException {
    String fileName = "/tmp/tt1.xlsx";
    EasyExcel.write(fileName).head(head()).sheet("模板").doWrite(dataList());
  }

  private List<List<Object>> dataList() {
    List<List<Object>> list = new ArrayList<List<Object>>();
    for (int i = 0; i < 10; i++) {
      List<Object> data = new ArrayList<Object>();
      data.add("字符串" + i);
      data.add(new Date());
      data.add(0.56);
      list.add(data);
    }
    return list;
  }

  private List<List<String>> head() {
    List<List<String>> list = new ArrayList<List<String>>();
    List<String> head0 = new ArrayList<String>();
    head0.add("字符串" + System.currentTimeMillis());
    List<String> head1 = new ArrayList<String>();
    head1.add("数字" + System.currentTimeMillis());
    List<String> head2 = new ArrayList<String>();
    head2.add("日期" + System.currentTimeMillis());
    list.add(head0);
    list.add(head1);
    list.add(head2);
    return list;
  }

}
