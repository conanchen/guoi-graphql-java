package com.bdgx.guoi.shopiefrontend.graphql.types.order;

public class OrderEdge {

    //  # A cursor for use in pagination.
    private final String cursor;//        cursor: String!
    //
//            # The item at the end of OrderEdge.
    private final Order node;//            node: Order!

    public OrderEdge(String cursor, Order node) {
        this.cursor = cursor;
        this.node = node;
    }
}
