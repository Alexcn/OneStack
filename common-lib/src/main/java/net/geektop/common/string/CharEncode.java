package net.geektop.common.string;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.string
 * @date 2020/11/24 00:17
 */
public interface CharEncode {
  Charset US_ASCII = StandardCharsets.US_ASCII;
  Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
  Charset UTF8 = StandardCharsets.UTF_8;
  Charset UTF16 = StandardCharsets.UTF_16;
  Charset GBK = Charset.forName("GBK");
  Charset GB18030 = Charset.forName("GB18030");
  Charset GB2312 = Charset.forName("GB2312");
  Charset BIG5 = Charset.forName("Big5");
  Charset Big5_HKSCS = Charset.forName("Big5-HKSCS");
}
