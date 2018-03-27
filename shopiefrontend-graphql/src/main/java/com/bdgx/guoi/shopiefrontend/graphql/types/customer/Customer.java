package com.bdgx.guoi.shopiefrontend.graphql.types.customer;

public class Customer {
    //  # A unique identifier for the customer.
    private final String id;//    id: ID!
//

    //      # Indicates whether the customer has consented to be sent marketing material via email.
    private final Boolean acceptsMarketing; //            acceptsMarketing: Boolean!
    //
//            # A list of addresses for the customer.
//            #addresses(first: Int, after: String, last: Int, before: String, reverse: Boolean = false): MailingAddressConnection!
//
//            # The date and time when the customer was created.
//            createdAt: DateTime!
//
//            # The customer’s default address.
    private final MailingAddress defaultAddress;//            defaultAddress: MailingAddress
    //
//  # The customer’s name, email or phone number.
    private final String displayName;//            displayName: String!
    //
//            # The customer’s email address.
    private final String email;//            email: String
    //
//  # The customer’s first name.
    private final String firstName;//            firstName: String
    //
//            # The customer’s last name.
    private final String lastName;//            lastName: String
    //
//  # The orders associated with the customer.
//            #  orders(
//#    first: Int
//            #    after: String
//            #    last: Int
//            #    before: String
//            #    reverse: Boolean = false
//            #    sortKey: OrderSortKeys = ID
//            #
//            #    # Supported filter parameters:
//            #    #  - `processed_at`
//            #    query: String
//            #  ): OrderConnection!
//
//            # The customer’s phone number.
    private final String phone;//            phone: String
//
//  # The date and time when the customer information was updated.
//            # updatedAt: DateTime!


    public Customer(String id, Boolean acceptsMarketing, MailingAddress defaultAddress, String displayName,
                    String email, String firstName, String lastName, String phone) {
        this.id = id;
        this.acceptsMarketing = acceptsMarketing;
        this.defaultAddress = defaultAddress;
        this.displayName = displayName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }
}
