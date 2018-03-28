package com.bdgx.guoi.shopiefrontend.graphql.types.checkout;

import com.bdgx.guoi.graphql.types.common.Attribute;
import com.bdgx.guoi.shopiefrontend.graphql.types.catalog.Product;
import com.bdgx.guoi.shopiefrontend.graphql.types.catalog.ProductVariant;

import java.util.List;

public class CheckoutLineItem {
    //  # Globally unique identifier.
    private final String id;//            id: ID!
    //
//            # Extra information in the form of an array of Key-Value pairs about the line item.
    private final List<Attribute> customAttributes;//    customAttributes: [Attribute!]!
    //
//            # The quantity of the line item.
    private final Integer quantity;//    quantity: Int!
    //
//            # Title of the line item. Defaults to the product's title.
    private final String title;//    title: String!
    //
//            # Product variant of the line item.
    private final ProductVariant variant;//    variant: ProductVariant

    public CheckoutLineItem(String id, List<Attribute> customAttributes, Integer quantity, String title, ProductVariant variant) {
        this.id = id;
        this.customAttributes = customAttributes;
        this.quantity = quantity;
        this.title = title;
        this.variant = variant;
    }
}
