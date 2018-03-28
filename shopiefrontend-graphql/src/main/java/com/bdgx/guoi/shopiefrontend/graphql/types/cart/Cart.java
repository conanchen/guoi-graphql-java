package com.bdgx.guoi.shopiefrontend.graphql.types.cart;

import com.bdgx.guoi.graphql.types.common.CurrencyCode;
import com.bdgx.guoi.shopiefrontend.graphql.types.customer.MailingAddress;
import com.bdgx.guoi.shopiefrontend.graphql.types.shop.Shop;

public class Cart {
    //  # Globally unique identifier.
    private final String id;//            id: ID!
    //
//  # The Shop from which products was ordered
    private final Shop shop;//    shop: Shop!

    //      # Price of the cart before shipping and taxes.
    private final Float subtotalPrice;//    subtotalPrice: Money

    public Cart(String id, Shop shop, Float subtotalPrice) {
        this.id = id;
        this.shop = shop;
        this.subtotalPrice = subtotalPrice;
    }
}
