package net.geektop.web.aop;

import lombok.extern.slf4j.Slf4j;
import net.geektop.web.env.EnvConfig;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.aop
 * @date 2020/1/13 23:46
 */

@Aspect
@Slf4j
@Component
public class SentryClientAspect {

  private EnvConfig envConfig;

  @Autowired
  public void setEnvConfig(EnvConfig envConfig) {
    this.envConfig = envConfig;
  }

  @Around("execution(* io.sentry.SentryClient.send*(..))")
  public void around(ProceedingJoinPoint joinPoint) throws Throwable {
    // no sentry logging in debug mode
    if (envConfig.isDebug()) {
      log.debug("no sentry logging in debug mode");
      return;
    }
    joinPoint.proceed();
  }
}
