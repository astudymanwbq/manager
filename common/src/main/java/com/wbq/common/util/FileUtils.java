package com.wbq.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/**
  *
  * @author biqin.wu
  * @since 03 September 2018
  */
public class FileUtils {

	/**
	 * 压缩文件
	 * @param source 文件源
	 * @param destination 目标文件
	 * @param buffSize byte数组大小
	 */
	public static void compressFile(File source, File destination, int buffSize) {
		if (source == null) {
			return;
		}
		if (destination == null) {
			return;
		}
		try (InputStream input = new BufferedInputStream(new FileInputStream(source));
			 OutputStream output = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(destination)))) {
			final byte[] inbuf = new byte[buffSize];
			int n;
			while ((n = input.read(inbuf)) != -1) {
				output.write(inbuf, 0, n);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
