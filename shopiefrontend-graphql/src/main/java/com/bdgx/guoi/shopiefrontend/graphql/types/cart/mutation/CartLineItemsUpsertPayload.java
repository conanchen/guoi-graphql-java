package com.bdgx.guoi.shopiefrontend.graphql.types.cart.mutation;

import com.bdgx.guoi.graphql.types.common.UserError;
import com.bdgx.guoi.shopiefrontend.graphql.types.cart.Cart;

import java.util.List;

public class CartLineItemsUpsertPayload {
    //      # The new cart object.
    private final Cart cart;//    cart: Cart
    //
    //  # List of errors that occurred executing the mutation.
    private final List<UserError> userErrors;//    userErrors: [UserError!]!

    public CartLineItemsUpsertPayload(Cart cart, List<UserError> userErrors) {
        this.cart = cart;
        this.userErrors = userErrors;
    }

}
