package com.github.conanchen.guoi.graphql.util;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BeanUtil {

    /**
     * 普通Bean转换
     */
    public static <T> T convert(Object srcBean,Class<T> dstCls){

        try {
            Class srcCls = srcBean.getClass();
            Object dstBean = dstCls.newInstance();
            Method[] methods = dstCls.getMethods();
            for (Method method : methods) {
                if(method.getName().startsWith("set")){
                    Class[] paramClss = method.getParameterTypes();
                    if(paramClss.length == 1) {
                        String paramName = paramClss[0].getName();
                        try{
                            Method getMethod = srcCls.getMethod(method.getName().replace("set", "get"));
                            Object ret = getMethod.invoke(srcBean); //get方法返回值
                            if (ret != null && !"".equals(ret.toString()) && !"0.0".equals(ret.toString())) {
                                if (paramName.startsWith("java") || paramClss[0].getPackage() == null) {
                                    method.invoke(dstBean, ret);
                                } else {
                                    //复杂类型
                                    if (ret instanceof Enum) {
                                        Object val = ret.getClass().getMethod("name").invoke(ret);
                                        method.invoke(dstBean, paramClss[0].getMethod("valueOf", String.class).invoke(null, val));   //执行set方法
                                    } else {
                                        method.invoke(dstBean, convert(ret, paramClss[0]));
                                    }
                                }
                            }
                        }catch (Exception ee){
                            continue;
                        }
                    }
                }
            }
            return (T)dstBean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * mongoBean转为grpcBean
     */
    public static <T> T toGrpc(Object srcBean,Class<T> grpcCls) {
        try {
            Class cls = srcBean.getClass();
            Object grpcB = grpcCls.getMethod("newBuilder").invoke(null);

            Class clsG = grpcB.getClass();

            Method[] methods = clsG.getMethods();
            for (Method method : methods) {
                String name = method.getName();

                if ((name.startsWith("set") || name.startsWith("add")) && !(name.startsWith("addAll") || name.endsWith("Value")||name.endsWith("Field") || name.endsWith("Fields") || name.endsWith("Bytes"))) {

                    Class[] paramClss = method.getParameterTypes();

                    if (paramClss.length == 1) {
                        String paramName = paramClss[0].getName();
                        if (!paramName.contains("$Builder")) {
                            //System.out.println(name + "(" + paramName + ")");

                            String getMethodName = name.replace("set", "get");
                            if (name.startsWith("add"))
                                getMethodName = name.replace("add", "get") + "s";
                            try {
                                Method getMethod = cls.getMethod(getMethodName);
                                Object ret = getMethod.invoke(srcBean); //get方法返回值   Address
//                                if(!isNullObject(ret,false)){

                                if(ret != null && !"".equals(ret.toString()) && !"0.0".equals(ret.toString())) {
                                    if (paramName.startsWith("java") || paramClss[0].getPackage() == null ) {
                                        if(ret instanceof java.lang.Iterable) {
                                            for(Object obj : (Iterable) ret){
                                                if(paramClss[0].getName().startsWith("java")) {
                                                    method.invoke(grpcB, obj);
                                                }else{
                                                    method.invoke(grpcB, toGrpc(obj, paramClss[0]));
                                                }
                                            }
                                        }else{
                                            method.invoke(grpcB,ret);
                                        }
                                    } else {
                                        //复杂类型
                                        if(ret instanceof  Enum) {
                                            Object val = ret.getClass().getMethod("name").invoke(ret);
                                            method.invoke(grpcB, paramClss[0].getMethod("valueOf",String.class).invoke(null,val));   //执行set方法
                                        }else if(ret instanceof java.lang.Iterable) {
                                            for(Object obj : (Iterable) ret){
                                                method.invoke(grpcB,toGrpc(obj,paramClss[0]));
                                            }
                                        }else{
                                            method.invoke(grpcB, toGrpc(ret, paramClss[0]));
                                        }
                                    }
                                }
                            } catch (NoSuchMethodException e) {
                                continue;
                            }

                        }
                    }
                }
            }
            Object ret = clsG.getMethod("build").invoke(grpcB);
            return (T) ret;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //grpcBean转为普通Bean
    public static <T> T fromGrpc(Object grpcBean,Class<T> cls) {
        try {
            Object bean = cls.newInstance();
            Class grpcCls = grpcBean.getClass();
            Method[] methods = grpcCls.getMethods();
            for (Method method : methods) {
                String name = method.getName();
                if (name.startsWith("get") && !(name.endsWith("Class") || name.endsWith("DefaultInstance") || name.endsWith("SerializedSize") || name.endsWith("Descriptor") || name.endsWith("Field") || name.endsWith("Fields") || name.endsWith("Bytes") || name.endsWith("Builder") || name.endsWith("Builders") || name.endsWith("ForType") || name.endsWith("ErrorString") || name.endsWith("FieldCount"))) {
                    if (!method.getReturnType().getName().contains("com.google.protobuf")) {
                        Class retCls = method.getReturnType();
                        if (method.getParameterCount() == 0) {
                            Object ret = method.invoke(grpcBean); //grpc get方法取值
                            if(ret != null && !"".equals(ret.toString()) && !"0.0".equals(ret.toString())) {
//                            if(!isNullObject(ret,false)){

                                String setMethodName = name.replace("get", "set");


                                Method[] clsMethods = cls.getMethods();
                                for (Method clsMethod : clsMethods) {
                                    if (clsMethod.getName().equals(setMethodName)) {

                                        if (retCls.getName().startsWith("java") || retCls.getPackage() == null) {
                                            clsMethod.invoke(bean, ret);
                                        } else {
//                                            System.out.println(name + "    " + retCls.getName());
                                            if(ret instanceof Enum) {
                                                Object val = ret.getClass().getMethod("name").invoke(ret);

                                                clsMethod.invoke(bean, clsMethod.getParameterTypes()[0].getMethod("valueOf",String.class).invoke(null,val));   //执行set方法

                                            }else{
                                                clsMethod.invoke(bean, fromGrpc(ret, clsMethod.getParameterTypes()[0]));
                                            }
                                        }
                                    }
                                }
                            }
                        }else if(method.getParameterCount() == 1) {
                            try{
                                Method cntMethod = grpcCls.getMethod(method.getName() + "Count");
                                if (null != cntMethod) {
                                    String setMethodName = method.getName().replace("get", "set") + "s";
                                    String fieldName = method.getName().replace("get", "") + "s";
                                    Type t = cls.getDeclaredField(toLowerCaseFirstOne(fieldName)).getGenericType();

                                    Type t1 = null;
                                    if (ParameterizedType.class.isAssignableFrom(t.getClass())) {
                                        t1 = ((ParameterizedType) t).getActualTypeArguments()[0];
                                    }

                                    Method[] clsMethods = cls.getMethods();
                                    for (Method setMethod : clsMethods) {
                                        if (setMethod.getName().equals(setMethodName)) {

                                            Integer cnt = (Integer) cntMethod.invoke(grpcBean, null);
                                            if (null != cnt) {
                                                List list = new ArrayList();
                                                for (int i = 0; i < cnt; i++) {
                                                    Object val = method.invoke(grpcBean, i);
                                                    if(t1.getTypeName().startsWith("java")){
                                                        list.add(val);
                                                    }else {
                                                        Object obj = fromGrpc(val, Class.forName(t1.getTypeName())); //getServiceRange(1);
                                                        list.add(obj);
                                                    }
                                                }
                                                setMethod.invoke(bean, list);
                                            }
                                        }
                                    }


                                }
                            }catch (Exception ee){
                                System.out.println(ee.getMessage());
                                continue;
                            }
                        }
                    }

                }
            }
            return (T)bean;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }


    public static void main(String[] args) throws Exception {


    }
}
