package com.bdgx.guoi.shopiefrontend.graphql.types.cart;

public class CartEdge {

    //  # A cursor for use in pagination.
    private final String cursor;//        cursor: String!
    //
//            # The item at the end of OrderEdge.
    private final Cart node;//            node: Order!

    public CartEdge(String cursor, Cart node) {
        this.cursor = cursor;
        this.node = node;
    }
}
