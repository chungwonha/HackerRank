package com.chung.hackerrank.solution.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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

		int[] aa = {1,2,4,2,44,55};
		int[] sorted_p = Arrays.stream(aa).sorted().toArray();

		System.out.println("-> "+Math.round(6/2));

		return a;

	}

	static int activityNotifications(int[] expenditure, int d) {

		int notificationCounter=0;

		for(int i=0;i<expenditure.length;i++){
			int[] subArr = new int[d];
			if(i+d==expenditure.length){
				break;
			}

			for(int j=0;j<d;j++){
				subArr[j]=expenditure[i+j];
			}

			int[] sorted_e = Arrays.stream(subArr).sorted().toArray();
			double median;
			if(d%2==0){
				//even number
				int num = d/2;
				median = (sorted_e[num]+sorted_e[num-1])/2.0;
			}else{
				//odd number
				median = sorted_e[Math.round(d/2)];
			}

			if((2*median)<=expenditure[d+i]){
				notificationCounter++;
			}
		}
		return notificationCounter;

	}

	static int sherlockAndAnagrams(String s) {

		          /*
          abba
          abcd
          1. substring and grap more letter for each cycle
                ->substring(0,1)
                    substring(1,2)
                    substring(2,3)
                    substring(3,4)
                ->substring(0,2)
                    substring(1,3)
                    substring(2,4)
                ->substring(0,3)
                  substring(1,4)

          2. calculate sum of ascii value
          3. put in hashmap with the summed ascii value as a key
             (12:{"ab","ba"})

          4. find
          */
		int strLengthIncr=0;
		HashMap<String, String> stringBucket = new HashMap<>();

		for(int i=1;i<=s.length();i++){
			for(int j=0;j<s.length();j++) {
				if(j+i>s.length()){
					break;
				}
				String subStr = s.substring(j, j+i);

			}
		}
		Arrays.stream(stringBucket.keySet().toArray()).forEach(a->System.out.println(a+"->"+stringBucket.get(a)));
		return 0;
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
