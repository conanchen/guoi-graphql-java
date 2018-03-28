package com.bdgx.guoi.shopiefrontend.graphql.types.checkout.mutation;

import com.bdgx.guoi.graphql.types.common.UserError;
import com.bdgx.guoi.shopiefrontend.graphql.types.checkout.Checkout;

import java.util.List;

public class CheckoutCreatePayload {
    //      # The new checkout object.
    private final Checkout checkout;//    checkout: Checkout
    //
//  # List of errors that occurred executing the mutation.
    private final List<UserError> userErrors;//    userErrors: [UserError!]!

    public CheckoutCreatePayload(Checkout checkout, List<UserError> userErrors) {
        this.checkout = checkout;
        this.userErrors = userErrors;
    }
}
