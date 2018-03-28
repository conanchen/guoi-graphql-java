package com.bdgx.guoi.shopiefrontend.graphql;

import com.bdgx.guoi.shopiefrontend.graphql.types.PageInfoResolver;
import com.bdgx.guoi.shopiefrontend.graphql.types.catalog.*;
import com.bdgx.guoi.shopiefrontend.graphql.types.customer.CustomerResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZRootConfiguration {


    @Bean
    public PageInfoResolver pageInfoResolver() {
        return new PageInfoResolver();
    }


    @Bean
    public Query query() {
        return new Query();
    }

    @Bean
    public Mutation mutation() {
        return new Mutation();
    }
}
