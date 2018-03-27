package com.bdgx.guoi.shopiefrontend.graphql.types.order;

public class Attribute {
    //      # Key or name of the attribute.
    private final String key;//    key: String!
    //
//            # Value of the attribute.
    private final String value;//    value: String

    public Attribute(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
