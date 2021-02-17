package com.chung.hackerrank.solution.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.java2d.pipe.SolidTextRenderer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

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

	@Test
	void testActivityNotifications(){
//		int[] a = {1, 2, 3, 4, 4};
//		int i = DemoApplication.activityNotifications(a,4);
//		System.out.println("i: "+i);
//		int[] b = {2, 3, 4, 2, 3, 6, 8, 4, 5};
//		int[] c = new int[b.length];
//
// 		for(int k=0;k<b.length;k++) {
//				c[b[k]]++;
//			}
//
//		Arrays.stream(c).forEach(n->System.out.print(n+" "));
//		System.out.println("");
//
//		for(int j=1;j<c.length;j++){
//			c[j] += c[j-1];
//		}
//		Arrays.stream(c).forEach(n->System.out.print(n+" "));
//		System.out.println("");
//
//		for(int j=c.length-2;j>=0;j--){
//			 c[j+1] =c[j];
//		}
//		Arrays.stream(c).forEach(n->System.out.print(n+" "));
//		System.out.println("");
//
//		int[] s = new int[b.length];
//		for(int j=0;j<b.length;j++){
//			int index_of_n = c[b[j]];
//			c[b[j]]++;
//			s[index_of_n]=b[j];
//		}
//		Arrays.stream(s).forEach(n->System.out.print(n+" "));
//		System.out.println("");
//
//		int studentsOnTime = Arrays.stream(a).filter(q->q>0).reduce(Integer::sum).getAsInt();
//
//
//		String[] magazine = {"give", "me", "one", "grand", "today", "night"};
//		String[] note = {"give", "one", "grand", "today"};
//		HashMap<String,Integer> maps = new HashMap();
//		for(String ss:magazine) {
//			maps.put(ss,maps.get(ss)==null?1:maps.get(ss)+1);
//		}
//
//		Arrays.stream(maps.keySet().stream().toArray()).forEach(sss->{System.out.println(maps.get(sss));});
//		String YesNo="Yes";
//		for(String n:note){
//			if(maps.get(n)==null || maps.get(n)==0){
//				YesNo="No";
//				break;
//			}else{
//				Integer newCount =maps.get(n)-1;
//
//			}
//		}
//
//		System.out.println(YesNo);

		String sssss = "sqwert";
		String[] s_arr = sssss.split("");
		Arrays.stream(s_arr).forEach(System.out::println);
		String s12 = "abab";
		char[] charArr = s12.toCharArray();

		for(int q=0;q<s12.length();q++){
			String sbuStr1 = s12.substring(0,q+1);

			for(int w=q+1;(w+sbuStr1.length())<=s12.length();w++){
				String subStr2 = s12.substring(w,w+sbuStr1.length());
				System.out.println(subStr2);
			}

		}


	}

	@Test
	void testsherlockAndAnagrams(){
		DemoApplication.sherlockAndAnagrams("abba");

	}
}
