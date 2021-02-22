package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static jdk.nashorn.internal.objects.NativeArray.reduce;

@SpringBootApplication
public class SolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolutionApplication.class, args);
	}

	public static int diagonalDifference(List<List<Integer>> arr) {

		ArrayList<Integer> firstDiag=new ArrayList();
		ArrayList<Integer> secondDiag=new ArrayList();

		arr.stream().forEach(l -> {
						int index = arr.indexOf(l);
						System.out.println("index: "+index);
						System.out.println(l.get(index));
						System.out.println(l.get((l.size()-1)-index));
						firstDiag.add(l.get(index));
						secondDiag.add(l.get((l.size()-1)-index));
					}
				);
		Integer diff = firstDiag.stream().reduce(0,Integer::sum)-
				   secondDiag.stream().reduce(0,Integer::sum);

		return Math.abs(diff);
	}

	static void plusMinus(int[] arr) {

		double zeros = new Double(Arrays.stream(arr).filter(i->i==0).count())/new Double(arr.length);
		double pos = new Double(Arrays.stream(arr).filter(i->i>0).count())/new Double(arr.length);
		double neg = new Double(Arrays.stream(arr).filter(i->i<0).count())/new Double(arr.length);

		System.out.println(new DecimalFormat("0.000000").format(new Double(pos)));
		System.out.println(new DecimalFormat("0.000000").format(new Double(neg)));
		System.out.println(new DecimalFormat("0.000000").format(new Double(zeros)));
	}

	static void staircase(int n) {

		for(int j=0;j<n;j++) {
			System.out.println(String.join("",Collections.nCopies(n-j-1," "))+String.join("",Collections.nCopies(j+1,"#")));
		}

	}

	//https://www.hackerrank.com/challenges/mini-max-sum/problem
	/*Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.

	Example
	The minimum sum is and the maximum sum is . The function prints

	 */
	static void miniMaxSum(int[] arr) {
		Arrays.sort(arr);
		Arrays.stream(arr).forEach(i->{
			System.out.println(i);
		});
		long min = (long)arr[0]+(long)arr[1]+(long)arr[2]+(long)arr[3];
		long max = (long)arr[1]+(long)arr[2]+(long)arr[3]+(long)arr[4];
		System.out.println(min + " " +max);
	}

	public static int birthdayCakeCandles(List<Integer> candles) {
		Optional<Integer> max = candles.stream().reduce(Integer::max);
		List<Integer> tallest = candles.stream().filter(c->c.equals(max.get())).collect(toList());

		System.out.println("max: "+max.get());
		System.out.println("tallest.size(): "+tallest.size());
		return tallest.size();
	}

	//https://www.hackerrank.com/challenges/simple-array-sum/problem
	static int simpleArraySum(int[] ar) {

		return Arrays.stream(ar).sum();
	}

	/*
	 * Complete the timeConversion function below.
	 */
	static String timeConversion(String s) {
		try {
			SimpleDateFormat displayFormat = new SimpleDateFormat("hh:mm:ssa");
			SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm:ssa");
			Date date = parseFormat.parse(s);
			Date date2 = displayFormat.parse(s);
//			System.out.println(parseFormat.format(date) + " = " + displayFormat.format(date));
			System.out.println(date2);
			String m_time = displayFormat.format(date2);
			return m_time.substring(0,m_time.length()-2);
		}catch (Exception e){
			e.printStackTrace();
		}
		return "";
	}

	/*We define a magic square to be an matrix of distinct positive integers from to where the sum of any row, column, or diagonal of length

is always equal to the same number: the magic constant.

You will be given a
matrix of integers in the inclusive range . We can convert any digit to any other digit in the range at cost of . Given

, convert it into a magic square at minimal cost. Print this cost on a new line.

Note: The resulting magic square must contain distinct integers in the inclusive range

.

Example

$s = [[5, 3, 4], [1, 5, 8], [6, 4, 2]]

The matrix looks like this:

5 3 4
1 5 8
6 4 2

We can convert it to the following magic square:

8 3 4
1 5 9
6 7 2

This took three replacements at a cost of

5 3 4 = 12
1 5 8 = 14
6 4 2 = 12
5 1 6 = 12
3 5 4 = 12
4 8 2 = 14
5 5 2 = 12
4 5 6 = 15

1. Migrate data structure to 8x4 array with 3 inputs and 1 sum
2. remove majority of the same numbers
3. pick the lowest number in the array of
	 */
	static int formingMagicSquare(int[][] s) {

		ArrayList newList = new ArrayList();

		List inputs = Arrays.asList(s);
		inputs.stream().forEach(a->{
			System.out.println(((int[])a).length);
		});
		int[] newArray1 = {s[0][0],s[0][1],s[0][2],s[0][0]+s[0][1]+s[0][2]};
		int[] newArray2 = {s[1][0],s[1][1],s[1][2],s[1][0]+s[1][1]+s[1][2]};
		int[] newArray3 = {s[2][0],s[2][1],s[2][2],s[2][0]+s[2][1]+s[2][2]};
		int[] newArray4 = {s[0][0],s[1][0],s[2][0],s[0][0]+s[1][0]+s[2][0]};
		int[] newArray5 = {s[0][1],s[1][1],s[2][1],s[0][1]+s[1][1]+s[2][1]};
		int[] newArray6 = {s[0][2],s[1][2],s[2][2],s[0][2]+s[1][2]+s[2][2]};
		int[] newArray7 = {s[0][0],s[1][1],s[2][2],s[0][0]+s[1][1]+s[2][2]};
		int[] newArray8 = {s[0][2],s[1][1],s[2][0],s[0][2]+s[1][1]+s[2][0]};
		newList.add(newArray1);
		newList.add(newArray2);
		newList.add(newArray3);
		newList.add(newArray4);
		newList.add(newArray5);
		newList.add(newArray6);
		newList.add(newArray7);
		newList.add(newArray8);


//		newList.stream().map(a->((int[])a)[3]).distinct().forEach(System.out::println);

		int[] possibleTargetNums = newList.stream().mapToInt(a->((int[])a)[3]).distinct().toArray();
		List<Integer> possibleTargetNumsList = Arrays.stream(possibleTargetNums)        // IntStream
												   .boxed()          // Stream<Integer>
												   .collect(Collectors.toList());
		ArrayList al = new ArrayList();
		HashMap<Integer,Integer> countMapping = new HashMap();
		long count1=0;
		long count2=0;
		int targetNum = 0;

		for(Integer eachNum:possibleTargetNumsList){
			count1 = newList.stream().filter(a->((int[])a)[3]==eachNum).count();

			countMapping.put(eachNum,(int)count1);

			if(count1>count2){
				count2=count1;
				targetNum=eachNum;
			}
		}
		System.out.println(targetNum+ " Highest count: "+count2);

//		al.stream().forEach(System.out::println);
		final int temp = targetNum;
		List<Integer> numsForCost = possibleTargetNumsList.stream().filter(a->a!=temp).collect(toList());

		int cost = 0;
		for(Integer i:numsForCost){
			int count = countMapping.get(i);
			System.out.println("Math.abs(targetNum-i): "+Math.abs(targetNum-i)+ " "+"count: "+count);
			cost = cost + (Math.abs(targetNum-i)*count);
		}
		System.out.println("cost: "+cost);
		System.out.println("---------------");
		newList.stream().forEach(a->{
			int[] ar = (int[])a;
			for(int i=0;i<ar.length;i++){
				System.out.print(ar[i]+" ");
			}
			System.out.println("");
		});
		return 0;

	}

	public static List<Integer> gradingStudents(List<Integer> grades) {
		ArrayList resultList = new ArrayList();

		grades.stream().forEach(i->{
			int diff = 5-i%5;
			if(i>37 && diff<3){
				resultList.add(i+diff);
			}else{
				resultList.add(i);
			}
		});

		return resultList;

	}

	static int[] breakingRecords(int[] scores) {

		int maxScore=scores[0],minScore=scores[0],maxCount=0,minCount=0 ;

		for(int i:scores){

			if(i>maxScore){
				maxCount++;
				maxScore=i;
			}else if(i<minScore){
				minCount++;
				minScore=i;
			}

		}
		int[] results = {maxCount,minCount};

 		return results;
	}

