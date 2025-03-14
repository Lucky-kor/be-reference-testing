package com.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootTest
class TestingApplicationTests {
	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {
		if (applicationContext != null) {
			String[] beans = applicationContext.getBeanDefinitionNames();
			Arrays.stream(beans)
					.forEach(System.out::println);
		}
	}

}
