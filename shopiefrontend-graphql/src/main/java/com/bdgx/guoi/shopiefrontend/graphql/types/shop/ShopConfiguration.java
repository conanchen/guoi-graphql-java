package com.bdgx.guoi.shopiefrontend.graphql.types.shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopConfiguration {

    @Bean
    public ShopResolver shopResolver() {
        return new ShopResolver();
    }

}
