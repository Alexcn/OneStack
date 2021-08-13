package net.geektop.common.encryption;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.encryption
 * @date 2020/6/15 16:33
 */
@SpringBootTest
public class DESEncryptionTest {

  private static final Logger logger = LoggerFactory.getLogger(DESEncryptionTest.class);


  @Test
  void testEncrypt() {
    String content = "dfsdfsdfsd中文fwewerrrerwerwrwerwe";

    //随机生成密钥
    byte[] key = "8kEV4S94X5hlTTTu".getBytes();
    System.out.println(Arrays.toString(key));
    System.out.println(key.length);

    //构建
    SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);

    //加密
    byte[] encrypt = aes.encrypt(content);
    //解密
    byte[] decrypt = aes.decrypt(encrypt);

    //加密为16进制表示
    String encryptHex = aes.encryptHex(content);
    System.out.println("encryptHex content: " + encryptHex);
    //解密为字符串
    String decryptStr = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);

    System.out.println(decryptStr);
  }
}
