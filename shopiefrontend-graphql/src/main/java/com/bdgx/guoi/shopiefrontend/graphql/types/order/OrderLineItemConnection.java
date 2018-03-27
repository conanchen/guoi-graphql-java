package com.bdgx.guoi.shopiefrontend.graphql.types.order;

import com.bdgx.guoi.shopiefrontend.graphql.types.PageInfo;

import java.util.List;

public class OrderLineItemConnection {

    //  # A list of edges.
    private final List<OrderLineItemEdge> edges;//    edges: [OrderLineItemEdge!]!
    //
    //  # Information to aid in pagination.
    private final PageInfo pageInfo;//        pageInfo: PageInfo!

    public OrderLineItemConnection(List<OrderLineItemEdge> edges, PageInfo pageInfo) {
        this.edges = edges;
        this.pageInfo = pageInfo;
    }
}
