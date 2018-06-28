package com.github.conanchen.guoi.graphql.util;

import com.github.conanchen.guoi.graphql.types.common.UserError;
import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.rpc.BadRequest;
import com.google.rpc.Code;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hai
 * description grpc返回状态工具类
 * email hilin2333@gmail.com
 * date 2018/6/28 9:07 AM
 */
public class GrpcStatusUitl {
    public static com.google.rpc.Status badRequest(List<BadRequest.FieldViolation> fieldViolations, Code code ,String message){
        return com.google.rpc.Status.newBuilder()
                .addDetails(Any.pack(BadRequest.newBuilder()
                        .addAllFieldViolations(fieldViolations)
                        .build()))
                .setCode(code.getNumber())
                .setMessage(message)
                .build();
    }
    public static com.google.rpc.Status badRequest(BadRequest.FieldViolation fieldViolation, Code code ,String message){
        return com.google.rpc.Status.newBuilder()
                .addDetails(Any.pack(BadRequest.newBuilder()
                        .addFieldViolations(fieldViolation)
                        .build()))
                .setCode(code.getNumber())
                .setMessage(message)
                .build();
    }

    public static com.google.rpc.Status ok(String message){
        return com.google.rpc.Status.newBuilder()
                .setCode(Code.OK.getNumber())
                .setMessage(message)
                .build();
    }

    public static com.google.rpc.Status ok(){
        return com.google.rpc.Status.newBuilder()
                .setCode(Code.OK.getNumber())
                .setMessage("access success")
                .build();
    }
    public static List<UserError> statusToUserErrors(com.google.rpc.Status status){
        if (status == null || status.equals(com.google.rpc.Status.getDefaultInstance())){
            return new ArrayList<UserError>(1){{
                add(new UserError());
            }};
        }
        List<UserError> userErrors = new ArrayList<>(1);
        UserError userError = new UserError();
        if (!CollectionUtils.isEmpty(status.getDetailsList())) {
            List<String> fields = new ArrayList<>(status.getDetailsList().size());
            for (com.google.protobuf.Any any : status.getDetailsList()) {
                try {
                    BadRequest badRequest = any.unpack(BadRequest.class);
                    for (BadRequest.FieldViolation fieldViolation : badRequest.getFieldViolationsList()){
                        fields.add(String.format("filed name[%s],error msg:[%s]",
                                fieldViolation.getField(),
                                fieldViolation.getDescription()));
                    }
                }catch (InvalidProtocolBufferException e){
                    continue;
                }
            }
            userError.setField(fields);
        }
        userError.setMessage(status.getMessage());
        userErrors.add(userError);
        return userErrors;
    }
}
