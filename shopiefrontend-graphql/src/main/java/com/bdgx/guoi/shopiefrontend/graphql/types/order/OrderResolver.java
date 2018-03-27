package com.bdgx.guoi.shopiefrontend.graphql.types.order;

import com.bdgx.guoi.shopiefrontend.graphql.types.PageInfo;
import com.bdgx.guoi.shopiefrontend.graphql.types.catalog.Product;
import com.coxautodev.graphql.tools.GraphQLResolver;

import java.util.ArrayList;

public class OrderResolver implements GraphQLResolver<Order> {

    public OrderResolver() {
    }

    //      # List of the order’s line items.
    public OrderLineItemConnection lineItems(
            Order order,
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
        Product p1 = new Product("productid1", "descriptionHtml--1", "productType1",
                null, "product 1 title", "vendor1");
        Product p2 = new Product("productid2", "descriptionHtml--2", "productType1",
                null, "product 2 title", "vendor1");
        Product p3 = new Product("productid3", "descriptionHtml--3", "productType2",
                null, "product 3 title", "vendor1");
        return new OrderLineItemConnection(new ArrayList<OrderLineItemEdge>() {{
            add(new OrderLineItemEdge("cusor1", new OrderLineItem(null, Integer.valueOf(3), "line 1 title", p1)));
            add(new OrderLineItemEdge("cusor2", new OrderLineItem(null, Integer.valueOf(4), "line 2 title", p2)));
            add(new OrderLineItemEdge("cusor3", new OrderLineItem(null, Integer.valueOf(5), "line 3 title", p3)));
        }},
                new PageInfo("end", Boolean.FALSE, Boolean.FALSE, "start"));
    }

}
