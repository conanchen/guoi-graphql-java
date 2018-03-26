package com.bdgx.guoi.shopiefrontend.graphql.type;

public class Person {

    private final String id; //the unique id

    //# The person's publicly visible profile name.
    private final String firstName;
    private final String lastName;

    // # The person's publicly visible profile email.
    private final String email;//    email: String!

    public Person(String id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
