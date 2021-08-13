package net.geektop.common.convert;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.convert
 * @date 2020/7/21 01:20
 */
public interface DTOConvert<S, T> {
  T convert(S s);
}
