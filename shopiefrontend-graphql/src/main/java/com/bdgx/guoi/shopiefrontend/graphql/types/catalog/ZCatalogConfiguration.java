package com.bdgx.guoi.shopiefrontend.graphql.types.catalog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZCatalogConfiguration {

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


}
