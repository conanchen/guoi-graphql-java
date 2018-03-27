package com.bdgx.guoi.shopiefrontend.graphql.types.catalog;

import com.coxautodev.graphql.tools.GraphQLResolver;

public class ProductResolver implements GraphQLResolver<Product> {

    public ProductResolver( ) {

    }

    //  # Stripped description of the product, single line with HTML tags removed.
//    description(
//    # Truncates string after the given length.
//            truncateAt: Int
//    ): String!
    public String description(Product product,Integer truncateAt) {
        return "truncateAt=" + truncateAt;
    }

}
