package com.bdgx.guoi.shopiefrontend.graphql.types.cart;

import com.bdgx.guoi.shopiefrontend.graphql.types.PageInfo;

import java.util.List;

public class CartConnection {

    //  # A list of edges.
    private final List<CartEdge> edges;//    edges: [OrderEdge!]!
    //
    //  # Information to aid in pagination.
    private final PageInfo pageInfo;//        pageInfo: PageInfo!

    public CartConnection(List<CartEdge> edges, PageInfo pageInfo) {
        this.edges = edges;
        this.pageInfo = pageInfo;
    }
}
