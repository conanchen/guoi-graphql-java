package com.bdgx.guoi.shopiefrontend.graphql;

import com.bdgx.guoi.shopiefrontend.graphql.type.*;
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
    public PersonResolver personResolver() {
        return new PersonResolver();
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
