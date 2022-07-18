package com.blaze.spring.example.config.graphql;

import graphql.scalars.ExtendedScalars;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

/**
 * This is a configuration file for extended scalar support
 */
@Configuration
public class GraphQLScalarConfig implements RuntimeWiringConfigurer {
    @Override
    public void configure(RuntimeWiring.Builder builder) {
        builder
            .scalar(ExtendedScalars.DateTime)
            .build();
    }
}
