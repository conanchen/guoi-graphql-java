package com.github.conanchen.guoi.graphql.types.attribute;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AttributeInput{
    //      # Key or name of the attribute.
    private String key;//    key: String!
    //
//            # Value of the attribute.
    private String value;//    value: String
}
