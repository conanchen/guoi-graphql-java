package com.bdgx.guoi.shopiefrontend.graphql.types.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZUserConfiguration {

    @Bean
    public UserResolver userResolver() {
        return new UserResolver();
    }

}
