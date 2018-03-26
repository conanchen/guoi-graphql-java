package com.bdgx.guoi.shopiefrontend.graphql.type;

public class User {

    private final String id; //the unique id
    //# The username used to login.
    private final String login;//login: String!

    //# The user's public profile name.
    private final String name;//    name: String

    //  # The user's publicly visible profile email.
    private final String email;//    email: String!


    public User(String id, String login, String name, String email) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
