package com.bdgx.guoi.shopiefrontend.graphql.types.checkout.mutation;

import com.bdgx.guoi.graphql.types.common.AttributeInput;

import java.util.List;

public class CheckoutCreateInput {
    //  # The email with which the customer wants to checkout.
    private final String email;//            email: String
    //
//  # A list of line item objects, each one containing information about an item in the checkout.
    private final List<CheckoutLineItemInput> lineItems;//  #lineItems: [CheckoutLineItemInput!]
    //
//            # The shipping address to where the line items will be shipped.
    private final MailingAddressInput shippingAddress;//  #shippingAddress: MailingAddressInput
    //
//  # The text of an optional note that a shop owner can attach to the checkout.
    private final String note;//            note: String
    //
//  # A list of extra information that is added to the checkout.
    private final List<AttributeInput> customAttributes;//            customAttributes: [AttributeInput!]
    //
//            # Allows setting partial addresses on a Checkout, skipping the full validation of attributes.
//            # The required attributes are city, province, and country.
//            # Full validation of addresses is still done at complete time.
    private final Boolean allowPartialAddresses;//    allowPartialAddresses: Boolean

    public CheckoutCreateInput(String email, List<CheckoutLineItemInput> lineItems, MailingAddressInput shippingAddress,
                               String note, List<AttributeInput> customAttributes, Boolean allowPartialAddresses) {
        this.email = email;
        this.lineItems = lineItems;
        this.shippingAddress = shippingAddress;
        this.note = note;
        this.customAttributes = customAttributes;
        this.allowPartialAddresses = allowPartialAddresses;
    }
}
