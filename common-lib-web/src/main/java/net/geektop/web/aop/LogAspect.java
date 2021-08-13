package net.geektop.web.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.aop
 * @date 2020/1/12 20:30
 */

@Slf4j
@Aspect
@Order(5)
@Component
public class LogAspect {
}
