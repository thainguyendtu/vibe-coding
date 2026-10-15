package com.fpt.shopflow;

import com.fpt.shopflow.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ShopFlowApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
		assertNotNull(userService.getAllUsers());
	}
}
