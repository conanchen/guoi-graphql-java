package com.bdgx.guoi.shopiefrontend.graphql.types.cart;

import com.bdgx.guoi.shopiefrontend.graphql.types.PageInfo;

import java.util.List;

public class CartLineItemConnection {

    //  # A list of edges.
    private final List<CartLineItemEdge> edges;//    edges: [OrderLineItemEdge!]!
    //
    //  # Information to aid in pagination.
    private final PageInfo pageInfo;//        pageInfo: PageInfo!

    public CartLineItemConnection(List<CartLineItemEdge> edges, PageInfo pageInfo) {
        this.edges = edges;
        this.pageInfo = pageInfo;
    }
}
