package com.github.conanchen.guoi.fieldmask;

import com.github.conanchen.guoi.cloud.common.grpc.PaymentChannel;
import com.github.conanchen.guoi.cloud.shopie.product.grpc.ProductType;
import com.github.conanchen.guoi.graphql.types.address.Address;

import java.util.Date;

/**
 * @author hai
 * description
 * email hilin2333@gmail.com
 * date 2018/6/4 4:18 AM
 */

public class CheckoutMongo {
    private String id;

    //配送地址
    private com.github.conanchen.guoi.graphql.types.address.Address shippingAddress;

    private PaymentChannel paymentChannel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public PaymentChannel getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(PaymentChannel paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    @Override
    public String toString() {
        return "CheckoutMongo{" +
                "id='" + id + '\'' +
                ",\n shippingAddress=" + shippingAddress +
                ",\n paymentChannel=" + paymentChannel +
                '}';
    }
}
