package com.bdgx.guoi.shopiefrontend.graphql.types.customer;

//types MailingAddressEdge {
//        # A cursor for use in pagination.
//        cursor: String!
//
//        # The item at the end of MailingAddressEdge.
//        node: MailingAddress!
//        }
public class MailingAddressEdge {
    //# A cursor for use in pagination.
    private final String cursor;//        cursor: String!
    //# The item at the end of MailingAddress.
    private final MailingAddress node;//        node: MailingAddress!

    public MailingAddressEdge(String cursor, MailingAddress node) {
        this.cursor = cursor;
        this.node = node;
    }

}
