package com.bdgx.guoi.shopiefrontend.graphql.types.cart;

import com.bdgx.guoi.graphql.types.common.CurrencyCode;
import com.bdgx.guoi.shopiefrontend.graphql.types.customer.MailingAddress;

public class Cart {
    //  # Globally unique identifier.
    private final String id;//            id: ID!
    //
//            # The code of the currency used for the payment.
    private final CurrencyCode currencyCode;//    currencyCode: CurrencyCode!
    //
//            # The locale code in which this specific cart happened.
    private final String customerLocale;//            customerLocale: String
    //
//  # The cart’s URL for a customer.
//            # customerUrl: URL
//
//  # The customer's email address.
    private final String email;//    email: String
    //
//  # List of the cart’s line items.
//  # lineItems(first: Int, after: String, last: Int, before: String, reverse: Boolean = false): OrderLineItemConnection!
//
//            # A unique numeric identifier for the cart for use by shop owner and customer.
    private final Integer cartNumber; //    cartNumber: Int!
    //
//            # The customer's phone number.
    private final String phone;//    phone: String
    //
//  # The date and time when the cart was imported.
//  # This value can be set to dates in the past when importing from other systems.
//  # If no value is provided, it will be auto-generated based on current date and time.
//  # processedAt: DateTime!
//
//            # The address to where the cart will be shipped.
    private final MailingAddress shippingAddress;//            shippingAddress: MailingAddress
    //
//  # Price of the cart before shipping and taxes.
    private final Float subtotalPrice;//    subtotalPrice: Money
    //
//  # The sum of all the prices of all the items in the cart, taxes and discounts included (must be positive).
    private final Float totalPrice;//    totalPrice: Money!
    //
//            # The total amount that has been refunded.
    private final Float totalRefunded;//            totalRefunded: Money!
    //
//            # The total cost of shipping.
    private final Float totalShippingPrice;//            totalShippingPrice: Money!
    //
//            # The total cost of taxes.
    private final Float totalTax;//            totalTax: Money

    public Cart(String id, CurrencyCode currencyCode, String customerLocale, String email, Integer cartNumber, String phone, MailingAddress shippingAddress, Float subtotalPrice, Float totalPrice, Float totalRefunded, Float totalShippingPrice, Float totalTax) {
        this.id = id;
        this.currencyCode = currencyCode;
        this.customerLocale = customerLocale;
        this.email = email;
        this.cartNumber = cartNumber;
        this.phone = phone;
        this.shippingAddress = shippingAddress;
        this.subtotalPrice = subtotalPrice;
        this.totalPrice = totalPrice;
        this.totalRefunded = totalRefunded;
        this.totalShippingPrice = totalShippingPrice;
        this.totalTax = totalTax;
    }
}
