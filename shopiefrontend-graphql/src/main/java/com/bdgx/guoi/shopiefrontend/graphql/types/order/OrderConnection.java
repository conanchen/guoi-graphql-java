package com.bdgx.guoi.shopiefrontend.graphql.types.order;

import com.bdgx.guoi.shopiefrontend.graphql.types.PageInfo;

import java.util.List;

public class OrderConnection {

    //  # A list of edges.
    private final List<OrderEdge> edges;//    edges: [OrderEdge!]!
    //
    //  # Information to aid in pagination.
    private final PageInfo pageInfo;//        pageInfo: PageInfo!

    public OrderConnection(List<OrderEdge> edges, PageInfo pageInfo) {
        this.edges = edges;
        this.pageInfo = pageInfo;
    }
}
