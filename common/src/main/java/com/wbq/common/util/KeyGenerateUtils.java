package com.wbq.common.util;

import java.util.UUID;

/**
  *
  * @author biqin.wu
  * @since 02 九月 2018
  */
public class KeyGenerateUtils {

	public static String generateKey() {
		String uuid = UUID.randomUUID().toString();
		return uuid.replaceAll("-", "");
	}
}
