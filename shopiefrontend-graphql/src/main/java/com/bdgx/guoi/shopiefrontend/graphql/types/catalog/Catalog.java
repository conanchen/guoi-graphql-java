package com.bdgx.guoi.shopiefrontend.graphql.types.catalog;

import java.util.ArrayList;

//# A catalog represents a grouping of products that a shop owner can create to
//        # organize them or make their shops easier to browse.
//        types Catalog implements Node{
//        # Globally unique identifier.
//        id:ID!
//
//        # The catalog’s name.Limit of 255characters.
//        title:String!
//
//        # Parent Catalog
//        parent:Catalog
//}

public class Catalog {
    //  # Globally unique identifier.
    private final String id;// id: ID!

    // # The catalog’s name. Limit of 255 characters.
    private final String title;// title: String!

    // # Parent Catalog
    private final Catalog parent;// parent: Catalog


    public Catalog(String id, String title, Catalog parent) {
        this.id = id;
        this.title = title;
        this.parent = parent;
    }

}
