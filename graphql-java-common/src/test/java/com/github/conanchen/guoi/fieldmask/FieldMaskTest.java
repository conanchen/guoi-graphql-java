package com.github.conanchen.guoi.fieldmask;

import com.github.conanchen.guoi.cloud.shopie.order.grpc.Checkout;
import com.github.conanchen.guoi.cloud.shopie.order.grpc.UpdateCheckoutRequest;
import com.github.conanchen.guoi.graphql.types.scalars.DateTimeHelper;
import com.github.conanchen.guoi.graphql.util.BeanToGrpcConverter;
import com.github.conanchen.guoi.graphql.util.BeanToGrpcRequestUtil;
import com.github.conanchen.guoi.graphql.util.FieldMaskMergeUtil;
import com.github.conanchen.guoi.graphql.util.GqlInputConverter;
import com.google.protobuf.FieldMask;
import org.junit.Test;

import java.util.Date;
import java.util.Map;

import static com.github.conanchen.guoi.graphql.util.BeanToGrpcRequestUtil.DEFAULT_CONVERTER;

/**
 * @author hai
 * description
 * email hilin2333@gmail.com
 * date 2018/6/13 5:08 PM
 */
public class FieldMaskTest {

    @Test
    public void main(){
        com.google.gson.Gson gson = new com.google.gson.GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .enableComplexMapKeySerialization().create();
        String json = "{\n" +
                "\t\t\"checkoutId\": \"5b179756cff47e0001548912\",\n" +
                "\t\t\"ridingDuration\": 11,\n" +
                "\t\t\"note\": \"jajj\",\n" +
                "\t\t\"shippingAddress\": {\n" +
                "\t\t\t\"address1\": \"地球村\",\n" +
                "\t\t\t\"phone\": \"13413467946\",\n" +
                "\t\t\t\"latitude\": 22.95849076,\n" +
                "\t\t\t\"longitude\": 113.98106657\n" +
                "\t\t},\n" +
                "\t\t\"paymentChannel\": \"CASH\",\n" +
                "\t\t\"receiverId\": \"11111\",\n" +
                "\t\t\"org8nId\": \"11111\"\n" +
                "\t}";
        Map<String, Object> input = gson.fromJson(json,new com.google.common.reflect.TypeToken<Map<String, Object>>() {}.getType());
        System.out.println(input.toString());
        System.out.println("--------input 转 grpc开始----------");
        com.github.conanchen.guoi.cloud.shopie.order.grpc.UpdateCheckoutRequest request = GqlInputConverter.convert("checkout",
                UpdateCheckoutRequest.newBuilder(),
                input,
                FieldMask.newBuilder());
        System.out.println(request.toString());
        System.out.println(request.getFieldMask().toString());
        System.out.println("--------input 转 grpc结束----------");
        System.out.println("--------grpc filed mask 转 db bean 开始----------");
        CheckoutMongo newCheckout = new FieldMaskMergeUtil<CheckoutMongo>(request.getFieldMask()).merge(request, "checkout", CheckoutMongo.class);
        System.out.println("newCheckout:\n" + newCheckout.toString());
        System.out.println("--------grpc filed mask 转 db bean 结束----------");
        System.out.println("--------db bean 转 grpc 开始----------");
        Checkout checkout = BeanToGrpcConverter.toGrpc(Checkout.newBuilder(),newCheckout);
        System.out.println(checkout.toString());
        System.out.println("--------db bean 转 grpc 结束----------");
        System.out.println(DateTimeHelper.toISOString(new Date()));
        System.out.println("--------bean 转 grpc 带field mask 开始----------");
        FieldMask.Builder fieldMaskBuilder = FieldMask.newBuilder();
        UpdateCheckoutRequest requestCheckout = BeanToGrpcRequestUtil.toGrpc("checkout",newCheckout,
                UpdateCheckoutRequest.newBuilder(),
                fieldMaskBuilder,DEFAULT_CONVERTER);
        System.out.println(requestCheckout.toString());
        System.out.println("--------bean 转 grpc 带field mask 结束----------");
    }
}
