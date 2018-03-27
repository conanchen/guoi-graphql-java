package com.bdgx.guoi.shopiefrontend.graphql.types.order;

public class OrderLineItemEdge {

    //  # A cursor for use in pagination.
    private final String cursor;//        cursor: String!
    //
//            # The item at the end of OrderEdge.
    private final OrderLineItem node;//            node: OrderLineItem!

    public OrderLineItemEdge(String cursor, OrderLineItem node) {
        this.cursor = cursor;
        this.node = node;
    }
}
