package com.bdgx.guoi.shopiefrontend.graphql.types.checkout;

import com.bdgx.guoi.shopiefrontend.graphql.types.PageInfo;

import java.util.List;

public class CheckoutConnection {

    //  # A list of edges.
    private final List<CheckoutEdge> edges;//    edges: [CheckoutEdge!]!
    //
    //  # Information to aid in pagination.
    private final PageInfo pageInfo;//        pageInfo: PageInfo!

    public CheckoutConnection(List<CheckoutEdge> edges, PageInfo pageInfo) {
        this.edges = edges;
        this.pageInfo = pageInfo;
    }
}
