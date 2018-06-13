package com.github.conanchen.guoi.fieldmask;

import com.github.conanchen.guoi.cloud.shopie.order.grpc.Checkout;
import com.github.conanchen.guoi.graphql.util.BeanToGrpcConverter;
import com.github.conanchen.guoi.graphql.util.FieldMaskMergeUtil;
import com.github.conanchen.guoi.graphql.util.GqlInputConverter;
import com.google.protobuf.FieldMask;
import org.junit.Test;

import java.util.Map;

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
                "\t\t\"paymentChannel\": \"CASH\"\n" +
                "\t}";
        Map<String, Object> input = gson.fromJson(json,new com.google.common.reflect.TypeToken<Map<String, Object>>() {}.getType());
        System.out.println(input.toString());
        System.out.println("--------input 转 grpc开始----------");
        com.github.conanchen.guoi.cloud.shopie.order.grpc.UpdateCheckoutRequest request = GqlInputConverter.convert("checkout",
                com.github.conanchen.guoi.cloud.shopie.order.grpc.UpdateCheckoutRequest.newBuilder(),
                input,
                FieldMask.newBuilder());
        System.out.println(request.toString());
        System.out.println(request.getFieldMask().toString());
        System.out.println("--------input 转 grpc结束----------");
        System.out.println("--------grpc filed mask 转 db bean 开始----------");
        CheckoutMongo newCheckout = new FieldMaskMergeUtil<CheckoutMongo>(request.getFieldMask()).merge(request, "checkout", CheckoutMongo.class);
        System.out.println(newCheckout.toString());
        System.out.println("--------grpc filed mask 转 db bean 结束----------");
        System.out.println("--------db bean 转 grpc 开始----------");
        Checkout checkout = BeanToGrpcConverter.toGrpc(Checkout.newBuilder(),newCheckout);
        System.out.println(checkout.toString());
        System.out.println("--------db bean 转 grpc 结束----------");
    }
}
