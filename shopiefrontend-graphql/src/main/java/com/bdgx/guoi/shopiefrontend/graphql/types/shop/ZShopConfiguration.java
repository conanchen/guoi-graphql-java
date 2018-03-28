package com.bdgx.guoi.shopiefrontend.graphql.types.shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZShopConfiguration {

    @Bean
    public ShopResolver shopResolver() {
        return new ShopResolver();
    }

}
