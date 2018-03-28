package com.bdgx.guoi.shopiefrontend.graphql;

import com.bdgx.guoi.graphql.types.common.AttributeInput;
import com.bdgx.guoi.shopiefrontend.graphql.types.checkout.mutation.*;
import com.bdgx.guoi.shopiefrontend.graphql.types.customer.Customer;
import com.bdgx.guoi.shopiefrontend.graphql.types.customer.MailingAddress;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class Mutation implements GraphQLMutationResolver {
    //    createCustomer(firstName: String, lastName: String, email: String!):Customer!
    public Customer createCustomer(String firstName, String lastName, String email) {
        return new Customer("id001", Boolean.FALSE, new MailingAddress(),
                "displayName", email, firstName, lastName, "12345679858");
    }

    //    checkoutCreate(mutation: CheckoutCreateInput!):CheckoutCreatePayload!
    public CheckoutCreatePayload checkoutCreate(CheckoutCreateInput input) {
        throw new NotImplementedException();
    }

    //    noUsedCheckoutCreate1(input: [CheckoutLineItemInput!]):CheckoutCreatePayload!
    public CheckoutCreatePayload noUsedCheckoutCreate1(CheckoutLineItemInput input) {
        // NO USED, only for workaround, Nested Input Types Are Not Working (again) #77
        // https://github.com/graphql-java/graphql-java-tools/issues/77
        throw new NoSuchElementException();
    }

    //    noUsedCheckoutCreate2(input: AttributeInput):CheckoutCreatePayload!
    public CheckoutCreatePayload noUsedCheckoutCreate2(AttributeInput input) {
        // NO USED, only for workaround, Nested Input Types Are Not Working (again) #77
        // https://github.com/graphql-java/graphql-java-tools/issues/77
        throw new NoSuchElementException();
    }

    //    noUsedCheckoutCreate3(input: MailingAddressInput):CheckoutCreatePayload!
    public CheckoutCreatePayload noUsedCheckoutCreate3(MailingAddressInput input) {
        // NO USED, only for workaround, Nested Input Types Are Not Working (again) #77
        // https://github.com/graphql-java/graphql-java-tools/issues/77
        throw new NoSuchElementException();

    }

    //        #Updates the shipping address of an existing checkout.
//    checkoutShippingAddressUpdate(
//        # The shipping address to where the line items will be shipped
//            shippingAddress: MailingAddressInput!
//            # The ID of the checkout
//            checkoutId: ID!
//    ): CheckoutShippingAddressUpdatePayload!
    public CheckoutShippingAddressUpdatePayload checkoutShippingAddressUpdate(
            MailingAddressInput shippingAddress,
            String id) {
        throw new NotImplementedException();
    }

//    checkoutCompleteFree(checkoutId: ID!): CheckoutCompleteFreePayload!
    public CheckoutCompleteFreePayload checkoutCompleteFree(String checkoutId){
       throw new NotImplementedException();
    }
}
