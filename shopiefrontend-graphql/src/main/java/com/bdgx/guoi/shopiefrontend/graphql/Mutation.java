package com.bdgx.guoi.shopiefrontend.graphql;

import com.bdgx.guoi.shopiefrontend.graphql.type.customer.Customer;
import com.bdgx.guoi.shopiefrontend.graphql.type.customer.MailingAddress;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
//    createCustomer(firstName: String, lastName: String, email: String!):Customer!
    public Customer createCustomer(String firstName, String lastName, String email){
        return new Customer("id001",Boolean.FALSE,new MailingAddress(),
                "displayName",email,firstName,lastName,"12345679858");
    }
}
