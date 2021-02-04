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
	void testMatchingStrings(){
		String[] strings ={"aba",
				"baba",
				"aba",
				"xzxb"};
		String[] queries={"aba","xzxb",	"ab"};
		int[] results = DemoApplication.matchingStrings(strings,queries);
		Arrays.stream(results).forEach(System.out::println);

		String[] strings1 ={"def","de","fgh"};
		String[] queries1 ={"de","lmn","fgh"};
		results = DemoApplication.matchingStrings(strings1,queries1);
		Arrays.stream(results).forEach(System.out::println);
	}

}
