package com.github.conanchen.guoi.graphql.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Message;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.google.protobuf.Descriptors.FieldDescriptor.Type.*;

/**
 * @author hai
 * description 该工具类用于input转grpc及封装fieldMask
 * email hilin2333@gmail.com
 * date 2018/5/16 6:46 AM
 */
@Slf4j
public final class GqlInputConverter {
    private static final Gson gson = new GsonBuilder().create();
    private static final String FIELDMASK_NAME = "fieldMask";


    private static final com.google.common.base.Converter<String, String> DEFAULT_CONVERTER = PrincipleFormat.ID.converterTo(PrincipleFormat.NAME);

    /**
     * 普通map转grpc
     *
     * @param prefix           filed mask的前缀
     * @param builder          grpc builder
     * @param input            参数map
     * @param fieldMaskBuilder field mask builder
     * @param <T>              返回值泛型
     * @return 返回message结果
     */
    public static <T extends Message> T convert(String prefix, Message.Builder builder, Map<String, Object> input, FieldMask.Builder fieldMaskBuilder) {
        if (input == null || input.isEmpty()) {
            return (T)builder.build();
        }
        Message.Builder subBuilder;
        if ("".equals(prefix)) {
            subBuilder = builder;
        } else {
            FieldDescriptor fileDescriptor = builder.getDescriptorForType().findFieldByName(prefix);
            if (fileDescriptor != null) {
                subBuilder = builder.newBuilderForField(fileDescriptor);
            }else {
                subBuilder = builder;
            }
        }
        convertInternal(prefix,subBuilder,input,fieldMaskBuilder);
        if (!subBuilder.equals(builder)) {
            builder.setField(builder.getDescriptorForType().findFieldByName(prefix), subBuilder.build());
        }
        setFieldMaskValue(builder.getDescriptorForType(), FIELDMASK_NAME, builder, fieldMaskBuilder);
        return (T) builder.build();
    }

    private static void convertInternal(String prefix, Message.Builder builder, Map<String, Object> input, FieldMask.Builder fieldMaskBuilder) {
        Descriptor descriptor = builder.getDescriptorForType();
        for (Map.Entry<String,Object> entry : input.entrySet()){
            FieldDescriptor field;
            String fieldName;
            if ((field = descriptor.findFieldByName(entry.getKey())) == null ){
                fieldName = DEFAULT_CONVERTER.convert(entry.getKey());
                field = descriptor.findFieldByName(fieldName);
            }else{
                fieldName = entry.getKey();
            }
            if (field == null){
                continue;
            }
            String newPrefix = "".equals(prefix) ? fieldName : prefix + "." + fieldName;
            if (field.isRepeated() && input.get(fieldName) != null && input.get(fieldName) instanceof ArrayList) {
                try {
                    List<Object> objects = (List) input.get(fieldName);
                    if (objects.isEmpty()) {
                        fieldMaskBuilder.addPaths(prefix + field.getName());
                        continue;
                    }
                    String clazz = builder.getField(field).getClass().getName();
                    fieldMaskBuilder.addPaths(newPrefix);
                    if (field.getType() == MESSAGE || field.getType() == GROUP) {
                        for (int index = 0; index < objects.size(); index++) {
                            Message.Builder nestBuilder = builder.newBuilderForField(field);
                            Object value = objects.get(index);
                            Message item = convert(
                                    String.format(newPrefix + "[%s]", index),
                                    nestBuilder,
                                    (Map<String, Object>) value,
                                    fieldMaskBuilder
                            );
                            builder.addRepeatedField(field, item);
                        }
                    } else if (clazz.equals(Timestamp.getDescriptor().getFullName())) {
                        builder.setField(field, getValueForField(field, newPrefix, input.get(fieldName), builder, fieldMaskBuilder));
                    } else {
                        for (Object obj : objects) {
                            builder.addRepeatedField(field, getValueForField(field, newPrefix, obj, builder, fieldMaskBuilder));
                        }
                    }
                    continue;
                } catch (Exception e) {
                    log.warn("bean to grpc exception:", e);
                    continue;
                }
            }
            if (entry.getValue() == null){
                continue;
            }
            builder.setField(field, getValueForField(field, newPrefix, entry.getValue(), builder, fieldMaskBuilder));
        }
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

    /**
     * 目前支持 时间，枚举，数字的转换，其他类型的两个字段的类型需要一样的
     *
     * @param field            grpc 字段
     * @param lastLevel        上一级
     * @param value            java值
     * @param builder          grpc builder
     * @param fieldMaskBuilder filed masker builder
     * @return 返回字段值
     */
    private static Object getValueForField(FieldDescriptor field,
                                           String lastLevel,
                                           Object value,
                                           Message.Builder builder,
                                           FieldMask.Builder fieldMaskBuilder) {
        if (value instanceof Map && (field.getType() == MESSAGE || field.getType() == GROUP)) {
            Message.Builder subBuilder = builder.newBuilderForField(field);
            convertInternal(
                    lastLevel,
                    subBuilder,
                    (Map<String, Object>) value,
                    fieldMaskBuilder);
            return subBuilder.build();
        } else if (field.getType() == FLOAT) {
            value = Float.valueOf(value.toString());
        } else if (field.getType() == ENUM) {
            value = field.getEnumType().findValueByName(value.toString());
        } else if (builder.getField(field).getClass().getName().equals(Timestamp.class.getName())
                && value instanceof Date) {
            value = Timestamps.fromMillis(((Date) value).getTime());
        }
        fieldMaskBuilder.addPaths(lastLevel);
        return value;
    }

}