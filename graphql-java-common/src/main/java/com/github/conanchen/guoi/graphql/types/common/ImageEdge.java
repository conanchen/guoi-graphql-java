package com.github.conanchen.guoi.graphql.types.common;

public class ImageEdge {
    //  # A cursor for use in pagination.
    private final String cursor;//            cursor: String!
    //
//            # The item at the end of ImageEdge.
    private final Image node;//            node: Image!

    public ImageEdge(String cursor, Image node) {
        this.cursor = cursor;
        this.node = node;
    }
}
