package com.bdgx.guoi.shopiefrontend.graphql.types.cart;

import com.bdgx.guoi.graphql.types.common.Attribute;
import com.bdgx.guoi.shopiefrontend.graphql.types.catalog.Product;
import com.bdgx.guoi.shopiefrontend.graphql.types.catalog.ProductVariant;

import java.util.List;

public class CartLineItem {
    //  # List of custom attributes associated to the line item.
    private final List<Attribute> customAttributes;//            customAttributes: [Attribute!]!
    //
//            # The number of products variants associated to the line item.
    private final Integer quantity;//    quantity: Int!
    //
//            # The title of the product combined with title of the variant.
    private final String title;//            title: String!
    //
//            # The product variant object associated to the line item.
    private final ProductVariant variant;//    variant: ProductVariant

    public CartLineItem(List<Attribute> customAttributes, Integer quantity, String title, ProductVariant variant) {
        this.customAttributes = customAttributes;
        this.quantity = quantity;
        this.title = title;
        this.variant = variant;
    }
}
