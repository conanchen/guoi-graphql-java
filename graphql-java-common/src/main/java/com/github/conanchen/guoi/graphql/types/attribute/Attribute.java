package com.github.conanchen.guoi.graphql.types.attribute;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Attribute {
    //      # Key or name of the attribute.
    private  String key;//    key: String!
    //
//            # Value of the attribute.
    private  String value;//    value: String
}
