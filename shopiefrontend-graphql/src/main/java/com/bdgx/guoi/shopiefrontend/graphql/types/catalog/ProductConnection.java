package com.bdgx.guoi.shopiefrontend.graphql.types.catalog;

import com.bdgx.guoi.shopiefrontend.graphql.types.PageInfo;

import java.util.List;

//types ProductConnection {
//        # A list of edges.
//        edges: [ProductEdge!]!
//
//        # Information to aid in pagination.
//        pageInfo: PageInfo!
//        }
public class ProductConnection {
    //        # A list of edges.
    private final List<ProductEdge> edges;//        edges: [ProductEdge!]!
    //        # Information to aid in pagination.
    private final PageInfo pageInfo;//        pageInfo: PageInfo!

    public ProductConnection(List<ProductEdge> edges, PageInfo pageInfo) {
        this.edges = edges;
        this.pageInfo = pageInfo;
    }
}
