package com.github.conanchen.guoi.graphql.types.common;

public class AttributeInput{
    //      # Key or name of the attribute.
    private final String key;//    key: String!
    //
//            # Value of the attribute.
    private final String value;//    value: String

    public AttributeInput(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
