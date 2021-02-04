package com.chung.hackerrank.solution.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// Complete the matchingStrings function below.
	static int[] matchingStrings(String[] strings, String[] queries) {

		int[] countArr = new int[queries.length];

		for(int i=0;i<queries.length;i++){
			int foundCount=0;
			for(int j=0;j<strings.length;j++) {
				if(queries[i].equals(strings[j])){
					foundCount++;
					countArr[i]=foundCount;
				}
			}
		}
		return countArr;

	}
}
