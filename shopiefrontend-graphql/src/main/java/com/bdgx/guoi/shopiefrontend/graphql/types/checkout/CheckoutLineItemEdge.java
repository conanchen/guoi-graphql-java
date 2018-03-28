package com.bdgx.guoi.shopiefrontend.graphql.types.checkout;


public class CheckoutLineItemEdge {

    //  # A cursor for use in pagination.
    private final String cursor;//        cursor: String!
    //
//            # The item at the end of CheckoutLineItem.
    private final CheckoutLineItem node;//            node: CheckoutLineItem!

    public CheckoutLineItemEdge(String cursor, CheckoutLineItem node) {
        this.cursor = cursor;
        this.node = node;
    }
}
