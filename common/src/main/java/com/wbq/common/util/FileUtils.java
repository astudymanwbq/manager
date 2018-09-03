package com.wbq.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.zip.GZIPOutputStream;

/**
  *
  * @author biqin.wu
  * @since 03 September 2018
  */
public class FileUtils {

	private static final char EXTENSION_SEPARATOR = '.';

	private static final char UNIX_SEPARATOR = '/';

	private static final char WINDOWS_SEPARATOR = '\\';

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

	/**
	 * 复制文件
	 * @param source 文件源
	 * @param destination 目标文件
	 * @throws IOException io异常
	 */
	public static void copyFile(File source, File destination) throws IOException {
		if (source == null || !source.exists()) {
			return;
		}
		if (destination == null) {
			return;
		}
		if (!destination.exists()) {
			destination.createNewFile();
		}
		try (FileInputStream input = new FileInputStream(source); FileOutputStream output = new FileOutputStream(destination)) {
			FileChannel inputChannel = input.getChannel();
			FileChannel outputChannel = output.getChannel();
			outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
		}
	}

	private static boolean isExtension(String filename, String[] extensions) {
		if (filename == null) {
			return false;
		}
		if (extensions == null || extensions.length == 0) {
			return ((indexOfExtension(filename)) == -1);
		}
		String fileExt = getExtension(filename);
		for (String extension : extensions) {
			if (fileExt.equals(extension)) {
				return true;
			}
		}
		return false;
	}

	private static String removeExtension(String filename) {
		if (filename == null) {
			return null;
		}
		int index = indexOfExtension(filename);
		if (index == -1) {
			return filename;
		}
		else {
			return filename.substring(0, index);
		}
	}

	private static String getExtension(String filename) {
		if (filename == null) {
			return null;
		}
		int index = indexOfExtension(filename);
		if (index == -1) {
			return "";
		}
		else {
			return filename.substring(index + 1);
		}
	}

	private static int indexOfExtension(String filename) {
		if (filename == null) {
			return -1;
		}
		int extensionPos = filename.lastIndexOf(EXTENSION_SEPARATOR);
		int lastSeparator = indexOfLastSeparator(filename);
		return (lastSeparator > extensionPos) ? -1 : extensionPos;
	}

	private static int indexOfLastSeparator(String filename) {
		if (filename == null) {
			return -1;
		}
		int lastUnixPos = filename.lastIndexOf(UNIX_SEPARATOR);
		int lastWindowsPos = filename.lastIndexOf(WINDOWS_SEPARATOR);
		return Math.max(lastUnixPos, lastWindowsPos);
	}

}
