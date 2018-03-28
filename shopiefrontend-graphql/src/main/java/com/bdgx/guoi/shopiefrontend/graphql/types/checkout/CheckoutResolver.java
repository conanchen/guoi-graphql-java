package com.bdgx.guoi.shopiefrontend.graphql.types.checkout;

import com.bdgx.guoi.shopiefrontend.graphql.types.PageInfo;
import com.coxautodev.graphql.tools.GraphQLResolver;

import java.util.ArrayList;

public class CheckoutResolver implements GraphQLResolver<Checkout> {

    public CheckoutResolver() {
    }

    //      # List of the cart’s line items.
    public CheckoutLineItemConnection lineItems(
            Checkout checkout,

            //# Returns the elements in the list that come after the specified global ID.
            String after,

            //# Returns the elements in the list that come before the specified global ID.
            String before,

            // # Returns the first _n_ elements from the list.
            Integer first,

            //  # Returns the last _n_ elements from the list.
            Integer last,

            Boolean reverse

    ) {

        return new CheckoutLineItemConnection(new ArrayList<CheckoutLineItemEdge>(){{
            add(new CheckoutLineItemEdge("cursor",new CheckoutLineItem("lineitme1",null,Integer.valueOf(1),"lineitemtitle1",null)));
            add(new CheckoutLineItemEdge("cursor",new CheckoutLineItem("lineitme1",null,Integer.valueOf(1),"lineitemtitle1",null)));
            add(new CheckoutLineItemEdge("cursor",new CheckoutLineItem("lineitme1",null,Integer.valueOf(1),"lineitemtitle1",null)));
        }},new PageInfo("end",Boolean.FALSE,Boolean.FALSE,"start"));
    }

}
