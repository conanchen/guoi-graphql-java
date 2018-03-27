package com.bdgx.guoi.shopiefrontend.graphql.types.shop;

public class Shop {
    //  # Globally unique identifier.
    private final String id;// id: ID!
    //
//            # The shop’s name.
    private final String name;//    name: String!
    //
//            # A description of the shop.
    private final String description;//            description: String
//


    public Shop(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
