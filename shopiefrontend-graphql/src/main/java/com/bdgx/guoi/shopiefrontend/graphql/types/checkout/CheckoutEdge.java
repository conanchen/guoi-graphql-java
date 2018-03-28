package com.bdgx.guoi.shopiefrontend.graphql.types.checkout;


public class CheckoutEdge {

    //  # A cursor for use in pagination.
    private final String cursor;//        cursor: String!
    //
//            # The item at the end of CheckoutEdge.
    private final Checkout node;//            node: Checkout!

    public CheckoutEdge(String cursor, Checkout node) {
        this.cursor = cursor;
        this.node = node;
    }
}
