package com.bdgx.guoi.shopiefrontend.graphql.types.catalog;

import com.bdgx.guoi.shopiefrontend.graphql.types.PageInfo;

import java.util.List;

//types CatalogConnection {
//        # A list of edges.
//        edges: [CatalogEdge!]!
//
//        # Information to aid in pagination.
//        pageInfo: PageInfo!
//}
public class CatalogConnection {
    //        # A list of edges.
    private final List<CatalogEdge> edges;//        edges: [CatalogEdge!]!
    //        # Information to aid in pagination.
    private final PageInfo pageInfo;//        pageInfo: PageInfo!

    public CatalogConnection(List<CatalogEdge> edges, PageInfo pageInfo) {
        this.edges = edges;
        this.pageInfo = pageInfo;
    }
}
