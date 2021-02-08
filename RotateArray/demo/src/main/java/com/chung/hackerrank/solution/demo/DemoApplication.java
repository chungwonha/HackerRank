package com.chung.hackerrank.solution.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.LinkedList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	static int[] rotLeft(int[] a, int d) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		Arrays.stream(a).forEach(value ->{linkedList.add(value);});
		for(int i=0;i<d;i++) {
			int firstItem =linkedList.getFirst();
			linkedList.addLast(firstItem);
			linkedList.remove(0);
		}
		a = linkedList.stream().mapToInt(i->i).toArray();

		return a;

	}

//	static int[] rotateLeft2(int[] a, int d){
//		int[] aa = new int[d];
//
//		for(int i=0;i<d;i++){
//			int firstItem = a[i];
//			aa[a.length-i-1]=firstItem;
//		}
//
//		Arrays.stream(aa).forEach(System.out::println);
//		return new int[0];
//	}
}
