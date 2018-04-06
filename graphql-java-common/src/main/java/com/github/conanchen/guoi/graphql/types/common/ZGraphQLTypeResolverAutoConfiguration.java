package com.github.conanchen.guoi.graphql.types.common;

import com.github.conanchen.guoi.graphql.types.scalars.GraphQLDateTime;
import com.github.conanchen.guoi.graphql.types.scalars.GraphQLMoney;
import com.github.conanchen.guoi.graphql.types.scalars.GraphQLURL;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZGraphQLTypeResolverAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public AddressResolver addressResolver() {
        return new AddressResolver();
    }


}