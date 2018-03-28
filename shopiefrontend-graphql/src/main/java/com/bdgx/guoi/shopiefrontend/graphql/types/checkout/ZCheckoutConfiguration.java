package com.bdgx.guoi.shopiefrontend.graphql.types.checkout;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZCheckoutConfiguration {

    @Bean
    public CheckoutConnectionResolver checkoutConnectionResolver() {
        return new CheckoutConnectionResolver();
    }


    @Bean
    public CheckoutEdgeResolver checkoutEdgeResolver() {
        return new CheckoutEdgeResolver();
    }



    @Bean
    public CheckoutLineItemConnectionResolver checkoutLineItemConnectionResolver() {
        return new CheckoutLineItemConnectionResolver();
    }


    @Bean
    public CheckoutLineItemEdgeResolver checkoutLineItemEdgeResolver() {
        return new CheckoutLineItemEdgeResolver();
    }


    @Bean
    public CheckoutLineItemResolver checkoutLineItemResolver() {
        return new CheckoutLineItemResolver();
    }

    @Bean
    public CheckoutResolver checkoutResolver() {
        return new CheckoutResolver();
    }
}
