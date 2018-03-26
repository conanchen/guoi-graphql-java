package com.bdgx.guoi.shopiefrontend.graphql;

import com.bdgx.guoi.shopiefrontend.graphql.type.Person;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
//    createPerson(firstName: String, lastName: String, email: String!):Person!
    public Person createPerson(String firstName, String lastName, String email){
        return new Person("id001",firstName,lastName,email);
    }
}
