package com.bdgx.guoi.shopiefrontend.graphql.types.customer;

import com.bdgx.guoi.graphql.types.common.CurrencyCode;
import com.bdgx.guoi.shopiefrontend.graphql.types.PageInfo;
import com.bdgx.guoi.shopiefrontend.graphql.types.order.Order;
import com.bdgx.guoi.shopiefrontend.graphql.types.order.OrderConnection;
import com.bdgx.guoi.shopiefrontend.graphql.types.order.OrderEdge;
import com.coxautodev.graphql.tools.GraphQLResolver;

import java.util.ArrayList;

public class CustomerResolver implements GraphQLResolver<Customer> {

    public CustomerResolver() {
    }

    //    addresses(first: Int, after: String, last: Int, before: String, reverse: Boolean = false): MailingAddressConnection!
    public MailingAddressConnection addresses(
            Customer customer,
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
        return new MailingAddressConnection(new ArrayList<MailingAddressEdge>() {{
            add(new MailingAddressEdge("cursor1", new MailingAddress()));
            add(new MailingAddressEdge("cursor2", new MailingAddress()));
            add(new MailingAddressEdge("cursor3", new MailingAddress()));
        }}, new PageInfo("end", Boolean.FALSE, Boolean.FALSE, "start"));
    }

//  # The orders associated with the customer.
    public OrderConnection orders(
            Customer customer,
            //# Returns the elements in the list that come after the specified global ID.
            String after,

            //# Returns the elements in the list that come before the specified global ID.
            String before,

            // # Returns the first _n_ elements from the list.
            Integer first,

            //  # Returns the last _n_ elements from the list.
            Integer last,

            Boolean reverse,
//            #sortKey: OrderSortKeys = ID
//
//            # Supported filter parameters:
//            #  - `processed_at`
            String query
    ){
       Order o1= new Order("orderid1", CurrencyCode.CNY,"customerLocale",
                "conan8chan@yahoo.com",Integer.valueOf(232),"13423423423",
                new MailingAddress(),Float.valueOf(11.2f),Float.valueOf(112.0f),
                Float.valueOf(22.0f),Float.valueOf(22.0f),Float.valueOf(22.0f));

       Order o2= new Order("orderid2", CurrencyCode.CNY,"customerLocale",
                "conan8chan@yahoo.com",Integer.valueOf(232),"13423423423",
                new MailingAddress(),Float.valueOf(11.2f),Float.valueOf(112.0f),
                Float.valueOf(22.0f),Float.valueOf(22.0f),Float.valueOf(22.0f));

       Order o3= new Order("orderid3", CurrencyCode.CNY,"customerLocale",
                "conan8chan@yahoo.com",Integer.valueOf(232),"13423423423",
                new MailingAddress(),Float.valueOf(11.2f),Float.valueOf(112.0f),
                Float.valueOf(22.0f),Float.valueOf(22.0f),Float.valueOf(22.0f));

        return new OrderConnection(new ArrayList<OrderEdge>(){{
            add(new OrderEdge("cursor",o1));
            add(new OrderEdge("cursor",o2));
            add(new OrderEdge("cursor",o3));

        }},new PageInfo("end",Boolean.FALSE,Boolean.FALSE,"start"));
    }

}
