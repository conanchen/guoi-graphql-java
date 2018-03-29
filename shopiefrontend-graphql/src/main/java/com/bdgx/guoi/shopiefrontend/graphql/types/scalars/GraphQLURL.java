package com.bdgx.guoi.shopiefrontend.graphql.types.scalars;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;

public class GraphQLURL extends GraphQLScalarType {

    public GraphQLURL() {
        super("URL", "URL type", new Coercing<String, String>() {
            @Override
            public String serialize(Object input) {
                return input.toString();
            }

            @Override
            public String parseValue(Object input) {
                return serialize(input);
            }

            @Override
            public String parseLiteral(Object input) {
                if (!(input instanceof StringValue)) return null;
                return ((StringValue) input).getValue();
            }
        });
    }

}