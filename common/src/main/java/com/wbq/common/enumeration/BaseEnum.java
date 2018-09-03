package com.wbq.common.enumeration;

/**
  *	枚举的顶层父类
  * @author biqin.wu@bianlifeng.com
  * @since 02 九月 2018
  */
public interface BaseEnum {
	/**
	 * 获得编码
	 * @return code
	 */
	int getCode();


	/**
	 * 获得描述
	 * @return msg
	 */
	String getMsg();

}
