package com.blaze.spring.example.service;

import com.blaze.spring.example.repository.UserViewRepository;
import com.blaze.spring.example.service.views.UserView;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.BaseStream;

@Transactional
@Service
public class UserService {

	private final UserViewRepository userViewRepository;

	public UserService(UserViewRepository userViewRepository) {
		this.userViewRepository = userViewRepository;
	}

	public List<UserView> getAllUsers(DataFetchingEnvironment dataFetchingEnvironment) {
		return userViewRepository.getAllUsers(dataFetchingEnvironment);
	}

	public UserView saveUser(UserView userView) {
		return userViewRepository.saveUser(userView);
	}
}
