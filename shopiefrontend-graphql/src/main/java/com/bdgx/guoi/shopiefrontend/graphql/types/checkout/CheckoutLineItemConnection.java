package com.bdgx.guoi.shopiefrontend.graphql.types.checkout;

import com.bdgx.guoi.shopiefrontend.graphql.types.PageInfo;

import java.util.List;

public class CheckoutLineItemConnection {

    //  # A list of edges.
    private final List<CheckoutLineItemEdge> edges;//    edges: [CheckoutLineItemEdge!]!
    //
    //  # Information to aid in pagination.
    private final PageInfo pageInfo;//        pageInfo: PageInfo!

    public CheckoutLineItemConnection(List<CheckoutLineItemEdge> edges, PageInfo pageInfo) {
        this.edges = edges;
        this.pageInfo = pageInfo;
    }
}
