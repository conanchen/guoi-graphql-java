package com.bdgx.guoi.shopiefrontend.graphql.types.catalog;

import com.coxautodev.graphql.tools.GraphQLResolver;

public class ProductResolver implements GraphQLResolver<Product> {

    public ProductResolver() {

    }

    //  # Stripped description of the product, single line with HTML tags removed.
//    description(
//    # Truncates string after the given length.
//            truncateAt: Int
//    ): String!
    public String description(Product product, Integer truncateAt) {
        return "truncateAt=" + truncateAt;
    }

    public ProductVariantConnection variants(
            Product product,
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
        return null;
    }
}
