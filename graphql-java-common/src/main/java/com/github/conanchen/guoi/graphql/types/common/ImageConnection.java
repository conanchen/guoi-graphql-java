package com.github.conanchen.guoi.graphql.types.common;

import java.util.List;

public class ImageConnection {
    //  # A list of edges.
    private final List<ImageEdge> edges;//    edges: [ImageEdge!]!
    //
//            # Information to aid in pagination.
    private final PageInfo pageInfo;//            pageInfo: PageInfo!

    public ImageConnection(List<ImageEdge> edges, PageInfo pageInfo) {
        this.edges = edges;
        this.pageInfo = pageInfo;
    }
}
