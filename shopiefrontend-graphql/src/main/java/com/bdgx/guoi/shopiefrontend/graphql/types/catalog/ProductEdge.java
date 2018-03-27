package com.bdgx.guoi.shopiefrontend.graphql.types.catalog;

//types ProductEdge {
//        # A cursor for use in pagination.
//        cursor: String!
//
//        # The item at the end of ProductEdge.
//        node: Product!
//        }
public class ProductEdge {
    //# A cursor for use in pagination.
    private final String cursor;//        cursor: String!
    //# The item at the end of ProductEdge.
    private final Product node;//        node: Product!

    public ProductEdge(String cursor, Product node) {
        this.cursor = cursor;
        this.node = node;
    }
}
