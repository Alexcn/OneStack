package net.geektop.web.handler.type;

import org.apache.ibatis.type.*;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.account.handler
 * @date 2020/4/20 11:45
 */
@MappedTypes(ArrayList.class)
@MappedJdbcTypes(JdbcType.ARRAY)
public class ListTypeHandler extends BaseTypeHandler<List<Object>> {
  private static final String TYPE_NAME_VARCHAR = "varchar";
  private static final String TYPE_NAME_INTEGER = "integer";
  private static final String TYPE_NAME_BOOLEAN = "boolean";
  private static final String TYPE_NAME_NUMERIC = "numeric";
  private static final String TYPE_NAME_DECIMAL = "numeric";

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, List<Object> parameter, JdbcType jdbcType) throws SQLException {
    if (parameter != null && !parameter.isEmpty()) {
      String typeName = null;
      Object firstObject = parameter.get(0);
      if (firstObject instanceof String) {
        typeName = TYPE_NAME_VARCHAR;
      } else if (firstObject instanceof Integer) {
        typeName = TYPE_NAME_INTEGER;
      } else if (firstObject instanceof Boolean) {
        typeName = TYPE_NAME_BOOLEAN;
      } else if (firstObject instanceof Double) {
        typeName = TYPE_NAME_NUMERIC;
      } else if (firstObject instanceof BigDecimal) {
        typeName = TYPE_NAME_DECIMAL;
      }
      if (typeName == null) {
        throw new TypeException("ArrayTypeHandler parameter typeName error, your type is: " + parameter.getClass().getName());
      }

      final Connection connection = ps.getConnection();
      final Array array = connection.createArrayOf(typeName, parameter.toArray());
      ps.setArray(i, array);
    }
  }

  @Override
  public List<Object> getNullableResult(ResultSet rs, String columnName) throws SQLException {
    return getList(rs.getArray(columnName));
  }

  @Override
  public List<Object> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    return getList(rs.getArray(columnIndex));
  }

  @Override
  public List<Object> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    return getList(cs.getArray(columnIndex));
  }

  private List<Object> getList(Array array) {
    if (array == null) {
      return null;
    }
    try {
      return Collections.singletonList(array);
    } catch ( Exception e) {
      return null;
    }
  }
}
