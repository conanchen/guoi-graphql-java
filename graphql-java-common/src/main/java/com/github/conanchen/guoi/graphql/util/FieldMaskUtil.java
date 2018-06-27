package com.github.conanchen.guoi.graphql.util;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;

/**
 * @author hai
 * description
 * email hilin2333@gmail.com
 * date 2018/6/27 4:13 PM
 */
public class FieldMaskUtil {

    /**
     * 获取grpc定义的参数
     * @param message 消息
     * @param fieldNumber grpc字段编号
     * @return 返回grpc字段名称
     */
    public String getFiledName(Message message, int fieldNumber) {
        return message.getDescriptorForType().findFieldByNumber(fieldNumber).getName();
    }

    /**
     * 获取grpc定义的参数
     * @param descriptor 消息类型描述
     * @param fieldNumber grpc字段编号
     * @return 返回grpc字段名称
     */
    public String getFiledName(Descriptors.Descriptor descriptor, int fieldNumber) {
        return descriptor.findFieldByNumber(fieldNumber).getName();
    }
}
