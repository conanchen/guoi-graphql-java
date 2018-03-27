package com.bdgx.guoi.shopiefrontend.graphql.types.cart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CartConfiguration {

    @Bean
    public CartConnectionResolver cartConnectionResolver() {
        return new CartConnectionResolver();
    }

    @Bean
    public CartEdgeResolver cartEdgeResolver() {
        return new CartEdgeResolver();
    }

    @Bean
    public CartLineItemConnectionResolver cartLineItemConnectionResolver() {
        return new CartLineItemConnectionResolver();
    }

    @Bean
    public CartLineItemEdgeResolver cartLineItemEdgeResolver() {
        return new CartLineItemEdgeResolver();
    }

    @Bean
    public CartLineItemResolver cartLineItemResolver() {
        return new CartLineItemResolver();
    }

    @Bean
    public CartResolver cartResolver() {
        return new CartResolver();
    }

}
