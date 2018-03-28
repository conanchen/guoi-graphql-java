package com.bdgx.guoi.shopiefrontend.graphql.types.cart;

import com.bdgx.guoi.graphql.types.common.WeightUnit;
import com.bdgx.guoi.shopiefrontend.graphql.types.PageInfo;
import com.bdgx.guoi.shopiefrontend.graphql.types.catalog.Product;
import com.bdgx.guoi.shopiefrontend.graphql.types.catalog.ProductVariant;
import com.coxautodev.graphql.tools.GraphQLResolver;

import java.util.ArrayList;

public class CartResolver implements GraphQLResolver<Cart> {

    public CartResolver() {
    }

    //      # List of the cart’s line items.
    public CartLineItemConnection lineItems(
            Cart cart,
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

        Product prd = new Product("productid2", "descriptionHtml--2", "productType1",
                null, "product 2 title", "vendor1");

        ProductVariant pv1 = new ProductVariant("productvariantid1", Boolean.TRUE,Boolean.TRUE, Float.valueOf(1.0f),prd,"descriptionHtml--1", "productvariant1",
                Float.valueOf(3.0f), WeightUnit.GRAMS);
        ProductVariant pv2 = new ProductVariant("productvariantid2", Boolean.TRUE,Boolean.TRUE, Float.valueOf(1.0f),prd,"descriptionHtml--1", "productvariant2",
                Float.valueOf(3.0f), WeightUnit.GRAMS);
        ProductVariant pv3 = new ProductVariant("productvariantid3", Boolean.TRUE,Boolean.TRUE, Float.valueOf(1.0f),prd,"descriptionHtml--1", "productvariant3",
                Float.valueOf(3.0f), WeightUnit.GRAMS);
        return new CartLineItemConnection(new ArrayList<CartLineItemEdge>() {{
            add(new CartLineItemEdge("cusor1", new CartLineItem(null, Integer.valueOf(3), "line 1 title", pv1)));
            add(new CartLineItemEdge("cusor2", new CartLineItem(null, Integer.valueOf(4), "line 2 title", pv2)));
            add(new CartLineItemEdge("cusor3", new CartLineItem(null, Integer.valueOf(5), "line 3 title", pv3)));
        }},
                new PageInfo("end", Boolean.FALSE, Boolean.FALSE, "start"));
    }

}