/*You are choreographing a circus show with various animals. For one act, you are given two kangaroos on a number line ready to jump in the positive direction (i.e, toward positive infinity).

    The first kangaroo starts at location

and moves at a rate of
meters per jump.
The second kangaroo starts at location
and moves at a rate of

    meters per jump.

You have to figure out a way to get both kangaroos at the same location at the same time as part of the show. If it is possible, return YES, otherwise return NO.

For example, kangaroo
starts at with a jump distance and kangaroo starts at with a jump distance of . After one jump, they are both at , (,

), so our answer is YES.

Function Description

Complete the function kangaroo in the editor below. It should return YES if they reach the same position at the same time, or NO if they don't.

kangaroo has the following parameter(s):

    x1, v1: integers, starting position and jump distance for kangaroo 1
    x2, v2: integers, starting position and jump distance for kangaroo 2

Input Format

A single line of four space-separated integers denoting the respective values of
, , , and

.

Constraints

Output Format

Print YES if they can land on the same location at the same time; otherwise, print NO.

Note: The two kangaroos must land at the same location after making the same number of jumps.

Sample Input 0

0 3 4 2

Sample Output 0

YES



 */
	static String kangaroo(int x1, int v1, int x2, int v2) {
		/*
			y1=x1+v1
			y2=y1+v1
			y3=y2+v1
			...
			yn=yn-1+v1

			z1=x2+v2
			z2=z1+v2
			z3=z2+v3
			....
			zn=zn-1+v2

			y0=(0+3)=3
			y1=(0+3)*1=3
			y2=(0+3)*2=6
			y3=(0+3)*3=9
			y4=(0+3)*4=12
			y6=(0+3)*5=15
			y7=(0+3)*6=18

			yn=(x1+v1)*n

			z0=4
			z1=4+2=6
			z2=6+2=8
			z3=8+2=10
			z4=10+2=12
			z5=(4+2)*4=24

			3,6,9,12,....
			4,6

		 */
		int y = 0, z=0, yprev=x1, zprev=x2;
		String result = "NO";
		for(int i=1;i<10001;i++){
			y=yprev+v1;
			z=zprev+v2;
			if(y==z){
				result = "YES";
				break;
			}else{
				yprev=y;
				zprev=z;
			}
		}
		return result;
	}

	/*
	 * Complete the 'getTotalX' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER_ARRAY a
	 *  2. INTEGER_ARRAY b
	 * There will be two arrays of integers. Determine all integers that satisfy the following two conditions:

    The elements of the first array are all factors of the integer being considered
    The integer being considered is a factor of all elements of the second array

These numbers are referred to as being between the two arrays. Determine how many such numbers exist.

Example

There are two numbers between the arrays: and .
, , and for the first value.
, and , for the second value. Return

.

Function Description

Complete the getTotalX function in the editor below. It should return the number of integers that are betwen the sets.

getTotalX has the following parameter(s):

    int a[n]: an array of integers
    int b[m]: an array of integers

	 */

	public static int getTotalX(List<Integer> a, List<Integer> b) {

		HashMap<Integer,Integer> factorsOfSecondArray = new HashMap<>();

		b.stream().forEach(i ->{
			for(int j=1;j<i+1;j++) {
//				System.out.println(i+"%"+j+"="+i%j);
				if (i % j == 0) {
					if(factorsOfSecondArray.get(j)==null) {
						factorsOfSecondArray.put(j, 1);
					}else{
						factorsOfSecondArray.put(j, factorsOfSecondArray.get(j)+1);
					}
				}
			}
		} );

//	factorsOfSecondArray.keySet().stream().forEach(i->{
//		System.out.println(i+" -> "+factorsOfSecondArray.get(i));
//	});

	//factorsOfSecondArray.keySet().stream().filter(integer -> factorsOfSecondArray.get(integer)==b.size()).forEach(System.out::println);
	List<Integer> integersBeingConsidered = factorsOfSecondArray.keySet().stream().filter(integer -> factorsOfSecondArray.get(integer)==b.size()).collect(toList());

//	integersBeingConsidered.stream().forEach(System.out::println);

	HashMap<Integer,Integer> finalIntegersWithCounts = new HashMap<>();
		a.stream().forEach(i ->{
			for(Integer j:integersBeingConsidered) {
//				System.out.println(j+"%"+i+"="+j%i);
				if (j % i == 0) {
					if(finalIntegersWithCounts.get(j)==null){
						finalIntegersWithCounts.put(j,1);
					}else{
						finalIntegersWithCounts.put(j,finalIntegersWithCounts.get(j)+1);
					}
				}
			}
		} );

//		System.out.println("--------");
//		finalIntegersWithCounts.keySet().stream().forEach(i->{
//			System.out.println(i+" -> "+finalIntegersWithCounts.get(i));
//		});

		List<Integer>  finalIntegers = finalIntegersWithCounts.keySet().stream().filter(integer -> finalIntegersWithCounts.get(integer)==a.size()).collect(toList());

		return finalIntegers.size();
	}

	/*
	Given an array of integers and a positive integer , determine the number of pairs where and + is divisible by

.

Example


Three pairs meet the criteria: and .
Function Description

Complete the divisibleSumPairs function in the editor below.

divisibleSumPairs has the following parameter(s):

    int n: the length of array

    int ar[n]: an array of integers
    int k: the integer divisor

Returns
- int: the number of pairs
	 */
	static int divisibleSumPairs(int n, int k, int[] ar) {
		int count=0;

		for(int i=0;i<ar.length;i++){
			for(int j=i+1;j<ar.length;j++) {
				if ((ar[i] + ar[j]) % k == 0){
					count++;
				}
			}
		}

		return count;
	}

	/*
	Given an array of bird sightings where every element represents a bird type id, determine the id of the most frequently sighted type. If more than 1 type has been spotted that maximum amount, return the smallest of their ids.

Example
There are two each of types and , and one sighting of type . Pick the lower of the two types seen twice: type

.

Function Description

Complete the migratoryBirds function in the editor below.

migratoryBirds has the following parameter(s):

    int arr[n]: the types of birds sighted

Returns

    int: the lowest type id of the most frequently sighted birds

	 */
	static int migratoryBirds(List<Integer> arr) {

		HashMap<Integer,Integer> countMapping = new HashMap<>();
		arr.stream().forEach(integer -> {
			if(countMapping.get(integer)==null){
				countMapping.put(integer,1);
			}else{
				countMapping.put(integer,countMapping.get(integer)+1);
			}
		});

		Optional<Integer> max = countMapping.keySet().stream().map(countMapping::get).collect(toList()).stream().reduce(Integer::max);
		System.out.println("max: "+max.get());
		List<Integer> maxNumbers = countMapping.keySet().stream().filter(i-> countMapping.get(i).equals(max.get())).collect(toList());
		maxNumbers.stream().forEach(System.out::println);
		Optional<Integer> finalAnswer = maxNumbers.stream().reduce(Integer::min);

		return finalAnswer.get();
	}

	static void bonAppetit(List<Integer> bill, int k, int b) {
		bill.remove(k);
		double amt = (double)bill.stream().reduce(Integer::sum).get();
		double d = b - amt/2;
		if(amt%2==0) {
			System.out.println(d == 0 ? "Bon Appetit" : (int)d);
		}else{
			System.out.println(d == 0 ? "Bon Appetit" : d);
		}
	}

	static int hurdleRace(int k, int[] height) {
		Optional<Integer> maxHeight = Arrays.stream(height).boxed().collect(Collectors.toList()).stream().reduce(Integer::max);
		return k>=maxHeight.get()?0:maxHeight.get()-k;
	}


	static String catAndMouse(int x, int y, int z) {
		int a = Math.abs(x-z);
		int b = Math.abs(y-z);

		if(a>b){
			return "Cat B";
		}else if (a<b){
			return "Cat A";
		}else {
			return "Mouse C";
		}

	}


	static int designerPdfViewer(int[] h, String word) {
		String[] letters={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		HashMap <String,Integer> letterMap = new HashMap<>();
		for(int i=0;i<letters.length;i++){
			letterMap.put(letters[i],h[i]);
		}
		String[] s = word.split("");
		Integer maxHeight = Arrays.stream(s).map(each_s->letterMap.get(each_s)).reduce(Integer::max).get();

		return word.length()*maxHeight;

	}

	/*
	Given two arrays of integers, find which elements in the second array are missing from the first array.

Example

The array is the orginal list. The numbers missing are

.

Notes

    If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both lists is the same. If that is not the case, then it is also a missing number.
    Return the missing numbers sorted ascending.
    Only include a missing number once, even if it is missing multiple times.
    The difference between the maximum and minimum numbers in the original list is less than or equal to

    .

Function Description

Complete the missingNumbers function in the editor below. It should return a sorted array of missing numbers.

missingNumbers has the following parameter(s):

    int arr[n]: the array with missing numbers
    int brr[m]: the original array of numbers

Returns

    int[]: an array of integers

	 */

	static int[] missingNumbers(int[] arr, int[] brr) {

		List<Integer> arrSortedList = Arrays.stream(arr).boxed().sorted().collect(toList());;
		HashMap<Integer,Integer> brrCounts = new HashMap<>();

		for(int i:brr){
			if(brrCounts.get(i)==null){
				brrCounts.put(i,1);
			}else{
				brrCounts.put(i,brrCounts.get(i)+1);
			}
		}

		arrSortedList.stream().forEach(integer -> brrCounts.put(integer,brrCounts.get(integer)-1));

		brrCounts.keySet().stream().forEach(s->System.out.println(s+" -> "+brrCounts.get(s)));

		List<Integer> results = brrCounts.keySet().stream().filter(integer -> brrCounts.get(integer)>0).collect(toList());

		results.stream().forEach(System.out::println);

		return results.stream().mapToInt(i->i).toArray();

	}

	static String balancedSums2(List<Integer> arr) {

		int leftSum=0;
		int sum=arr.stream().reduce(Integer::sum).get();
		boolean found = false;
		int newNum;
		for(int i = 0;i<arr.size();i++) {
			newNum = arr.get(i);
			if((sum-newNum)%2==0){
				found=true;
			}
		}
		return found==true?"YES":"NO";
	}

	static String balancedSums_orig(List<Integer> arr) {
		int startingPoint=arr.size()/2;

		int leftSum=0;
		int rightSum=0;
		boolean found = false;

		List<Integer> leftList;
		List<Integer> rightList;

		for(int pivotPoint = startingPoint;pivotPoint<arr.size();pivotPoint++) {
			leftList = arr.subList(0,pivotPoint);
			rightList = arr.subList(pivotPoint+1,arr.size());

			leftSum = leftList.size()==0?0:leftList.stream().reduce(Integer::sum).get();
			rightSum = rightList.size()==0?0:rightList.stream().reduce(Integer::sum).get();

			if (leftSum == rightSum) {
				System.out.println(arr.get(pivotPoint));
				System.out.println("YES");
				found=true;
				break;
			}
		}

		if(!found) {
			for (int pivotPoint = startingPoint; pivotPoint >= 0; pivotPoint--) {
				leftList = arr.subList(0, pivotPoint);
				rightList = arr.subList(pivotPoint + 1, arr.size());

				leftSum = leftList.size() == 0 ? 0 : leftList.stream().reduce(Integer::sum).get();
				rightSum = rightList.size() == 0 ? 0 : rightList.stream().reduce(Integer::sum).get();

				if (leftSum == rightSum) {
					System.out.println(arr.get(pivotPoint));
					System.out.println("YES");
					found = true;
					break;
				}
			}
		}

		return found==true?"YES":"NO";

	}

	static String balancedSums(List<Integer> arr) {

		List<Integer> rightList=arr.subList(0,arr.size());

		int leftSum=0;
		int rightSum=rightList.stream().reduce(Integer::sum).get();

		boolean found = false;
		int pivotNum;

		for(int pivotPoint = 0;pivotPoint<arr.size();pivotPoint++) {
			if (leftSum == rightSum) {
				System.out.println(arr.get(pivotPoint));
				System.out.println("YES");
				found=true;
				break;
			}
			pivotNum = arr.get(pivotPoint);
			if(pivotPoint!=0) {
				leftSum = leftSum + arr.get(pivotPoint - 1);
			}
			rightSum = rightSum-pivotNum;

		}

		if (!found&&(leftSum == rightSum)) {
			found=true;
		}

		return found==true?"YES":"NO";

	}

	// 5 peoplr rec -> 5/2=2 -> 2 * 3 =6 day1
	// 6 peop rec -> 6/2 =3 -> 3 * 3 =9 day2
	// 9 prop rec -> 9/2=4 -> 4*3=12 day3

	static int viralAdvertising(int n) {

		int numOfPeopleLiked = 0;
		int numOfSahred =5;
		int cumulative = 0;
		for(int i=0;i<n;i++){
			numOfSahred = i==0?5:3 * numOfPeopleLiked;
			numOfPeopleLiked = numOfSahred / 2;
			cumulative = cumulative + numOfPeopleLiked;
		}
		return cumulative;
	}


	static int camelcase(String s) {
		int count=0;
		for(int i=0;i<s.length();i++){
			int j=s.charAt(i);
			if((j>=65)&&(j<=90)){
				count++;
			}
		}
		return count+1;
	}

	static int makingAnagrams1(String s1, String s2) {
		HashMap<String,Integer> letterMapping = new HashMap<>();

		for(String each:s1.split("")){
			letterMapping.merge(each,1,(oldValue, newValue) -> oldValue + 1);
		}

		for(String each:s2.split("")){
			letterMapping.merge(each,1,(oldValue, newValue) -> oldValue + 1);
		}
		//ccvvffff
		//cvff
		List<String> keyList =letterMapping.keySet().stream().collect(toList());
//		for(String key:keyList){
//			letterMapping.
//		}
//		letterMapping.keySet().stream().forEach(k->System.out.println(k+"->"+letterMapping.get(k)));

		return 0;
	}


	static int makingAnagrams(String s1,String s2){
		HashMap<String,Integer> letterMapping = new HashMap<>();
		HashMap<String,Integer> letterMapping2 = new HashMap<>();
		String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		/*
		initialize the latter-count map by counting letters from each input.
		 */
		for(String each:s1.split("")){
			letterMapping.merge(each,1,(oldValue, newValue) -> oldValue + 1);
		}

		for(String each:s2.split("")){
			letterMapping2.merge(each,1,(oldValue, newValue) -> oldValue + 1);
		}

		//		Arrays.stream(letters).forEach(key->System.out.println(key+" -> "+letterMapping.get(key)+" - "+letterMapping2.get(key)+" = "+(Math.abs(letterMapping.get(key)-letterMapping2.get(key)))));

		/*
			Since this is to find the minimum number of character deletions, simply subtract and find difference between input 1 and input 2.
			if you remove a number of letters same as difference, it will make 2 inputs same after the deletion.
		 */
		int r = Arrays.stream(letters).map(key->Math.abs((letterMapping.get(key)!=null?letterMapping.get(key):0)-(letterMapping2.get(key)!=null?letterMapping2.get(key):0))).reduce(Integer::sum).get();
		return r;
	}

	/*
	Dothraki are planning an attack to usurp King Robert's throne. King Robert learns of this conspiracy from Raven and plans to lock the single door through which the enemy can enter his kingdom.

door

But, to lock the door he needs a key that is an anagram of a palindrome. He starts to go through his box of strings, checking to see if they can be rearranged into a palindrome. Given a string, determine if it can be rearranged into a palindrome. Return the string YES or NO.

Example
One way this can be arranged into a palindrome is

. Return YES.

Function Description
Complete the gameOfThrones function below.

gameOfThrones has the following parameter(s):

    string s: a string to analyze

Returns

    string: either YES or NO

	 */
	static String gameOfThrones(String s) {
		HashMap<String,Integer> letterMapping = new HashMap<>();
		for(String each:s.split("")){
			letterMapping.merge(each,1,(oldValue, newValue) -> oldValue + 1);
		}

		List<String> list = letterMapping.keySet().stream().filter(k->letterMapping.get(k)%2!=0).collect(toList());

		if(list.size()==0 || list.size()==1){
			return "YES";
		}else if(list.size()>1){
			return "NO";
		}

		return "NO";
	}

	static int stringConstruction(String s) {
		String[] s_array = s.split("");

		System.out.println(s.substring(0,1));
		System.out.println(s.substring(1,2));
		System.out.println(s.substring(2,3));
		System.out.println(s.substring(0,2));
		System.out.println(s.substring(1,3));
		System.out.println(s.substring(0,3));


		return 0;
	}

	static void ifelse(int n){
		/*
		If n is odd, print Weird
		If n is even and in the inclusive range of 2 to 5, print Not Weird
		If n is even and in the inclusive range of 6 to 20, print Weird
		If n is even and greater than 20, print Not Weird
		 */

		if (n%2!=0){
			System.out.println("Weird");
		}else if ((n%2==0) && (n>=2 && n <=5)){
			System.out.println("Not Weird");
		}else if((n%2==0) &&(n>=6 && n<=20)){
			System.out.println("Weird");
		}else if(n%2==0 && n>20){
			System.out.println("Not Weird");
		}
	}

	/*
	Its length is at least 6
	It contains at least one digit.
	It contains at least one lowercase English character.
	It contains at least one uppercase English character.
	It contains at least one special character. The special characters are: !@#$%^&*()-+
	 */
	static int minimumNumber(int n, String password) {
		Optional<String> numFound = Arrays.stream(password.split("")).filter(each->each.matches("[0-9]")).findAny();
		Optional<String> lowerFound = Arrays.stream(password.split("")).filter(each->each.matches("[a-z]")).findAny();
		Optional<String> upperFound = Arrays.stream(password.split("")).filter(each->each.matches("[A-Z]")).findAny();
		Optional<String> specialFound = Arrays.stream(password.split("")).filter(each->each.matches("[!@#$%^&*()+-]")).findAny();
		int missingReqCount=0;

		if(!numFound.isPresent()){
			missingReqCount++;
		}
		if(!lowerFound.isPresent()){
			missingReqCount++;
		}
		if(!upperFound.isPresent()){
			missingReqCount++;
		}
		if(!specialFound.isPresent()){
			missingReqCount++;
		}

		if((6-password.length()) > missingReqCount){
			return 6-password.length();
		}else{
			return missingReqCount;
		}

	}

	static int squares(int a, int b) {
		int begNum = (int) Math.ceil(Math.sqrt(a));
		int endNum = (int) Math.ceil(Math.sqrt(b));

		if (begNum * begNum < a) {
			begNum = begNum + 1;
		}
		if (endNum * endNum > b) {
			endNum = endNum - 1;
		}
		return (endNum == begNum)&&((begNum*begNum)>=a && (begNum*begNum)<=b) ? 1 : endNum - begNum + 1;
	}

	static int squares1(int a, int b) {
		int[][] arr = {{11,734},
		{228,919},
		{71,188},
		{270,303},
		{312,701},
		{251,325},
		{418,954},
		{407,597},
		{4,4},
		{248,583},
		{318,936},
		{176,769},
		{323,838},
		{383,981},
		{152,560},
		{94,217},
		{232,442},
		{180,447},
		{384,819},
		{175,842},
		{81,451},
		{381,771},
		{260,669},
		{95,558},
		{111,926},
		{212,676},
		{368,424},
		{153,373},
		{127,305}};
		int[] answer = {24,
				15,
				5,
				1,
				9,
				3,
				10,
				4,
				1,
				9,
				13,
				14,
				11,
				12,
				11,
				5,
				6,
				8,
				9,
				16,
				13,
				8,
				9,
				14,
				20,
				12,
				1,
				7,
				6};

		for(int i=0;i<arr.length;i++) {
//			int begNum = (int) Math.ceil(Math.sqrt(a));
//			int endNum = (int) Math.ceil(Math.sqrt(b));

			int begNum = (int) Math.ceil(Math.sqrt(arr[i][0]));
			int endNum = (int) Math.ceil(Math.sqrt(arr[i][1]));
			if (begNum * begNum < a) {
				begNum = begNum + 1;
			}
			if (endNum * endNum > b) {
				endNum = endNum - 1;
			}
			int finalAnswer = (endNum == begNum)&&((begNum*begNum)>=a && (begNum*begNum)<=b) ? 1 : endNum - begNum + 1;
			if(finalAnswer!=answer[i]){
				System.out.println(arr[i][0]+" "+arr[i][1]+" should be "+answer[i]+" but "+finalAnswer );
			}
		}
		return 0;
	}

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	static void runLinkedList(){
		SinglyLinkedList list = new SinglyLinkedList();
//		SinglyLinkedListNode node1 = new SinglyLinkedListNode(16);
//		SinglyLinkedListNode node2 = new SinglyLinkedListNode(13);

		list.insertNode(16);
		list.insertNode(13);
		list.insertNode(17);
		list.insertNode(14);
		list.insertNode(15);
		list.insertNode(16);

		printLinkedList(list.head);
	}

	static void printLinkedList(SinglyLinkedListNode head) {
		System.out.println(head.data);
		SinglyLinkedListNode node = head.next;
		while(node!=null) {
			System.out.println(node.data);
			node = node.next;
		}
	}

	static SinglyLinkedListNode buildLinkedList(int[] arr){
		SinglyLinkedList llist = new SinglyLinkedList();
		for (int i = 0; i < arr.length; i++) {
			llist.insertNode(arr[i]);
		}

		return llist.head;
	}
	static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {

		SinglyLinkedListNode currentNode = head;
		SinglyLinkedListNode prevNode = null;
		int count=0;
		while(currentNode.next!=null){
			SinglyLinkedListNode nextNode = currentNode.next;
			if(count==position){
				if(prevNode!=null) {
					prevNode.next = nextNode;
				}else{
					head = nextNode;
				}
				break;
			}else{
				prevNode = currentNode;
				currentNode = nextNode;
			}
			count++;
		}

		printLinkedList(head);
		return head;
	}

	static void reversePrint(SinglyLinkedListNode head) {

		SinglyLinkedListNode currentNode = head;
		List<Integer> temp = new ArrayList<>();
		while(currentNode.next!=null){
			temp.add(currentNode.data);
			SinglyLinkedListNode nextNode = currentNode.next;
			currentNode=nextNode;
		}

		for(int i=temp.size()-1;i>=0;i--){
			System.out.println(temp.get(i));
		}

	}


	static int powerSum(int X, int N) {

		double max = (double)Math.pow(X,1.0/(double)N);
		System.out.println("max: "+max);
		ArrayList<Double> results = new ArrayList<>();
		ArrayList<Double> elements = new ArrayList<>();
		ArrayList<Double> elements2 = new ArrayList<>();

		for(int i=1;i<=max;i++){

			double d_pow = Math.pow(i,N);
			elements.add(d_pow);
			System.out.println(i+ " "+d_pow);

		}

		//pick a number
		//find diff = TARGET-number
		//collect numbers less than diff
		//loop through numbers
			//sum = sum + nqumber
			//if sum < diff
			//continue add
			//
		int count = 0;
		double sum=0.0;

		elements.stream().forEach(a->elements2.add(a));


		for(int i=elements.size()-1;i>=0;i--){
			double d1 = elements.get(i);
			double difference=0;
//			sum = sum + d1;
			if(sum==X){
				sum=0;
				elements2.remove(i);
				count++;
			}else{

//				difference = X - sum;
				List<Double> s = elements2.stream().filter(a->a<d1).collect(toList());
				for(int j=0;j<s.size();j++){

				}
//				System.out.println("diff: "+diff);
//				double dd = Math.pow(diff,1/(double)N);
//				System.out.println("dd: "+dd);
			}
		}
//		if((Math.pow(max,N)==X)){
//			results.add(max);
//		}else{
//
//		}

//		System.out.println();



//		while(X==0){
//			Math.pow(count,N)
//		}
		return 0;

	}


// static void findDuplicate(int[] a){
//
//		for(int a=0;)
//
// }

	static void javaString(String A, String B){
		int sumLengh = A.length()+B.length();
		System.out.println(sumLengh);
		char[] A_chars = A.toCharArray();
		char[] B_chars = B.toCharArray();

		int equal_counter=0;
		for(int i=0;i<Math.min(A.length(),B.length());i++){
			if(A_chars[i]>B_chars[i]){
				System.out.println("Yes");
				break;
			}else if(A_chars[i]<B_chars[i]){
				System.out.println("No");
				break;
			}else{
				equal_counter++;
			}
		}
		if(equal_counter==Math.min(A.length(),B.length())){
			if(A.length()>B.length()){
				System.out.println("Yes");
			}else if(A.length()<=B.length()){
				System.out.println("No");
			}
		}
		String newA = A.substring(0,1).toUpperCase()+A.substring(1,A.length());
		String newB = B.substring(0,1).toUpperCase()+B.substring(1,B.length());
		System.out.println(newA+" "+newB);
	}

	static void isAnagram(String a, String b){
		HashMap<String,Integer> a_counter_map = new HashMap<>();
		HashMap<String,Integer> b_counter_map = new HashMap<>();

		String[] a_str = a.toLowerCase().split("");
		String[] b_str = b.toLowerCase().split("");

		if(a.length()!=b.length()){
			System.out.println("Not Anagrams");
		}else {
			Arrays.stream(a_str).forEach(each_a -> a_counter_map.merge(each_a, 1, (oldValue, newValue) -> newValue = oldValue + 1));
			Arrays.stream(b_str).forEach(each_b -> b_counter_map.merge(each_b, 1, (oldValue, newValue) -> newValue = oldValue + 1));
			boolean isAnagram=true;
			Object[] key_arr =a_counter_map.keySet().toArray();
			for(Object key:key_arr){
				if(a_counter_map.get(key)!=b_counter_map.get(key)){
					isAnagram = false;
					break;
				}
			}

			System.out.println(isAnagram?"Anagrams":"Not Anagrams");

		}


	}

	static void isAnagram2(String a, String b){

		if(a.length()!=b.length()){
			System.out.println("Not Anagrams");
		}else {
			char[] a_sorted = a.toLowerCase().toCharArray();
			char[] b_sorted = b.toLowerCase().toCharArray();
			java.util.Arrays.sort(a_sorted);
			Arrays.sort(b_sorted);

			if(String.copyValueOf(a_sorted).toString().equals(String.copyValueOf(b_sorted).toString())){
				System.out.println("Anagrams");
			}else{
				System.out.println("Not Anagrams");
			}
		}
	}

	static void getSmallestAndLargest(String s, int k){

		String smallest="";
		String largest="";
		java.util.ArrayList<String> s_arr = new ArrayList<>();
		for(int i=0;i<s.length();i++) {
			if(i+k>s.length()){
				break;
			}
			s_arr.add(s.substring(i,i+k));
		}

		if(s.length()==k){
		  smallest=s;
		  largest=s;
		}else {
			for (int j = 0; j < s_arr.size(); j++) {
				char[] each_c = s_arr.get(j).toCharArray();

				if (smallest.equals("")) {
					smallest = s_arr.get(j);
				} else {
					char[] minS_c = smallest.toCharArray();
					for (int p = 0; p < minS_c.length; p++) {
						if (minS_c[p] < each_c[p]) {
							break;
						} else if (minS_c[p] > each_c[p]) {
							smallest = s_arr.get(j);
							break;
						}
					}
				}

				if (largest.equals("")) {
					largest = s_arr.get(j);
				} else {
					char[] maxS_c = largest.toCharArray();
					for (int p = 0; p < maxS_c.length; p++) {
						if (maxS_c[p] > each_c[p]) {
							break;
						} else if (maxS_c[p] < each_c[p]) {
							largest = s_arr.get(j);
							break;
						}
					}
				}

			}
		}

		System.out.println("smallest: "+smallest+" largest:"+largest);
	}
	static long repeatedString(String s, long n) {
		String ss = s.replaceAll("[a]","");
		long numOfA = 0;
		if(ss.equals("")) {
			numOfA = n;
		}else{
			System.out.println("replaced ss: " + ss);
			String[] s_arr = s.split("");
			long numOfRepeats = n / s.length();
			long afterRepeats = numOfRepeats * s.length();
			long diff = n - afterRepeats;
			numOfA = Arrays.stream(s_arr).filter(each_s -> each_s.equals("a")).count() * numOfRepeats;
			System.out.println("numOfRepeats: " + numOfRepeats);
			System.out.println("afterRepeats: " + afterRepeats);
			System.out.println("numOfA before diff: " + numOfA);
			System.out.println("diff: " + diff);
			for (int i = 0; i < diff; i++) {
				if (s_arr[i].equals("a")) {
					numOfA = numOfA + 1;
				}
			}
		}
		System.out.println("numOfA after diff: "+numOfA);

		return numOfA;
	}

	static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {

		if(y2 < y1){
			return 10000;
		}

		if(y2 == y1 && m2 < m1){
			return (m1-m2) * 500;
		}

		if(y2==y1 && m2==m1 && d2<d1){
			return (d1-d2)*15;
		}
		return 0;
	}

	// Complete the cutTheSticks function below.
	static int[] cutTheSticks(int[] arr) {
        /*
            sort
            pick the shortest
            substract
            count items > 0 and put in a basket
        */
		ArrayList<Long> outputList = new ArrayList();

		for(int i=0;i<arr.length;i++) {
			long nonzeroCount = Arrays.stream(arr).filter(a->a>0).count();
			if(nonzeroCount!=0) {
				outputList.add(nonzeroCount);
				int minNum = Arrays.stream(arr).filter(a -> a > 0).reduce(Integer::min).getAsInt();
				for (int j = 0; j < arr.length; j++) {
					arr[j] = arr[j] - minNum < 0 ? 0 : arr[j] - minNum;
					System.out.print("arr[" + j + "]: " + arr[j] + "-" + minNum + " ");
				}
				System.out.println("");
			}else{
				break;
			}
		}

		int[] finalOutput = new int[outputList.size()];
		int counter=0;
		for(Long each:outputList){
			finalOutput[counter]=each.intValue();
			counter++;
		}
		return finalOutput;
	}

	public static int countingValleys(int steps, String path) {
		// Write your code here
		String[] pathArr = path.split("");
		int stepTracker=0;
		int valleyCounter=0;
		for(String step:pathArr){
			int preValue=stepTracker;
			if(step.equals("U")){
				stepTracker++;
				if(preValue<0&&stepTracker==0){
					valleyCounter++;
				}
			}else if(step.equals("D")){
				stepTracker--;
			}
		}
		return valleyCounter;
	}

	static void patternSyntaxChecker(String s){
		try {
			Pattern p = Pattern.compile(s);
			System.out.println("Valid");
		}catch(PatternSyntaxException pe){
			System.out.println("Invalid");
		}
	}

	static void primalityTest(String s){
		BigInteger bi = new BigInteger(s);
		System.out.println(bi.isProbablePrime(1)?"prime":"not prime");

	}

	static void testBigDecimal(String[] strings){
		for(String s:strings){
			System.out.println(s);
		}
		System.out.println("----------------");
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				BigDecimal o1_bigDecimal = new BigDecimal(o1);
				BigDecimal o2_bigDecimal = new BigDecimal(o2);
				if(o2_bigDecimal.compareTo(o1_bigDecimal)==0){
					return 1;
				}
				return o2_bigDecimal.compareTo(o1_bigDecimal);
			}
		});

		Arrays.stream(strings).forEach(System.out::println);
	}

	static void testBigDecimal2(String[] strings){
		for(String s:strings){
			System.out.println(s);
		}
		System.out.println("----------------");
		ArrayList<BigDecimal> bigDecimalArrayList = new ArrayList<>();
		ArrayList<BigDecimal> sortedList =new ArrayList<>();
		Arrays.stream(strings).forEach(s->bigDecimalArrayList.add(new BigDecimal(s)));

		bigDecimalArrayList.stream().sorted().forEach(bd->sortedList.add(bd));
		Collections.reverse(sortedList);

		for(int i=0;i<strings.length;i++){
			strings[i]=sortedList.get(i).toString();
		}

		for(String s:strings){
			System.out.println(s);
		}
	}

	static void testBigInteger(String a, String b){
		BigInteger big_a = new BigInteger(a);
		BigInteger big_b = new BigInteger(b);

		BigInteger mulAns = big_a.multiply(big_b);
		BigInteger addAns = big_a.add(big_b);

		System.out.println(mulAns.toString());
		System.out.println(addAns.toString());

		System.out.println(big_a instanceof BigInteger ? ((BigInteger) big_a) : null);
	}

	static void javaStringToken(String ss){

		System.out.println(ss.length());

//		String ss1="apple";
//		StringTokenizer st = new StringTokenizer(ss);
//		String s_arr=ss.replace("[A-Za-z !,?._'@]+","a");
//		System.out.println(ss1.matches("apple")?"matched":"unmatched");
//		System.out.println(s_arr);
//		String s_arr2=ss.replaceAll("[A-Za-z!]","a");
//		System.out.println(s_arr2);

		ss =ss.trim();

		if(ss.length()>0 && ss.length()<=40000) {
//			System.out.println("--->" + ss);
//
//			System.out.println("--->" + ss);

			String[] newArr = ss.split("[, '?_@!.\\s\\w]+");
			System.out.println(newArr[0]);
			System.out.println(newArr.length);
			Arrays.stream(newArr).filter(each -> !each.equals(" ")).collect(Collectors.toList()).stream().forEach(System.out::println);

		}

	}

	//Java Regex for IP validation
	static void pattern(String s,String pattern){

		System.out.println(s.matches(pattern));

	}

	static int java2dArray(int[][] inputArr){

		int maxSum = 0;
		for(int i=0;i<inputArr.length-2;i++) {

			for(int j=0;j<inputArr[i].length-2;j++) {
				int topLeft = inputArr[i][j];
				int topMiddle =inputArr[i][j+1];
				int topRight = inputArr[i][j+2];

				int secRowMiddle=inputArr[i+1][j+1];

				int leftBottom=inputArr[i+2][j];
				int midlleBottom=inputArr[i+2][j+1];
				int rightBottom=inputArr[i+2][j+2];
				int sum = topLeft+topMiddle+topRight+secRowMiddle+leftBottom+midlleBottom+rightBottom;
				if((i==0&&j==0)||(maxSum<sum)){
					maxSum = sum;
				}
			}

		}
		return maxSum;

	}

	//JAVA 1D Array Part 2
	static boolean canWin(int leap, int[] game){





		//leap = 3,  length=5, 0 0 0 0 0
		//0 ,1 ,2 ,3 ,4 ,5

		//leap = 5,  length=6, 0 0 0 1 1 1
		//0, 1, 2
		//5+2 = 7

		//leap = 3,  length=6, 0 0 1 1 1 0
		//0,1,6

		//leap=4  length=11, 0, 1, 1, 1, 0, 1 ,1, 1, 0, 1, 0
		//0,4,8,10

		//Collect index of zero values
		//loop through the the zeor index list
		//if the gap between each indices of each zero == leap
		//then check if the index + leap can be > game.length
		//if not, then check the gap is 1 then go to next index of zero

//		for(int i=1;i<zeroIndexList.size();i++) {
//		int i=1;
//		while(i<zeroIndexList.size()-1){
//			if (zeroIndexList.get(i) - zeroIndexList.get(i - 1) == leap) {
//				if(leap+zeroIndexList.get(i) >= game.length-1){
//					return true;
//				}
//			} else {
//				if(zeroIndexList.get(i) - zeroIndexList.get(i - 1) == 1) {
//					i++;
//				}else{
//					return false;
//				}
//			}
//		}
		//all zeros
		//leapable -> zeros located in index % leap ==0
		//last 0 must be index located where +1 or +leap >= game.length
			// game.length-leap

		//0,1,1,1,1,0,1,1,1,0,1
		//0,1,1,1,0,0,1,1,1,0,1
		//0,0,0,0,0 leap=3
        //find index of 1st zero from the last
		//and see if the index can be rechable
		//1. last index - leap should be 0

		ArrayList<Integer> zeroIndexList = new ArrayList<>();
		for(int i=0;i<game.length;i++){
			if(game[i]==0) {
				zeroIndexList.add(i);
			}
		}

 		int i=0;

		while(i<=game.length-1) {
			if (game[i] == 0) {
				if (i + 1 > game.length - 1 || i + leap > game.length - 1) {
						return true;
				} else {
					game[i]=1;
					if (game[i+leap] == 0) {
						i = i + leap;
					}else if(game[i+1] == 0){
						i++;
					}else if(i>0&&game[i-1]==0) {
						i--;
					}else {
							return false;
					}
				}
			} else if (game[i] == 1) {
				return false;
			}
		}
		return false;
	}



	public static boolean canWin2(int leap, int[] game) {
		class ZeroNode{
			public int myIndex;
			public boolean visited;
		}

		ArrayList<Integer> zeroIndexList = new ArrayList<>();
		HashMap<Integer,ZeroNode> zeroIndexMap = new HashMap<>();
		for(int i=0;i<game.length;i++){
			if(game[i]==0) {
				ZeroNode zeroNode = new ZeroNode();
				zeroNode.myIndex=i;
				zeroIndexMap.put(i,zeroNode);
			}
		}

		int i=0;

		while(i<=game.length-1) {
			if (game[i] == 0) {
				if (i + 1 > game.length - 1 || i + leap > game.length - 1) {
					return true;
				} else {
//					game[i]=1;
					zeroIndexMap.get(i).visited=true;
					if (game[i+leap] == 0) {
						i = i + leap;
					}else if(game[i+1] == 0){
						i++;
					}else if(i>0&&game[i-1]==0) {
						i--;
					}else {
						return false;
					}
				}
			} else if (game[i] == 1) {
				return false;
			}
		}
		return false;
	}

	//Java Subarray
	static void findNegativeSums(int[] nums){

		/*0
		//01
		//02
		...
0,0	    0
0,1		0,1
0,2		0,1,2
0,3		0,1,2,3
		0,1,2,3,4

1,1		1,1
1,2		1,2,
1,3		1,2,3
1,4		1,2,3,4
		1,4
		....
		2,0
		2,1
		*/
		int count = 0;
			for(int i=0;i<nums.length;i++){

				for(int j=i;j<nums.length;j++){
					int size = j-i+1;
					int[] sub = new int[size];
					System.arraycopy(nums,i,sub,0,size);
					int sum = Arrays.stream(sub).sum();
					if(sum<0){
						count++;
					}
					Arrays.stream(sub).forEach(a->System.out.print(a+","));
					System.out.println("");
				}

			}
			System.out.println("count: "+count);

	}
}










































