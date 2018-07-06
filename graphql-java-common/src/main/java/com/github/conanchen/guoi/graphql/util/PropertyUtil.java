package com.github.conanchen.guoi.graphql.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PropertyUtil {
    private static final Logger logger = LoggerFactory.getLogger(PropertyUtil.class);
    private static final String SET_PREFIX = "set";
    private static final String GET_PREFIX = "get";

    public static PropertyDescriptor getPropertyDescriptor(Class<?> clazz, String propertyName) {//根据需求，定制 自己的get和set方法
        Method setMethod;
        Method getMethod;
        PropertyDescriptor pd = null;
        try {
            Field field = clazz.getDeclaredField(propertyName);// 根据字段名来获取字段
            if (field != null) {
                // 构建方法的后缀
                String methodEnd = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
                setMethod = clazz.getDeclaredMethod(SET_PREFIX + methodEnd, new Class[] { field.getType() });
                // 构建get 方法
                getMethod = clazz.getDeclaredMethod(GET_PREFIX + methodEnd, new Class[] {});
                // 构建一个属性描述器 把对应属性 propertyName 的 get 和 set 方法保存到属性描述器中
                pd = new PropertyDescriptor(propertyName, getMethod, setMethod);
            }
        } catch (NoSuchFieldException ex) {

        } catch (Exception ex){
            ex.printStackTrace();
        }

        return pd;
    }
    public static void setProperty(Object obj, String propertyName, Object value) {
        Class<?> clazz = obj.getClass();// 获取对象的类型
        PropertyDescriptor pd = getPropertyDescriptor(clazz, propertyName);// 获取
        // clazz
        // 类型中的
        // propertyName
        // 的属性描述器
        Method setMethod = pd.getWriteMethod();// 从属性描述器中获取 set 方法
        try {
            setMethod.invoke(obj, new Object[] { value });// 调用 set
            // 方法将传入的value值保存属性中去
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setProperty(Object obj, Object value,PropertyDescriptor pd) {
        Method setMethod = pd.getWriteMethod();// 从属性描述器中获取 set 方法
        try {
            setMethod.invoke(obj, new Object[] { value });// 调用 set
            // 方法将传入的value值保存属性中去
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object getProperty(Object obj, String propertyName) {
        Class<?> clazz = obj.getClass();// 获取对象的类型
        String methodEnd = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
        Object value = null;
        try {
            Method getMethod = clazz.getDeclaredMethod(GET_PREFIX + methodEnd, new Class[] {});
            value = getMethod.invoke(clazz, new Object[] {});// 调用方法获取方法的返回值
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;// 返回值
    }

    public static Object getProperty(Object obj,Class clazz, String propertyName) {
        String methodEnd = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
        Object value = null;
        try {
            Method getMethod = clazz.getDeclaredMethod(GET_PREFIX + methodEnd, new Class[] {});
            value = getMethod.invoke(obj, new Object[] {});// 调用方法获取方法的返回值
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return value;// 返回值
    }
    public static Object getProperty(Object obj,PropertyDescriptor pd) {
        Method getMethod = pd.getReadMethod();// 从属性描述器中获取 get 方法
        Object value = null;
        try {
            value = getMethod.invoke(obj, new Object[] {});// 调用方法获取方法的返回值
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;// 返回值
    }
}