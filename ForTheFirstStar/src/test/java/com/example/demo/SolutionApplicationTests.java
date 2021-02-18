package com.example.demo;

import net.bytebuddy.matcher.ElementMatcher;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SolutionApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testdiagonalDifference(){
		List<List<Integer>> inputs = new ArrayList<>();
		Integer[] num1 = {1,2,3,4};
		Integer[] num2 = {4,5,6,7};
		Integer[] num3 = {9,8,7,6};
		Integer[] num4 = {6,7,8,9};
		List<Integer> numAr1 = new ArrayList<>(Arrays.asList(num1));
		List<Integer> numAr2 = new ArrayList<>(Arrays.asList(num2));
		List<Integer> numAr3 = new ArrayList<>(Arrays.asList(num3));
		List<Integer> numAr4 = new ArrayList<>(Arrays.asList(num4));
		inputs.add(0,numAr1);
		inputs.add(1,numAr2);
		inputs.add(2,numAr3);
		inputs.add(3,numAr4);
		int result = SolutionApplication.diagonalDifference(inputs);

		assertTrue(result==2);

	}

	@Test
	void testPlusMinus(){
		int[] inputs = {-4, 3, -9, 0, 4, 1 };
		SolutionApplication.plusMinus(inputs);
		int[] inputs2 = {1, 1, 0, -1,-1 };
		SolutionApplication.plusMinus(inputs2);

	}

	@Test
	void testStaircase(){
		SolutionApplication.staircase(10);
	}

	@Test
	void testMiniMaxSum(){
		int[] inputs = {1200000000,999999999,7,1000000001,1};
		SolutionApplication.miniMaxSum(inputs);
	}

	@Test
	void testbBirthdayCakeCandles(){
		ArrayList<Integer> inputs = new ArrayList<>();
		inputs.add(3);
		inputs.add(9);
		inputs.add(3);
		inputs.add(9);
		inputs.add(4);
		SolutionApplication.birthdayCakeCandles(inputs);
	}

	@Test
	void testSimpleArraySum(){
		int[] ar = {1,3,4,2,5,6,7};
		int result = SolutionApplication.simpleArraySum(ar);
		System.out.println(result);

	}

	@Test
	void testTimeConversion(){
		String input = "07:05:45PM";
		String s = SolutionApplication.timeConversion(input);
		System.out.println(s);
	}

	@Test
	void testFormingMagicSquare(){
		int[][]s = {{5, 3, 4}, {1, 5, 8}, {6, 4, 2}};
		SolutionApplication.formingMagicSquare(s);

		int[][]s1 = {{4, 9, 2}, {3, 5, 7}, {8, 1, 5}};
		SolutionApplication.formingMagicSquare(s1);

		int[][]s2 = {{4, 8, 2}, {4, 5, 7}, {6, 1, 6}};
		SolutionApplication.formingMagicSquare(s2);

		System.out.println(17%5);
	}

	@Test
	void testGradingStudents(){
		ArrayList<Integer> inputs = new ArrayList<>();
		inputs.add(73);
		inputs.add(67);
		inputs.add(38);
		inputs.add(33);

		SolutionApplication.gradingStudents(inputs).stream().forEach(System.out::println);
	}

	@Test
	void testBreakingRecords(){
		int[] inputs = {10, 5, 20, 20, 4, 5, 2, 25, 1};
		int[] outputs = SolutionApplication.breakingRecords(inputs);

		Arrays.stream(outputs).forEach(System.out::println);

		int[] inputs2 = {3, 4, 21, 36, 10, 28, 35, 5, 24, 42};
		int[] outputs2 = SolutionApplication.breakingRecords(inputs2);

		Arrays.stream(outputs2).forEach(System.out::println);
	}


	@Test
	void testKangaroo(){
		System.out.println(SolutionApplication.kangaroo(0,3,4,2));
		System.out.println(SolutionApplication.kangaroo(0,2,5,3));
		System.out.println(SolutionApplication.kangaroo(0,2,0,3));
		System.out.println(SolutionApplication.kangaroo(0,6,9,2));
	}

	@Test
	void testGetTotalX(){
		ArrayList<Integer> fInputs = new ArrayList<>();
		ArrayList<Integer> sInputs = new ArrayList<>();
		fInputs.add(2);fInputs.add(6);
		sInputs.add(24);sInputs.add(36);
		int result = SolutionApplication.getTotalX(fInputs,sInputs);
		System.out.println("Answer: "+result);

		ArrayList<Integer> fInputs2 = new ArrayList<>();
		ArrayList<Integer> sInputs2 = new ArrayList<>();
		fInputs2.add(2);fInputs2.add(4);
		sInputs2.add(16);sInputs2.add(32);sInputs2.add(96);
		int result2 = SolutionApplication.getTotalX(fInputs2,sInputs2);
		System.out.println("Answer: "+result2);

		ArrayList<Integer> fInputs3 = new ArrayList<>();
		ArrayList<Integer> sInputs3 = new ArrayList<>();
		fInputs3.add(1);
		sInputs3.add(72);sInputs3.add(48);
		int result3 = SolutionApplication.getTotalX(fInputs3,sInputs3);
		System.out.println("Answer: "+result3);
	}

	@Test
	void testDivisibleSumPairs(){
		int[] input = {1, 3, 2, 6, 1, 2};
		int k = 3;
		int result=SolutionApplication.divisibleSumPairs(input.length,k,input);
		assertTrue(result==5);
	}

	@Test
	void testMigratoryBirds(){
		int[] i = {1, 4, 4, 4, 5, 3};
		List<Integer> arr = Arrays.stream(i).boxed().collect(Collectors.toList());
        int final1 = SolutionApplication.migratoryBirds(arr);
		assertTrue(final1==4);
		int[] i2 = {1, 4, 4, 4, 5, 5, 5, 3};
		List<Integer> arr2 = Arrays.stream(i2).boxed().collect(Collectors.toList());
		int final2 = SolutionApplication.migratoryBirds(arr2);
		assertTrue(final2==4);

		int[] i3 = {1, 2,2,2, 4, 4, 4, 5, 5, 5, 3};
		List<Integer> arr3 = Arrays.stream(i3).boxed().collect(Collectors.toList());
		int final3 = SolutionApplication.migratoryBirds(arr3);
		assertTrue(final3==2);

		int[] i4 = {1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4};
		List<Integer> arr4 = Arrays.stream(i4).boxed().collect(Collectors.toList());
		int final4 = SolutionApplication.migratoryBirds(arr4);
		assertTrue(final4==3);

		int[] i5 = {1, 0};
		List<Integer> arr5 = Arrays.stream(i5).boxed().collect(Collectors.toList());
		int final5 = SolutionApplication.migratoryBirds(arr5);
		assertTrue(final5==0);

		int[] i6 = {1, 1,1,1,1,1,1};
		List<Integer> arr6 = Arrays.stream(i6).boxed().collect(Collectors.toList());
		int final6 = SolutionApplication.migratoryBirds(arr6);
		assertTrue(final6==1);


	}

	@Test
	void testBonAppetit(){
		int[] arr = {3, 10, 2, 9};
		List<Integer> inputList = Arrays.stream(arr).boxed().collect(Collectors.toList());
		SolutionApplication.bonAppetit(inputList,1,12);

		int[] arr2 = {3, 10, 2, 9};
		List<Integer> inputList2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());
		SolutionApplication.bonAppetit(inputList2,1,7);

		int[] arr3 = {3, 10, 2, 10};
		List<Integer> inputList3 = Arrays.stream(arr3).boxed().collect(Collectors.toList());
