package com.wbq.common.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
  *	注解工具类
  * @author biqin.wu@bianlifeng.com
  * @since 01 九月 2018
  */
public class AnnotationUtils {

	/**
	 * 获得类上的指定注解
	 * @param clazz 目标类
	 * @param annotationClass 注解类的class
	 * @return 注解对象
	 */
	public static <A extends Annotation> A getAnnotationByClass(Class<?> clazz, Class<A> annotationClass) {
		return clazz.getAnnotation(annotationClass);
	}

	/**
	 * 获得方法上的指定注解
	 * @param method 目标方法
	 * @param annotationClass 注解类的class
	 * @return 注解对象
	 */
	public static <A extends Annotation> A getAnnotationByMethod(Method method, Class<A> annotationClass) {
		return method.getAnnotation(annotationClass);
	}

	/**
	 * 获得变量上的指定注解
	 * @param field 目标变量
	 * @param annotationClass 注解类的class
	 * @return 注解对象
	 */
	public static <A extends Annotation> A getAnnotationByField(Field field, Class<A> annotationClass) {
		return field.getAnnotation(annotationClass);
	}
}
