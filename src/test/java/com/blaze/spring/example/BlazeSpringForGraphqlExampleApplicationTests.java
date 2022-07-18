package com.blaze.spring.example;

import com.blaze.spring.example.service.UserService;
import com.blazebit.persistence.view.EntityViewManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
class BlazeSpringForGraphqlExampleApplicationTests {
	@Autowired UserService userService;

	@Autowired EntityViewManager evm;

	@Autowired EntityManager em;

	@Test
	void contextLoads() {
	}
}
