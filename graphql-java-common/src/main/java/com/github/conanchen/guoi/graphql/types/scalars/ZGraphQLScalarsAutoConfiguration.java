package com.github.conanchen.guoi.graphql.types.scalars;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZGraphQLScalarsAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public GraphQLDateTime graphQLDateTime() {
        return new GraphQLDateTime();
    }

    @Bean
    @ConditionalOnMissingBean
    public GraphQLMoney graphQLMoney() {
        return new GraphQLMoney();
    }

    @Bean
    @ConditionalOnMissingBean
    public GraphQLURL graphQLURL() {
        return new GraphQLURL();
    }

}