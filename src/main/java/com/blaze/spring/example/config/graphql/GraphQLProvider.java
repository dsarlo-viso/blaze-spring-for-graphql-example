package com.blaze.spring.example.config.graphql;

import com.blazebit.persistence.integration.graphql.GraphQLEntityViewSupport;
import com.blazebit.persistence.integration.graphql.GraphQLEntityViewSupportFactory;
import com.blazebit.persistence.view.EntityViewManager;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.graphql.execution.GraphQlSource;

import javax.annotation.PostConstruct;

/**
 * This configuration class sets up GraphQL entity view support and uses the autoconfigured spring GraphQlSource to grab
 * the graphql schema spring for graphql sets up for us
 */
@Configuration
public class GraphQLProvider {

	final EntityViewManager evm;
	final GraphQlSource graphQlSource;

	private GraphQLEntityViewSupport graphQLEntityViewSupport;

	public GraphQLProvider(EntityViewManager evm, GraphQlSource graphQlSource) {
		this.evm = evm;
		this.graphQlSource = graphQlSource;
	}

	@PostConstruct
	public void init() {
		GraphQLEntityViewSupportFactory graphQLEntityViewSupportFactory = new GraphQLEntityViewSupportFactory(
				false,
				false
		);
		graphQLEntityViewSupportFactory.setImplementRelayNode(false);
		graphQLEntityViewSupportFactory.setDefineRelayNodeIfNotExist(false);
		graphQLEntityViewSupport = graphQLEntityViewSupportFactory.create(graphQlSource.schema(), evm);
	}

	@Bean
	@Scope (ConfigurableBeanFactory.SCOPE_SINGLETON)
	@Lazy (false)
	public GraphQLEntityViewSupport graphQLEntityViewSupport() {
		return graphQLEntityViewSupport;
	}

}
