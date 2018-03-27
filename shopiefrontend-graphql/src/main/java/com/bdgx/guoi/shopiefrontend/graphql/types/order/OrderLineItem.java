package com.bdgx.guoi.shopiefrontend.graphql.types.order;

import com.bdgx.guoi.shopiefrontend.graphql.types.catalog.Product;

import java.util.List;

public class OrderLineItem {
    //  # List of custom attributes associated to the line item.
    private final List<Attribute> customAttributes;//            customAttributes: [Attribute!]!
    //
//            # The number of products variants associated to the line item.
    private final Integer quantity;//    quantity: Int!
    //
//            # The title of the product combined with title of the variant.
    private final String title;//            title: String!
    //
//            # The product object associated to the line item.
    private final Product variant;//    variant: Product

    public OrderLineItem(List<Attribute> customAttributes, Integer quantity, String title, Product variant) {
        this.customAttributes = customAttributes;
        this.quantity = quantity;
        this.title = title;
        this.variant = variant;
    }
}
