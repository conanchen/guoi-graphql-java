package com.bdgx.guoi.shopiefrontend.graphql.types.checkout.mutation;

import com.bdgx.guoi.graphql.types.common.AttributeInput;
import graphql.schema.GraphQLInputType;

import java.util.List;

public class CheckoutLineItemInput {
    //  # Extra information in the form of an array of Key-Value pairs about the line item.
    private final List<AttributeInput> customAttributes;//    customAttributes: [AttributeInput!]
    //
//            # The quantity of the line item.
    private final Integer quantity;//    quantity: Int!
    //
//            # The identifier of the product variant for the line item.
    private final String variantId;//            variantId: ID!

    public CheckoutLineItemInput(List<AttributeInput> customAttributes, Integer quantity, String variantId) {
        this.customAttributes = customAttributes;
        this.quantity = quantity;
        this.variantId = variantId;
    }
}
