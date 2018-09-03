package com.wbq.common.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wbq.common.enumeration.BaseEnum;
import com.wbq.common.util.EnumUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  *	mybatis中枚举和int的映射
  * @author biqin.wu@bianlifeng.com
  * @since 02 九月 2018
  */
public class EnumTypeHandler<E extends Enum<?> & BaseEnum> extends BaseTypeHandler<BaseEnum> {
	private static final Logger logger = LoggerFactory.getLogger(EnumTypeHandler.class.getName());

	private Class<E> type;

	public EnumTypeHandler(Class<E> type) {
		if (type == null) {
			throw new IllegalArgumentException("type argument cannot be null");
		}
		this.type = type;
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, BaseEnum param, JdbcType jdbcType) throws SQLException {
		ps.setInt(i, param.getCode());
	}

	@Override
	public BaseEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
		int code = rs.getInt(columnName);
		return rs.wasNull() ? null : getEnumByCode(code);
	}

	@Override
	public BaseEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		int code = rs.getInt(columnIndex);
		return rs.wasNull() ? null : getEnumByCode(code);
	}

	@Override
	public BaseEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		int code = cs.getInt(columnIndex);
		return cs.wasNull() ? null : getEnumByCode(code);
	}

	private E getEnumByCode(int code) {
		try {
			return EnumUtils.getEnumByCode(type, code);
		}
		catch (Exception e) {
			logger.error("cannot convert:{} to {} by code value ", code, type.getSimpleName());
			throw new IllegalArgumentException(e);
		}
	}
}
