package com.chung.hackerrank.solution.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testDynamicArray() {
		int size = 2;
		int[][] inputs = {{1,0,5},
						{1,1,7},
						{1,0,3},
						{2,1,0},
						{2,1,1}};
		List<List<Integer>> input = new ArrayList<>();
		for(int i=0;i<inputs.length;i++) {

			ArrayList<Integer> subInput = new ArrayList<>();
			subInput.add(inputs[i][0]);
			subInput.add(inputs[i][1]);
			subInput.add(inputs[i][2]);
			input.add(subInput);
		}

		DemoApplication.dynamicArray(2,input);
	}
}
