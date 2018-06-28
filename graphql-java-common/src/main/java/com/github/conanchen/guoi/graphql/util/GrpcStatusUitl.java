package com.github.conanchen.guoi.graphql.util;

import com.google.protobuf.Any;
import com.google.rpc.BadRequest;
import com.google.rpc.Code;

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
}
