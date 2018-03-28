package com.bdgx.guoi.shopiefrontend.graphql.types.catalog;


public class ProductVariantEdge {
    //# A cursor for use in pagination.
    private final String cursor;//        cursor: String!
    //# The item at the end of ProductVariantEdge.
    private final ProductVariant node;//        node: ProductVariant!

    public ProductVariantEdge(String cursor, ProductVariant node) {
        this.cursor = cursor;
        this.node = node;
    }
}
