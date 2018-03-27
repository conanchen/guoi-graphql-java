package com.bdgx.guoi.shopiefrontend.graphql.type.customer;

//type MailingAddressConnection {
//        # A list of edges.
//        edges: [MailingAddressEdge!]!
//
//        # Information to aid in pagination.
//        pageInfo: PageInfo!
//        }
import com.bdgx.guoi.shopiefrontend.graphql.type.PageInfo;

import java.util.List;

public class MailingAddressConnection {
    //        # A list of edges.
    private final List<MailingAddressEdge> edges;//        edges: [MailingAddressEdge!]!
    //        # Information to aid in pagination.
    private final PageInfo pageInfo;//        pageInfo: PageInfo!

    public MailingAddressConnection(List<MailingAddressEdge> edges, PageInfo pageInfo) {
        this.edges = edges;
        this.pageInfo = pageInfo;
    }

}
