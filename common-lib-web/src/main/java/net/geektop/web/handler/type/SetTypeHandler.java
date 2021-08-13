package net.geektop.web.handler.type;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeException;

import java.sql.*;
import java.util.Set;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.account.handler
 * @date 2020/4/20 15:50
 */

@Slf4j
public class SetTypeHandler<T> extends BaseTypeHandler<T> {
  private final Class<T> type;
  public SetTypeHandler(Class<T> type) {
    this.type = type;
  }

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
    String typeName = null;
    if (parameter instanceof Set && !((Set) parameter).isEmpty()) {
      Object firstObject = ((Set) parameter).iterator().next();
      if (firstObject instanceof String) {
        typeName = "varchar";
      } else if (firstObject instanceof Integer) {
        typeName = "integer";
      } else if (firstObject instanceof Boolean) {
        typeName = "boolean";
      } else if (firstObject instanceof Double) {
        typeName = "numeric";
      }
    }

    if (typeName == null) {
      throw new TypeException(
        "SetTypeHandler parameter typeName error, your type is "
          + parameter.getClass().getName());
    }

    if (!((Set) parameter).isEmpty()) {
      Connection conn = ps.getConnection();
      // TODO convert set to array
      Array array = conn.createArrayOf(typeName, (Object[]) parameter);
      ps.setArray(i, array);
    }
  }

  @Override
  public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
    return null;
  }

  @Override
  public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    return null;
  }

  @Override
  public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    return null;
  }
}
