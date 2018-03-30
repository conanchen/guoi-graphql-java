package com.github.conanchen.guoi.graphql.types.scalars;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;

import java.time.LocalDateTime;
import java.util.Date;

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