package com.bdgx.guoi.shopiefrontend.graphql.types.order;

import com.bdgx.guoi.shopiefrontend.graphql.Mutation;
import com.bdgx.guoi.shopiefrontend.graphql.Query;
import com.bdgx.guoi.shopiefrontend.graphql.types.PageInfoResolver;
import com.bdgx.guoi.shopiefrontend.graphql.types.catalog.*;
import com.bdgx.guoi.shopiefrontend.graphql.types.customer.CustomerResolver;
import com.bdgx.guoi.shopiefrontend.graphql.types.user.UserResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlOrderConfiguration {

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
