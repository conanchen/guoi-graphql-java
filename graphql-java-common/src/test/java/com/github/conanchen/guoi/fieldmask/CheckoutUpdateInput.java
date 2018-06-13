package com.github.conanchen.guoi.fieldmask;

import com.github.conanchen.guoi.cloud.common.grpc.PaymentChannel;
import com.github.conanchen.guoi.graphql.types.address.AddressInput;

import java.util.Date;

public class CheckoutUpdateInput {
    //  # The ID of the checkout
    private String checkoutId;//    checkoutId: ID!

    private Date expectedServiceTime;

    //骑行时长
    private Float  ridingDuration;

    private String note;

    private AddressInput shippingAddress;

    private PaymentChannel paymentChannel;

    public String getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(String checkoutId) {
        this.checkoutId = checkoutId;
    }

    public Date getExpectedServiceTime() {
        return expectedServiceTime;
    }

    public void setExpectedServiceTime(Date expectedServiceTime) {
        this.expectedServiceTime = expectedServiceTime;
    }

    public Float getRidingDuration() {
        return ridingDuration;
    }

    public void setRidingDuration(Float ridingDuration) {
        this.ridingDuration = ridingDuration;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public AddressInput getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(AddressInput shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public PaymentChannel getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(PaymentChannel paymentChannel) {
        this.paymentChannel = paymentChannel;
    }
}
