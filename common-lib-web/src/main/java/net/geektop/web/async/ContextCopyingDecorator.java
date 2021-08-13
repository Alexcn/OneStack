package net.geektop.web.async;

import org.springframework.core.task.TaskDecorator;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.web.async
 * @date 2020/7/23 16:09
 */
// https://stackoverflow.com/questions/23732089/how-to-enable-request-scope-in-async-task-executor
public class ContextCopyingDecorator implements TaskDecorator {
  @Override
  public Runnable decorate(Runnable runnable) {
    RequestAttributes context = RequestContextHolder.currentRequestAttributes();
    return () -> {
      try {
        RequestContextHolder.setRequestAttributes(context);
        runnable.run();
      } finally {
        RequestContextHolder.resetRequestAttributes();
      }
    };
  }
}
