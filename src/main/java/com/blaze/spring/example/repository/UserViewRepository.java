package com.blaze.spring.example.repository;

import com.blaze.spring.example.domain.User;
import com.blaze.spring.example.service.views.UserView;
import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.integration.graphql.GraphQLEntityViewSupport;
import com.blazebit.persistence.integration.graphql.GraphQLEntityViewSupportFactory;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Stream;

@Component
public class UserViewRepository {

	private final EntityViewManager evm;
	private final EntityManager em;
	private final CriteriaBuilderFactory cbf;
	private final GraphQLEntityViewSupport graphQLEntityViewSupport;

	public UserViewRepository(
			EntityViewManager evm,
			EntityManager em,
			CriteriaBuilderFactory cbf,
			GraphQLEntityViewSupport graphQLEntityViewSupport
	) {
		this.evm = evm;
		this.em = em;
		this.cbf = cbf;
		this.graphQLEntityViewSupport = graphQLEntityViewSupport;
	}

	public List<UserView> getAllUsers(DataFetchingEnvironment dataFetchingEnvironment) {
		CriteriaBuilder<User> criteriaBuilder = cbf.create(em, User.class);
		CriteriaBuilder<UserView> userProfileBuilder = evm.applySetting(graphQLEntityViewSupport.createSetting(
				dataFetchingEnvironment), criteriaBuilder);
		return userProfileBuilder.getQuery().getResultList();
	}

	public UserView saveUser(UserView userView) {
		evm.save(em, userView);
		return userView;
	}
}
