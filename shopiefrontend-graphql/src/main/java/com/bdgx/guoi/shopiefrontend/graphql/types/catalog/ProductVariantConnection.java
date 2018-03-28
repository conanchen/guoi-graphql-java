package com.bdgx.guoi.shopiefrontend.graphql.types.catalog;

import com.bdgx.guoi.shopiefrontend.graphql.types.PageInfo;

import java.util.List;

public class ProductVariantConnection {
    //        # A list of edges.
    private final List<ProductVariantEdge> edges;//        edges: [ProductVariantEdge!]!
    //        # Information to aid in pagination.
    private final PageInfo pageInfo;//        pageInfo: PageInfo!

    public ProductVariantConnection(List<ProductVariantEdge> edges, PageInfo pageInfo) {
        this.edges = edges;
        this.pageInfo = pageInfo;
    }
}