//		inputList3.stream().forEach(System.out::println);
		SolutionApplication.bonAppetit(inputList3,1,8);
	}

	@Test
	void testHurdleRace() {
		int result1 = SolutionApplication.hurdleRace(4,new int[]{1, 6, 3, 5, 2});
		assertTrue(result1==2);
		int result2 = SolutionApplication.hurdleRace(1,new int[]{1, 2, 3, 3, 2});
		assertTrue(result2==2);
		int result3 = SolutionApplication.hurdleRace(7,new int[]{2, 5, 4, 5, 2});
		assertTrue(result3==0);
		int result4 = SolutionApplication.hurdleRace(13,new int[]{1, 1, 1, 1, 1,1,1,1});
		assertTrue(result4==0);
	}

	@Test
	void testCatAndMouse(){
		String s1 = SolutionApplication.catAndMouse(1,2,3);
		assertTrue(s1.equals("Cat B"));
		String s2 = SolutionApplication.catAndMouse(1,3,2);
		assertTrue(s2.equals("Mouse C"));

	}

	@Test
	void testDesignerPdfViewer(){
		int result = SolutionApplication.designerPdfViewer(new int[]{1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5,5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},"abc");
		assertTrue(result==9);
		int result2 = SolutionApplication.designerPdfViewer(new int[]{1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7},"zaba");
		assertTrue(result2==28);
	}

	@Test
	void testMissingNumbers(){
		int[] results = SolutionApplication.missingNumbers(new int[]{203, 204, 205, 206, 207, 208, 203, 204, 205, 206},
											   			   new int[]{203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204});

		assertArrayEquals(results,new int[]{204,205,206});

		int[] results2 = SolutionApplication.missingNumbers(new int[]{1,2,3,4,5,6},
															new int[]{1,2,3,4,5,6,7,8,9});

		assertArrayEquals(results2,new int[]{7,8,9});
	}

	@Test
	void testBalancedSums(){
		String result;

		int[] arr = {1, 1, 4, 1, 1};
		List<Integer> inputs = Arrays.stream(arr).boxed().collect(Collectors.toList());
		result = SolutionApplication.balancedSums(inputs);
		assertTrue(result.equals("YES"));

		arr = new int[]{5,6,8,11};
		inputs = Arrays.stream(arr).boxed().collect(Collectors.toList());
		result = SolutionApplication.balancedSums(inputs);
		assertTrue(result.equals("YES"));

		arr = new int[]{1,2,3,5,6};
		inputs = Arrays.stream(arr).boxed().collect(Collectors.toList());
		result = SolutionApplication.balancedSums(inputs);
		assertTrue(result.equals("YES"));

		arr = new int[]{2,0,0,0};
		inputs = Arrays.stream(arr).boxed().collect(Collectors.toList());
		result = SolutionApplication.balancedSums(inputs);
		assertTrue(result.equals("YES"));

		arr = new int[]{0,0,2,0};
		inputs = Arrays.stream(arr).boxed().collect(Collectors.toList());
		result = SolutionApplication.balancedSums(inputs);
		assertTrue(result.equals("YES"));

		arr = new int[]{1,2,3};
		inputs = Arrays.stream(arr).boxed().collect(Collectors.toList());
		result = SolutionApplication.balancedSums(inputs);
		assertTrue(result.equals("NO"));

		arr = new int[]{1,2,3,3};
		inputs = Arrays.stream(arr).boxed().collect(Collectors.toList());
		result = SolutionApplication.balancedSums(inputs);
		assertTrue(result.equals("YES"));

		arr = new int[]{1,2,3,3,2,3,4,6,1,4};
		inputs = Arrays.stream(arr).boxed().collect(Collectors.toList());
		result = SolutionApplication.balancedSums(inputs);
		assertTrue(result.equals("NO"));

		arr = new int[]{0,0,0,2};
		inputs = Arrays.stream(arr).boxed().collect(Collectors.toList());
		result = SolutionApplication.balancedSums(inputs);
		assertTrue(result.equals("YES"));

	}

	@Test
	void testViralAdvertising(){
		int result = SolutionApplication.viralAdvertising(3);
		assertTrue(result==9);
	}

	@Test
	void testCamelcase(){

		int result = SolutionApplication.camelcase("oneTwoThreeFour");
		System.out.println(result);
		int result2 = SolutionApplication.camelcase("saveChangesInTheEditor");
		System.out.println(result2);

	}

	@Test
	void testMakingAnagrams() {
		int num = SolutionApplication.makingAnagrams("cde","abc");
		assertTrue(num==4);
		num = SolutionApplication.makingAnagrams("abcadefg","awerftyhg");
		assertTrue(num==9);       //aefg
		num = SolutionApplication.makingAnagrams("abcdef","xyz");
		assertTrue(num==9);
		num = SolutionApplication.makingAnagrams("abcde","abcde");
		assertTrue(num==0);
		num = SolutionApplication.makingAnagrams("abcdegggggggg","abcdexxxxxxxxx");
		assertTrue(num==17);
		num = SolutionApplication.makingAnagrams("abcdeggggggggg","abcdegggggggg");
		assertTrue(num==1);

//
//		num = SolutionApplication.makingAnagrams("absdjkvuahdakejfnfauhdsaavasdlkj","djfladfhiawasdkjvalskufhafablsdkashlahdfa");
//		System.out.println(num);


	}

	@Test
	void testGameOfThrones(){
		String s = SolutionApplication.gameOfThrones("aabbccddf");
		assertTrue(s.equals("YES"));
		s=SolutionApplication.gameOfThrones("cdefghmnopqrstuvw");
		assertTrue(s.equals("NO"));
		s=SolutionApplication.gameOfThrones("cdcdcdcdeeeef");
		assertTrue(s.equals("YES"));
		s=SolutionApplication.gameOfThrones("aaabbbb");
		assertTrue(s.equals("YES"));
		s=SolutionApplication.gameOfThrones("aaaaaaaaaaah");
		assertTrue(s.equals("NO"));
		s=SolutionApplication.gameOfThrones("aaaaaaaaaah");
		assertTrue(s.equals("YES"));
		s=SolutionApplication.gameOfThrones("haaaaaaaaaah");
		assertTrue(s.equals("YES"));
		s=SolutionApplication.gameOfThrones("haaaaaaaaaahh");
		assertTrue(s.equals("YES"));
		s=SolutionApplication.gameOfThrones("haaaaaaaaah");
		assertTrue(s.equals("YES"));
		s=SolutionApplication.gameOfThrones("haaaaaaaaa");
		assertTrue(s.equals("NO"));
		s=SolutionApplication.gameOfThrones("aaaaaaaaa");
		assertTrue(s.equals("YES"));
		//aaaaahhhaaaaa
	}

	@Test
	void testStringConstruction(){
		SolutionApplication.stringConstruction("abc");
	}

	@Test
	void testIfElse() {
		SolutionApplication.ifelse(24);
	}

	@Test
	void testMinimumNumber(){

		int n = SolutionApplication.minimumNumber(3,"Ab1");
		assertTrue(n==3);
		//
		n = SolutionApplication.minimumNumber(11,"#HackerRank");
		assertTrue(n==1);

		n = SolutionApplication.minimumNumber(11,"2bbb");
		assertTrue(n==2);

		n = SolutionApplication.minimumNumber(11,"&+^&");
		assertTrue(n==3);

		n = SolutionApplication.minimumNumber(11,"&+12");
		assertTrue(n==2);

		n = SolutionApplication.minimumNumber(11,"&2a");
		assertTrue(n==3);
	}

	@Test
	void testSquares() {
//		int n = SolutionApplication.squares(3,9);
//		assertTrue(n==2);
//		n = SolutionApplication.squares(17,24);
//		assertTrue(n==0);
//		n = SolutionApplication.squares(24,49);
//		assertTrue(n==3);
//		n = SolutionApplication.squares(101,101);
//		assertTrue(n==0);
//		n = SolutionApplication.squares(19,21);
//		assertTrue(n==0);
//		n = SolutionApplication.squares(35,70);
//		assertTrue(n==3);
//		n = SolutionApplication.squares(1,1000);
//		assertTrue(n==31);
//		n = SolutionApplication.squares(270,303);
//		assertTrue(n==1);
//		n = SolutionApplication.squares(4,4);
//		assertTrue(n==1);
		int n = SolutionApplication.squares(212,676);
		assertTrue(n==12);
//		int n1 = SolutionApplication.squares1(4,4);

	}

	@Test
	void testPrintLinkedList(){
		SolutionApplication.runLinkedList();
	}

	@Test
	void testPowerSum(){
		int X =100;
		int N =2;
		System.out.println(Math.pow(X,(1/(double)N)));
		int max = (int)Math.ceil(Math.pow(X,(1/(double)N)));
		max=Math.pow(max,N)>X?max-1:max;
		System.out.println("max: "+max);
		HashMap<Double,Double> elements = new HashMap();

		for(int i=1;i<=max;i++){
			double value = Math.pow(i,N);
			elements.put(value,X-value);
		}
		elements.keySet().stream().forEach(a->System.out.println(a+ " "+elements.get(a)));
		List<Double>e0 = elements.keySet().stream().filter(a->a==X).collect(Collectors.toList());
		System.out.println("-------------");
		e0.stream().forEach(System.out::println);
		e0.stream().forEach(elements::remove);
		elements.keySet().stream().forEach(a->System.out.println(a+ " "+elements.get(a)));
		System.out.println("-------------");

		List<Double> e1 = elements.keySet().stream().filter(a->elements.get(elements.get(a))!=null).collect(Collectors.toList());
		e1.stream().forEach(System.out::println);
		e1.stream().forEach(elements::remove);
		elements.keySet().stream().forEach(a->System.out.println(a+ " "+elements.get(a)));
		System.out.println("-------------");

		Object[] elementArray = elements.keySet().stream().toArray();
		for(int j=0;j<elementArray.length;j++){
			for(int m=j;m<elementArray.length;m++) {

			}
		}


//		List<Double> e2 = elements.keySet().stream().filter(a->elements.get(a)))
//		SolutionApplication.powerSum(100,2);
//		SolutionApplication.powerSum(200,2);



		//find max by doing nth root
		//loop i=max ; i>=max ; i--
		// 	do r = X - max
		//  if r == X then add to r_array
		//  else new_target = r and add r to array_for_sum


	}

	@Test
	void testDeleteNode(){
//		int[] inputs ={20,
//				6,
//				2,
//				19,
//				7,
//				4,
//				15,
//				9};
//		SolutionApplication.SinglyLinkedListNode head = SolutionApplication.buildLinkedList(inputs);
//		SolutionApplication.deleteNode(head,3);
//		System.out.println("---------------");
		int[] inputs2 ={11,
				12,
				8,
				18,
				16,
				5,
				18};
		SolutionApplication.SinglyLinkedListNode head2 = SolutionApplication.buildLinkedList(inputs2);
		SolutionApplication.deleteNode(head2,0);

	}

	@Test
	void testReversePrint(){
		int[] inputs2 ={11,
				12,
				8,
				18,
				16,
				5,
				18};
		SolutionApplication.SinglyLinkedListNode head2 = SolutionApplication.buildLinkedList(inputs2);
		SolutionApplication.reversePrint(head2);
	}

	@Test
	void testJavaString(){
		SolutionApplication.javaString("hello","world");
		SolutionApplication.javaString("hello","java");
		SolutionApplication.javaString("java","java");
	}
}
