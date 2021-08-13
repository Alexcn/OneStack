package net.geektop.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.model
 * @date 2020/1/13 18:38
 */
@NoArgsConstructor
public abstract class PageResult<T> {
  public T rows;
  public int total;
  public int pageSize;

  public PageResult(T rows, int total, int pageSize) {
    this.rows = rows;
    this.total = total;
    this.pageSize = pageSize;
  }
  //  public abstract PageResult()
}

