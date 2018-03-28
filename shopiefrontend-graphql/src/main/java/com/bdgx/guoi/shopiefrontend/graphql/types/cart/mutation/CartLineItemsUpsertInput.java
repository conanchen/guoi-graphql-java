package com.bdgx.guoi.shopiefrontend.graphql.types.cart.mutation;

import java.util.List;

public class CartLineItemsUpsertInput {
    //      # A list of line item objects, each one containing information about an item in the cart.
    private final List<CartLineItemInput> lineItems;//            lineItems: [CartLineItemInput!]

    public CartLineItemsUpsertInput(List<CartLineItemInput> lineItems) {
        this.lineItems = lineItems;
    }
}
