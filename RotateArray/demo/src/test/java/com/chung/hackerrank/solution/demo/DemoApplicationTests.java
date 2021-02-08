package com.chung.hackerrank.solution.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testRotateArray(){
		int[] a = {1, 2, 3, 4, 5};
		a = DemoApplication.rotLeft(a,4);
		Arrays.stream(a).forEach(System.out::println);

//		int[] a2 = {1, 2, 3, 4, 5};
//		DemoApplication.rotateLeft2(a2,4);
	}
}
