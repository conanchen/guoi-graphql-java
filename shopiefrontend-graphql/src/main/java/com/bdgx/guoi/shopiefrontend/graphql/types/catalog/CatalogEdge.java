package com.bdgx.guoi.shopiefrontend.graphql.types.catalog;

//types CatalogEdge {
//        # A cursor for use in pagination.
//        cursor: String!
//
//        # The item at the end of CatalogEdge.
//        node: Catalog!
//}
public class CatalogEdge {
    //# A cursor for use in pagination.
    private final String cursor;//        cursor: String!
    //# The item at the end of CatalogEdge.
    private final Catalog node;//        node: Catalog!

    public CatalogEdge(String cursor, Catalog node) {
        this.cursor = cursor;
        this.node = node;
    }
}
