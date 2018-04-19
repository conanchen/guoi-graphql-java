package com.github.conanchen.guoi.graphql.util;

import java.lang.reflect.Method;

public class BeanUtil {

    /**
     * 普通Bean转换
     */
    public static Object convert(Object srcBean,Class dstCls){

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
            return dstBean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * mongoBean转为grpcBean
     */
    public static Object toGrpc(Object srcBean,Class grpcCls) {
        try {
            Class cls = srcBean.getClass();
            Object grpcB = grpcCls.getMethod("newBuilder").invoke(null);

            Class clsG = grpcB.getClass();

            Method[] methods = clsG.getMethods();
            for (Method method : methods) {
                String name = method.getName();

                if ((name.startsWith("set") || name.startsWith("addAll")) && !(name.endsWith("Value")||name.endsWith("Field") || name.endsWith("Fields") || name.endsWith("Bytes"))) {

                    Class[] paramClss = method.getParameterTypes();

                    if (paramClss.length == 1) {
                        String paramName = paramClss[0].getName();
                        if (!paramName.contains("$Builder")) {
                            System.out.println(name + "(" + paramName + ")");

                            String getMethodName = name.replace("set", "get");
                            if (name.startsWith("addAll"))
                                getMethodName = name.replace("addAll", "get") + "s";
                            try {
                                Method getMethod = cls.getMethod(getMethodName);
                                Object ret = getMethod.invoke(srcBean); //get方法返回值   Address
//                                if(!isNullObject(ret,false)){
                                if(ret != null && !"".equals(ret.toString()) && !"0.0".equals(ret.toString())) {
                                    if (paramName.startsWith("java") || paramClss[0].getPackage() == null ) {
                                        method.invoke(grpcB, ret);  //赋值给grpc的set方法
                                    } else {
                                        //复杂类型
                                        if(ret instanceof  Enum) {
                                            Object val = ret.getClass().getMethod("name").invoke(ret);
                                            method.invoke(grpcB, paramClss[0].getMethod("valueOf",String.class).invoke(null,val));   //执行set方法
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
            return ret;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //grpcBean转为普通Bean
    public static Object fromGrpc(Object grpcBean,Class cls) {
        try {
            Object bean = cls.newInstance();
            Class grpcCls = grpcBean.getClass();
            Method[] methods = grpcCls.getMethods();
            for (Method method : methods) {
                String name = method.getName();
                if (name.startsWith("get") && !(name.endsWith("Class") || name.endsWith("DefaultInstance") || name.endsWith("SerializedSize") || name.endsWith("Descriptor") || name.endsWith("Field") || name.endsWith("Fields") || name.endsWith("Bytes") || name.endsWith("Builder") || name.endsWith("ForType") || name.endsWith("ErrorString") || name.endsWith("FieldCount"))) {
                    if (!method.getReturnType().getName().contains("com.google.protobuf")) {
                        if (method.getParameterCount() == 0) {
                            Object ret = method.invoke(grpcBean);
//                            System.out.println("ret ====== " + ret.toString());
                            if(ret != null && !"".equals(ret.toString()) && !"0.0".equals(ret.toString())) {
//                            if(!isNullObject(ret,false)){
                                Class retCls = method.getReturnType();

                                String setMethodName = name.replace("get", "set");

                                Method[] clsMethods = cls.getMethods();
                                for (Method clsMethod : clsMethods) {
                                    if (clsMethod.getName().equals(setMethodName)) {

                                        if (retCls.getName().startsWith("java") || retCls.getPackage() == null) {
                                            clsMethod.invoke(bean, ret);
                                        } else {
                                            System.out.println(name + "    " + retCls.getName());
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
                        }
                    }

                }
            }
            return bean;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


//    public static void main(String[] args) throws Exception {

//        Org8n org8n = new Org8n();
//        org8n.setStatus(1);
//        org8n.setParent(new Org8n("ddddddd"));
//        org8n.setTheme("default");
//        org8n.setType(Org8nType.STATION);
//        Address addr1 = new Address();
//        addr1.setAddress1("地址1");
//        addr1.setAddress2("地址2");
//        addr1.setProvince("省份");
//        org8n.setAddress(addr1);
//        com.github.conanchen.guoi.cloud.org8n.Org8n org = (com.github.conanchen.guoi.cloud.org8n.Org8n)toGrpc(org8n,com.github.conanchen.guoi.cloud.org8n.Org8n.class);
//        System.out.println(org.getType().name());
//
//        org8n = (Org8n)fromGrpc(org,Org8n.class);
//        System.out.println(org8n.getType());
//    }
}
