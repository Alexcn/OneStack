package net.geektop.common.encryption;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.encryption
 * @date 2020/6/22 23:21
 */
public class AESEncryptionHelper {
  private AESEncryptionHelper() {
    throw new AssertionError();
  }

  private SymmetricCrypto getAesCrypto(final String aesKey) {
    byte[] key = aesKey.getBytes();
    return new SymmetricCrypto(SymmetricAlgorithm.AES, key);
  }

  public String decode(String hexContent, String aesKey) throws Exception {
    final SymmetricCrypto aes = getAesCrypto(aesKey);
    return aes.decryptStr(hexContent, CharsetUtil.CHARSET_UTF_8);
  }

  public String encode(String content, String aesKey) {
    final SymmetricCrypto aes = getAesCrypto(aesKey);
    return aes.encryptHex(content);
  }
}
