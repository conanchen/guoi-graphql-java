package com.bdgx.guoi.shopiefrontend.graphql.types.checkout;

import com.bdgx.guoi.graphql.types.common.Attribute;
import com.bdgx.guoi.graphql.types.common.CurrencyCode;
import com.bdgx.guoi.shopiefrontend.graphql.types.customer.MailingAddress;
import com.bdgx.guoi.shopiefrontend.graphql.types.order.Order;
import com.bdgx.guoi.shopiefrontend.graphql.types.shop.Shop;

import java.util.Date;
import java.util.List;

public class Checkout {

    //  # Globally unique identifier.
    private final String id;//            id: ID!

    //  # The Shop from which products was ordered
    private final Shop shop;//    shop: Shop!
    //
    //
//            # The date and time when the checkout was completed.
    private final Date completedAt;//            completedAt: DateTime
    //
//  # The date and time when the checkout was created.
    private final Date createdAt;//            createdAt: DateTime!
    //
//            # The currency code for the Checkout.
    private final CurrencyCode currencyCode;//    currencyCode: CurrencyCode!
    //
//            # A list of extra information that is added to the checkout.
    private final List<Attribute> customAttributes;//            customAttributes: [Attribute!]!
    //
//            # The email attached to this checkout.
    private final String email;//            email: String
    //
//  # A list of line item objects, each one containing information about an item in the checkout.
//            lineItems(first: Int, after: String, last: Int, before: String, reverse: Boolean = false): CheckoutLineItemConnection!
    private final String note;//    note: String
    //
//  # The resulting order from a paid checkout.
    private final Order order;//            order: Order
    //
//  # Whether or not the Checkout is ready and can be completed. Checkouts may have
//  # asynchronous operations that can take time to finish. If you want to complete
//  # a checkout or ensure all the fields are populated and up to date, polling is
//  # required until the value is true.
    private final Boolean ready;//    ready: Boolean!
    //
//            # The shipping address to where the line items will be shipped.
    private final MailingAddress shippingAddress;//            shippingAddress: MailingAddress
    //
//  # Price of the checkout before shipping, taxes, and discounts.
    private final Float subtotalPrice;//            subtotalPrice: Money!
    //
//            # The sum of all the prices of all the items in the checkout, taxes and discounts included.
    private final Float totalPrice;//    totalPrice: Money!
    //
//            # The sum of all the taxes applied to the line items and shipping lines in the checkout.
    private final Float totalTax;//            totalTax: Money!
    //
//            # The date and time when the checkout was last updated.
    private final Date updatedAt;//    updatedAt: DateTime!


    public Checkout(String id, Shop shop,Date completedAt, Date createdAt,CurrencyCode currencyCode, List<Attribute> customAttributes, String email,
                    String note, Order order, Boolean ready, MailingAddress shippingAddress, Float subtotalPrice,
                    Float totalPrice, Float totalTax,Date updatedAt) {
        this.id = id;
        this.shop = shop;
        this.completedAt = completedAt;
        this.createdAt = createdAt;
        this.currencyCode = currencyCode;
        this.customAttributes = customAttributes;
        this.email = email;
        this.note = note;
        this.order = order;
        this.ready = ready;
        this.shippingAddress = shippingAddress;
        this.subtotalPrice = subtotalPrice;
        this.totalPrice = totalPrice;
        this.totalTax = totalTax;
        this.updatedAt = updatedAt;
    }
}
