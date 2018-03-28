package com.bdgx.guoi.shopiefrontend.graphql.types.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZOrderConfiguration {

    @Bean
    public OrderConnectionResolver orderConnectionResolver() {
        return new OrderConnectionResolver();
    }

    @Bean
    public OrderEdgeResolver orderEdgeResolver() {
        return new OrderEdgeResolver();
    }

    @Bean
    public OrderResolver orderResolver() {
        return new OrderResolver();
    }

}
