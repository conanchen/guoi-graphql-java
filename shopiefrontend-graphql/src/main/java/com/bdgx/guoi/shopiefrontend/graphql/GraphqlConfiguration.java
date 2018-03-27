package com.bdgx.guoi.shopiefrontend.graphql;

import com.bdgx.guoi.shopiefrontend.graphql.type.*;
import com.bdgx.guoi.shopiefrontend.graphql.type.customer.CustomerResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {

    @Bean
    public CatalogResolver catalogResolver() {
        return new CatalogResolver();
    }

    @Bean
    public CatalogConnectionResolver catalogConnectionResolver() {
        return new CatalogConnectionResolver();
    }

    @Bean
    public CatalogEdgeResolver catalogEdgeResolver() {
        return new CatalogEdgeResolver();
    }

    @Bean
    public PageInfoResolver pageInfoResolver() {
        return new PageInfoResolver();
    }

    @Bean
    public CustomerResolver personResolver() {
        return new CustomerResolver();
    }

    @Bean
    public ProductConnectionResolver productConnectionResolver() {
        return new ProductConnectionResolver();
    }


    @Bean
    public ProductEdgeResolver productEdgeResolver() {
        return new ProductEdgeResolver();
    }


    @Bean
    public ProductResolver productResolver() {
        return new ProductResolver();
    }

    @Bean
    public UserResolver userResolver() {
        return new UserResolver();
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
