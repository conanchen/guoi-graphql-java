package com.github.conanchen.guoi.graphql.types.common;

//types MailingAddressConnection {
//        # A list of edges.
//        edges: [MailingAddressEdge!]!
//
//        # Information to aid in pagination.
//        pageInfo: PageInfo!
//        }

import java.util.List;

public class AddressConnection {
    //        # A list of edges.
    private final List<AddressEdge> edges;//        edges: [MailingAddressEdge!]!
    //        # Information to aid in pagination.
    private final PageInfo pageInfo;//        pageInfo: PageInfo!

    public AddressConnection(List<AddressEdge> edges, PageInfo pageInfo) {
        this.edges = edges;
        this.pageInfo = pageInfo;
    }

}
