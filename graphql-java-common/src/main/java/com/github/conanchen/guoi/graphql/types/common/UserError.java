package com.github.conanchen.guoi.graphql.types.common;

import java.util.List;

public class UserError {
    //      # Path to input field which caused the error.
    private List<String> field;//    field: [String!]
    //
//            # The error message.
    private String message = "ok";//            message: String!

    public UserError(){

    }

    public UserError(List<String> field, String message) {
        this.field = field;
        this.message = message;
    }

    public List<String> getField() {
        return field;
    }

    public void setField(List<String> field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
