package com.chung.hackerrank.solution.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
		List<List<Integer>> arr = new ArrayList<List<Integer>>();
		Integer lastAnswer =0;
		List<Integer> answer = new ArrayList<>();


		for(int i=0;i<n;i++) {
			   ArrayList<Integer> ar = new ArrayList();
			   arr.add(ar);
		}

		arr.stream().forEach(each->each.stream().forEach(System.out::println));
		for(List eachList:queries) {

			int qID = (Integer)eachList.get(0);
			int x = (Integer)eachList.get(1);
			int y = (Integer)eachList.get(2);

			int idx = (x^lastAnswer)%n;
			List idxList = arr.get(idx);

//			lastAnswer = idxList.size()==0?0:(Integer)idxList.get(idxList.size()-1);

			if(qID==1){
				idxList.add(y);
			}else if(qID==2){

				lastAnswer = (Integer)idxList.get(y%idxList.size());
				answer.add(lastAnswer);
				System.out.println(lastAnswer);
			}
		}

		arr.stream().forEach(each->{each.stream().forEach(a->{
				System.out.print(a+" ");
			});
			System.out.println("");
		});

		return answer;
	}
}
