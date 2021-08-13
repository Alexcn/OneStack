package net.geektop.web.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.reading.config
 * @date 2020/7/1 18:07
 */
@Component
public class AutoFillHandler implements MetaObjectHandler {
  @Override
  public void insertFill(MetaObject metaObject) {

  }

  @Override
  public void updateFill(MetaObject metaObject) {
    this.strictUpdateFill(metaObject, "updatedAt", LocalDateTime.class, LocalDateTime.now());
    this.fillStrategy(metaObject, "updatedAt", LocalDateTime.now());
  }
}
