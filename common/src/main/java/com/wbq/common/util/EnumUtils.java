package com.wbq.common.util;

import com.wbq.common.enumeration.BaseEnum;

/**
  *
  * @author biqin.wu@bianlifeng.com
  * @since 02 九月 2018
  */
public class EnumUtils {

	/**
	 * 根据code获得对应枚举类
	 * @param clazz 类
	 * @param code code
	 * @param <E> 枚举类型
	 * @return 枚举类型
	 */
	public static <E extends Enum<?> & BaseEnum> E getEnumByCode(Class<E> clazz, int code) {
		E[] enumConstants = clazz.getEnumConstants();
		for (E e : enumConstants) {
			if (e.getCode() == code) {
				return e;
			}
		}
		return null;
	}

	/**
	 * 根据msg获得对应枚举类
	 * @param clazz 类
	 * @param msg msg
	 * @param <E> 枚举类型
	 * @return 枚举类型
	 */
	public static <E extends Enum<?> & BaseEnum> E getEnumByMsg(Class<E> clazz, String msg) {
		E[] enumConstants = clazz.getEnumConstants();
		for (E e : enumConstants) {
			if (e.getMsg().equals(msg)) {
				return e;
			}
		}
		return null;
	}
}
