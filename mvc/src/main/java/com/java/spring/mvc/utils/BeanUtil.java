package com.java.spring.mvc.utils;

import java.lang.reflect.*;

/**
 * @author renqingwang on 2018/4/1.
 * @version 1.0
 */
public class BeanUtil {
    public static <T> T instanceClass(Class<T> clazz) {
        if (!clazz.isInterface()) {
            try {
                return clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static <T> T instanceClass(Constructor<T> ctor, Object... args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return ctor.newInstance(args);
    }

    public static Method findMethod(Class<?> clazz, String methodName, Class<?>... paramTypes) {
        try {
            return clazz.getMethod(methodName, paramTypes);
        } catch (NoSuchMethodException e) {
            return findDeclareMethod(clazz, methodName, paramTypes);
        }
    }

    public static Method findDeclareMethod(Class<?> clazz, String methodName,Class<?>[] paramTypes) {
        try {
            return clazz.getDeclaredMethod(methodName, paramTypes);
        } catch (NoSuchMethodException e) {
            if (clazz.getSuperclass() != null) {
                return findDeclareMethod(clazz.getSuperclass(), methodName, paramTypes);
            }
            return null;
        }
    }

    public static void makeAccessible(Constructor<?> ctor) {
        if (!Modifier.isPublic(ctor.getModifiers())
                || !Modifier.isPublic(ctor.getDeclaringClass().getModifiers())
                && !ctor.isAccessible()) {
            ctor.setAccessible(true);
        }
    }

    public static Method[] findDeclareMethods(Class<?> clazz) {
        return clazz.getDeclaredMethods();
    }

    public static Field[] findDeclareFields(Class<?> clazz) {
        return clazz.getFields();
    }
}
