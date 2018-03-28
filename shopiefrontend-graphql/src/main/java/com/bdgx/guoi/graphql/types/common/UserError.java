package com.bdgx.guoi.graphql.types.common;

import java.util.List;

public class UserError {
    //      # Path to input field which caused the error.
    private final List<String> field;//    field: [String!]
    //
//            # The error message.
    private final String message;//            message: String!

    public UserError(List<String> field, String message) {
        this.field = field;
        this.message = message;
    }
}
