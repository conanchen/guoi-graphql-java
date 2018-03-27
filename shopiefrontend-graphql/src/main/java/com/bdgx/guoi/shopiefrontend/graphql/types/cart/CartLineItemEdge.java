package com.bdgx.guoi.shopiefrontend.graphql.types.cart;

public class CartLineItemEdge {

    //  # A cursor for use in pagination.
    private final String cursor;//        cursor: String!
    //
//            # The item at the end of OrderEdge.
    private final CartLineItem node;//            node: OrderLineItem!

    public CartLineItemEdge(String cursor, CartLineItem node) {
        this.cursor = cursor;
        this.node = node;
    }
}
