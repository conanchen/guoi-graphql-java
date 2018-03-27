package com.bdgx.guoi.shopiefrontend.graphql.types.scalars;

import graphql.language.FloatValue;
import graphql.language.IntValue;
import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author <a href='mailto:alexey@zhokhov.com'>Alexey Zhokhov</a>
 */
public class GraphQLMoney extends GraphQLScalarType {

    private static final BigInteger LONG_MAX = BigInteger.valueOf(Long.MAX_VALUE);
    private static final BigInteger LONG_MIN = BigInteger.valueOf(Long.MIN_VALUE);
    private static final BigInteger INT_MAX = BigInteger.valueOf(Integer.MAX_VALUE);
    private static final BigInteger INT_MIN = BigInteger.valueOf(Integer.MIN_VALUE);
    private static final BigInteger BYTE_MAX = BigInteger.valueOf(Byte.MAX_VALUE);
    private static final BigInteger BYTE_MIN = BigInteger.valueOf(Byte.MIN_VALUE);
    private static final BigInteger SHORT_MAX = BigInteger.valueOf(Short.MAX_VALUE);
    private static final BigInteger SHORT_MIN = BigInteger.valueOf(Short.MIN_VALUE);


    private static boolean isNumberIsh(Object input) {
        return input instanceof Number || input instanceof String;
    }


    public GraphQLMoney() {
        super("Money", "Built-in Money", new Coercing<Double, Double>() {

            private Double convertImpl(Object input) {
                if (isNumberIsh(input)) {
                    BigDecimal value;
                    try {
                        value = new BigDecimal(input.toString());
                    } catch (NumberFormatException e) {
                        return null;
                    }
                    return value.doubleValue();
                } else {
                    return null;
                }

            }

            @Override
            public Double serialize(Object input) {
                Double result = convertImpl(input);
                if (result == null) {
                    throw new CoercingSerializeException("Invalid input '" + input + "' for Money");
                }
                return result;

            }

            @Override
            public Double parseValue(Object input) {
                Double result = convertImpl(input);
                if (result == null) {
                    throw new CoercingParseValueException("Invalid input '" + input + "' for Money");
                }
                return result;
            }

            @Override
            public Double parseLiteral(Object input) {
                if (input instanceof IntValue) {
                    return ((IntValue) input).getValue().doubleValue();
                } else if (input instanceof FloatValue) {
                    return ((FloatValue) input).getValue().doubleValue();
                } else {
                    return null;
                }
            }
        });
    }
}