package com.github.conanchen.guoi.graphql.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Message;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;
import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

/**
 * @author hai
 * description 该工具类用于普通类转grpc参数及封装fieldMask
 * email hilin2333@gmail.com
 * date 2018/5/16 6:46 AM
 */
@Slf4j
public final class BeanToGrpcRequestUtil {
    private static final Gson gson = new GsonBuilder().create();
    private static final String FIELDMASK_NAME = "fieldMask";
    private static final ZoneOffset localZoneOffset = OffsetDateTime.now().getOffset();
    public static final com.google.common.base.Converter<String, String> DEFAULT_CONVERTER = PrincipleFormat.NAME.converterTo(PrincipleFormat.ID);

    public static <T extends Message> T toGrpc(String prefix,Object object,Message.Builder builder,FieldMask.Builder fieldMaskBuilder,com.google.common.base.Converter<String, String> converter) {
        return convert(prefix,object,builder,fieldMaskBuilder,converter);
    }

    public static <T extends Message> T toGrpc(Message.Builder builder, Object object) {
        return convert("",object,builder,FieldMask.newBuilder(),DEFAULT_CONVERTER);
    }
    private static <T extends Message> T convert(String prefix,Object object,Message.Builder builder,  FieldMask.Builder fieldMaskBuilder,com.google.common.base.Converter<String, String> converter){
        if (object == null) {
            return (T)builder.build();
        }
        if (prefix.indexOf(".") < 0 && (!"".equals(prefix) || prefix != null)){
            Descriptors.Descriptor descriptor = builder.getDescriptorForType();
            FieldDescriptor fieldDescriptor = descriptor.findFieldByName(prefix);
            Message.Builder subBuilder = builder.newBuilderForField(fieldDescriptor);
            Message subMessage = convertInternal(prefix,object,subBuilder,fieldMaskBuilder,converter);
            builder.setField(fieldDescriptor,subMessage);
        }else{
            convertInternal(prefix,object,builder,fieldMaskBuilder,converter);
        }
        setFieldMaskValue(builder.getDescriptorForType(), FIELDMASK_NAME, builder, fieldMaskBuilder);
        return (T)builder.build();
    }

    private static Message convertInternal(String prefix,Object object,Message.Builder builder,  FieldMask.Builder fieldMaskBuilder,com.google.common.base.Converter<String, String> converter) {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
                PropertyDescriptor propertyDescriptor = PropertyUtil.getPropertyDescriptor(object.getClass(), field.getName());
                if (propertyDescriptor == null){
                    continue;
                }
                Object o = PropertyUtil.getProperty(object, propertyDescriptor);
                if (o == null) {
                    continue;
                }
                String fieldName = converter == null ? field.getName() : converter.convert(field.getName());
                FieldDescriptor fieldDescriptor = builder.getDescriptorForType().findFieldByName(fieldName);
                // 如果是原始类
                if (BeanUtil.isWrapClass(field.getDeclaringClass())){
                    builder.setField(fieldDescriptor, buildValue(prefix,builder,fieldMaskBuilder, fieldDescriptor, o,converter));
                }else{
                    if (fieldDescriptor.isRepeated() && field.getGenericType() instanceof GenericArrayType){
                        for (Object obj : (List)o){
                            builder.addRepeatedField(fieldDescriptor, buildValue(prefix,builder,fieldMaskBuilder, fieldDescriptor, obj,converter));
                        }
                    } else if (field.getDeclaringClass().isArray()){
                        //ignore
                    } else{
                        builder.setField(fieldDescriptor, buildValue(prefix,builder,fieldMaskBuilder, fieldDescriptor, o,converter));
                    }
                }
        }
        return builder.build();
    }

    private static Object buildValue(String lastLevel,
                                    Message.Builder parentBuilder,
                                     FieldMask.Builder fieldMaskBuilder,
                                     FieldDescriptor field,
                                     Object value,
                                     com.google.common.base.Converter<String, String> converter) {
        lastLevel = lastLevel + "." + field.getName();
        if (field.getType() == FieldDescriptor.Type.MESSAGE) {
            // date 转 timestamp
            if (parentBuilder.getField(field).getClass().getName().equals(Timestamp.class.getName()) && value instanceof Date) {
                if (value instanceof Date) {
                    fieldMaskBuilder.addPaths(lastLevel);
                    return Timestamps.fromMillis(((Date) value).getTime());
                }else if (value instanceof LocalDateTime){
                    fieldMaskBuilder.addPaths(lastLevel);
                    return Timestamps.fromMillis(((LocalDateTime) value).toInstant(localZoneOffset).toEpochMilli());
                }
            }
            Message.Builder fieldBuilder = parentBuilder.newBuilderForField(field);
            return convert(lastLevel,value,fieldBuilder, fieldMaskBuilder,converter);
        } else if (field.getType() == FieldDescriptor.Type.ENUM) {
            fieldMaskBuilder.addPaths(lastLevel);
            return field.getEnumType().findValueByName(value.toString());
        } else {
            fieldMaskBuilder.addPaths(lastLevel);
            switch (field.getType()) {
                case FLOAT: // float is a special case
                    return Float.valueOf(value.toString());
                default:
                    return value;
            }
        }
    }

    private static FieldDescriptor getField(Descriptor descriptor, String name) {
        return descriptor.findFieldByName(name);
    }
    private static Method getGetMethod(Class clazz,Field field) throws NoSuchMethodException {

       return clazz.getDeclaredMethod("get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1),new Class[] {});
    }
    private static void setFieldMaskValue(Descriptor descriptor,
                                          String fieldMaskName,
                                          Message.Builder builder,
                                          FieldMask.Builder fieldMaskBuilder) {
        FieldDescriptor fieldMask;
        if ((fieldMask = descriptor.findFieldByName(fieldMaskName)) != null) {
            builder.setField(fieldMask, fieldMaskBuilder.build());
            log.info("filed mask :[{}]", gson.toJson(fieldMaskBuilder.build()));
        } else {
            log.warn("the grpc field '{}' not found,filed mask value:[{}]", fieldMaskName, gson.toJson(fieldMaskBuilder.build()));
        }

    }

}