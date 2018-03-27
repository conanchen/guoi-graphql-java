package com.bdgx.guoi.shopiefrontend.graphql.type.customer;

import com.bdgx.guoi.shopiefrontend.graphql.type.PageInfo;
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
}
