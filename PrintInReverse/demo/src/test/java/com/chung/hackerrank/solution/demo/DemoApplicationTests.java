package com.chung.hackerrank.solution.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testReversePrint(){

		int[] inputs2 ={16,
				12,
				4,
				6,
			    3};
		DemoApplication.SinglyLinkedListNode head2 = DemoApplication.buildLinkedList(inputs2);
		DemoApplication.reversePrint(head2);
		System.out.println("---------------");

		int[] inputs3 ={16,
						12,
						4,
						2,
						5};
		DemoApplication.SinglyLinkedListNode head3 = DemoApplication.buildLinkedList(inputs3);
		DemoApplication.reversePrint(head3);

	}
}
