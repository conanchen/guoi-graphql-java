package com.github.conanchen.guoi.graphql.util;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Message;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;
import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyDescriptor;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

/**
 * @author hai
 * description 普通类转grpc
 * email hilin2333@gmail.com
 * date 2018/5/16 6:46 AM
 */
@Slf4j
public final class BeanToGrpcConverter {
    private static final ZoneOffset localZoneOffset = OffsetDateTime.now().getOffset();
    public static final com.google.common.base.Converter<String, String> DEFAULT_CONVERTER = PrincipleFormat.NAME.converterTo(PrincipleFormat.ID);

    public static <T extends Message> T toGrpc(Message.Builder builder, Object object,com.google.common.base.Converter<String, String> converter) {
        return convert(builder,object,converter);
    }

    public static <T extends Message> T toGrpc(Message.Builder builder, Object object) {
        return convert(builder,object,DEFAULT_CONVERTER);
    }

    private static <T extends Message> T convert(Message.Builder builder, Object object,com.google.common.base.Converter<String, String> converter) {
        if (object == null) {
            return (T) builder.build();
        }
        Descriptor descriptor = builder.getDescriptorForType();
        try {

            for (FieldDescriptor field : descriptor.getFields()) {
                String fieldName = converter == null ? field.getJsonName() : converter.convert(field.getJsonName());
                PropertyDescriptor propertyDescriptor = PropertyUtil.getPropertyDescriptor(object.getClass(), fieldName);
                Object o;
                if (propertyDescriptor == null) {
                    if ((propertyDescriptor = PropertyUtil.getPropertyDescriptor(object.getClass().getSuperclass(), fieldName)) == null){
                        continue;
                    } else {
                        o = PropertyUtil.getProperty(object.getClass().getSuperclass(), propertyDescriptor);
                    }
                }else{
                    o = PropertyUtil.getProperty(object, propertyDescriptor);
                }
                if (o == null) {
                    continue;
                }
                if (field.isRepeated()) {
                    List<Object> objects = (List) o;
                    for (Object obj : objects) {
                        builder.addRepeatedField(field, buildValue(builder, field, obj,converter));
                    }
                    continue;
                }
                builder.setField(field, buildValue(builder, field, o,converter));

            }
        } catch (IllegalArgumentException e) {
            log.error("结构必须一样", e);
        }
        return (T) builder.build();
    }

    private static Object buildValue(
            Message.Builder parentBuilder, FieldDescriptor field, Object value,com.google.common.base.Converter<String, String> converter) {
        if (field.getType() == FieldDescriptor.Type.MESSAGE) {
            // date 转 timestamp
            if (parentBuilder.getField(field).getClass().getName().equals(Timestamp.class.getName())
                    && value instanceof Date) {
                if (value instanceof Date) {
                    return Timestamps.fromMillis(((Date) value).getTime());
                }else if (value instanceof LocalDateTime){
                    return Timestamps.fromMillis(((LocalDateTime) value).toInstant(localZoneOffset).toEpochMilli());
                }
            }
            Message.Builder fieldBuilder = parentBuilder.newBuilderForField(field);
            return convert(fieldBuilder, value,converter);
        } else if (field.getType() == FieldDescriptor.Type.ENUM) {
            return field.getEnumType().findValueByName(value.toString());
        } else {
            switch (field.getType()) {
                case FLOAT: // float is a special case
                    return Float.valueOf(value.toString());
                case STRING:
                    return value.toString();
                default:
                    return value;
            }
        }
    }

    private static FieldDescriptor getField(Descriptor descriptor, String name) {
        return descriptor.findFieldByName(name);
    }
}