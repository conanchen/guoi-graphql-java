package com.bdgx.guoi.shopiefrontend.graphql.types.cart.mutation;

import java.util.List;

public class CartLineItemsDeleteInput {
    //      # A list of line item objects, each one containing information about an item in the cart.
    private final List<String> variantIds;//            variantIds: [String!]

    public CartLineItemsDeleteInput(List<String> variantIds) {
        this.variantIds = variantIds;
    }
}
