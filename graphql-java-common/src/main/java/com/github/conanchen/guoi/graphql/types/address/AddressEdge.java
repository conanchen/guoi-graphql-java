package com.github.conanchen.guoi.graphql.types.address;

import com.github.conanchen.guoi.graphql.types.common.Address;

//types MailingAddressEdge {
//        # A cursor for use in pagination.
//        cursor: String!
//
//        # The item at the end of MailingAddressEdge.
//        node: Address!
//        }
public class AddressEdge {
    //# A cursor for use in pagination.
    private final String cursor;//        cursor: String!
    //# The item at the end of Address.
    private final Address node;//        node: Address!

    public AddressEdge(String cursor, Address node) {
        this.cursor = cursor;
        this.node = node;
    }

}