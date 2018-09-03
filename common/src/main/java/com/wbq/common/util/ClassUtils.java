package com.wbq.common.util;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

import com.google.common.base.Splitter;
import com.google.common.collect.Sets;
import com.sun.xml.internal.fastinfoset.Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  *
  * @author biqin.wu
  * @since 01 九月 2018
  */
public class ClassUtils {
	private static final Logger logger = LoggerFactory.getLogger(ClassUtils.class.getName());

	/**是否迭代*/
	private static final boolean RECURSIVE = true;

	/**
	 * 通过包名获取报下的所有类
	 * @param pkg 包
	 * @return 类容器
	 */
	public static Set<Class<?>> getClassesByPackage(Package pkg) {
		String packageName = pkg.getName();
		return getClasses(packageName);
	}

	/**
	 *	获得指定包下实现clazz接口的全部类
	 * @param clazz 接口
	 * @param packageName 包名
	 * @return 类容器
	 */
	public static Set<Class<?>> getClassesByInterface(Class<?> clazz, String packageName) {
		if (clazz.isInterface()) {
			Set<Class<?>> classSet = getClasses(packageName);
			if (classSet != null) {
				return classSet.stream().filter(c -> c.isAssignableFrom(clazz)).collect(Collectors.toSet());
			}
		}
		return Collections.emptySet();
	}

	/**
	 * 取得某一类所在包的所有类名 不含迭代
	 * @param classLocation 类
	 * @param packageName 包名
	 * @return 包名集合
	 */
	public static String[] getAllClassName(String classLocation, String packageName) {
		Splitter splitter = Splitter.on(".");
		StringBuilder realLocation = new StringBuilder(classLocation);
		List<String> packagePath = splitter.trimResults().splitToList(packageName);
		packagePath.forEach(path -> realLocation.append(File.separator).append(path));
		File packageDir = new File(realLocation.toString());
		if (packageDir.isDirectory()) {
			return packageDir.list();
		}
		return (String[]) Collections.emptyList().toArray();
	}

	/**
	 * 获得包路径下的所有类
	 * @param packageName 包名
	 * @return 类容器
	 */
	public static Set<Class<?>> getClasses(String packageName) {
		//第一个class的类集合
		Set<Class<?>> classes = Sets.newHashSet();
		//获取包的名字
		String pack = packageName;
		String packageDirName = pack.replace('.', '/');
		Enumeration<URL> dirs;
		try {
			dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
			while (dirs.hasMoreElements()) {
				URL url = dirs.nextElement();
				String protocol = url.getProtocol();
				//文件形式
				if ("file".equals(protocol)) {
					logger.info("file类型的文件扫描");
					//得到包的物理路径
					String filePath = URLDecoder.decode(url.getFile(), Encoder.UTF_8);
					findAndAddClasses(packageName, filePath, RECURSIVE, classes);
				}
				else if ("jar".equals(protocol)) {
					logger.info("jar类型的文件扫描");
					//获取jar
					JarFile jarFile = ((JarURLConnection) url.openConnection()).getJarFile();
					//获得这个jar包下的所有文件
					Enumeration<JarEntry> entries = jarFile.entries();
					while (entries.hasMoreElements()) {
						JarEntry jarEntry = entries.nextElement();
						String fileName = jarEntry.getName();

						if (fileName.charAt(0) == '/') {
							fileName = fileName.substring(1);
						}
						if (fileName.startsWith(packageDirName)) {
							int idx = fileName.lastIndexOf('/');
							if (idx != -1) {
								//获取包名 将/ 替换为 .
								packageName = fileName.substring(0, idx).replace('/', '.');
							}
							if (idx != -1 || RECURSIVE) {
								//如果是class文件 且entry不是目录
								if (!jarEntry.isDirectory() && fileName.endsWith(".class")) {
									//获取类名
									String className = fileName.substring(packageName.length() + 1,
											fileName.length() - 6);
									String classPath = packageName + "." + className;
									//添加到容器中
									logger.info("添加类->{}", classPath);
									classes.add(Class.forName(classPath));
								}
							}
						}

					}
				}
			}
		}
		catch (IOException | ClassNotFoundException e) {
			logger.error(e.getMessage());
		}
		return classes;
	}

	/**
	 * 在包中加载类
	 * @param packageName 包名
	 * @param filePath 文件路径
	 * @param recursive 迭代
	 * @param classes 类容器
	 */
	private static void findAndAddClasses(String packageName, String filePath, final boolean recursive, Set<Class<?>> classes) {
		//获取报的目录
		File dir = new File(filePath);
		if (!dir.exists() || !dir.isDirectory()) {
			return;
		}
		//获得包下的所有文件 包括目录
		File[] files = dir.listFiles(file -> (recursive && file.isDirectory()) || (file.getName().endsWith(".class")));
		if (files == null || files.length == 0) {
			return;
		}
		for (File file : files) {
			//如果是目录继续扫描
			if (file.isDirectory()) {
				findAndAddClasses(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, classes);
			}
			else {
				//去掉.class 得到类名
				String className = file.getName().substring(0, file.getName().length() - 6);
				String classPath = packageName + "." + className;
				logger.info("添加类->{}", classPath);
				try {
					Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass(classPath);
					classes.add(clazz);
				}
				catch (ClassNotFoundException e) {
					logger.error(e.getMessage());
				}
			}
		}

	}
}
