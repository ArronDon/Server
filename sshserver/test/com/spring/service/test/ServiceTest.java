package com.spring.service.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.innovation.identity.model.User;
import com.innovation.identity.service.UserService;

public class ServiceTest {
	@Test
	public void testExists() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.xml");
		UserService userService = (UserService) context.getBean("userService");
		User user = new User();
		user.setUsername("a");

		if (userService.exists(user.getUsername())) {
			System.out.println("error");
		} else {
			userService.add(user);
			System.out.println("success");
		}
	}
}
