package com.bdgx.guoi.shopiefrontend.graphql.type;

import com.google.api.Page;

import java.util.List;

//type CatalogConnection {
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
