package com.bdgx.guoi.shopiefrontend.graphql.types.customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZCustomerConfiguration {

    @Bean
    public CustomerResolver customerResolver() {
        return new CustomerResolver();
    }

}
