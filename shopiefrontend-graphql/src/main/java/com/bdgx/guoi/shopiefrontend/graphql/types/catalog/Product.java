package com.bdgx.guoi.shopiefrontend.graphql.types.catalog;

import java.util.List;

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
public class Product {
    //  # Globally unique identifier.
    private final String id;// id: ID!


    //
//            # The description of the product, complete with HTML formatting.
    private final String descriptionHtml;//    descriptionHtml: HTML!
    //  # A categorization that a product can be tagged with, commonly used for filtering and searching.
    private final String productType;//            productType: String!
    //
//            # The date and time when the product was published to the channel.
//            # publishedAt: DateTime!
//
//            # A categorization that a product can be tagged with, commonly used for filtering and searching.
//  # Each comma-separated tag has a character limit of 255.
    private final List<String> tags;//    tags: [String!]!
    //
//            # The product’s title.
    private final String title;//    title: String!
    //            # The product’s vendor name.
    private final String vendor;//            vendor: String!


    public Product(String id, String descriptionHtml, String productType, List<String> tags, String title, String vendor) {
        this.id = id;
        this.descriptionHtml = descriptionHtml;
        this.productType = productType;
        this.tags = tags;
        this.title = title;
        this.vendor = vendor;
    }

}
