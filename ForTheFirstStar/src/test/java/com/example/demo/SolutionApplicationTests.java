package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static java.util.stream.Collectors.toList;
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
		List<Integer> arr = Arrays.stream(i).boxed().collect(toList());
        int final1 = SolutionApplication.migratoryBirds(arr);
		assertTrue(final1==4);
		int[] i2 = {1, 4, 4, 4, 5, 5, 5, 3};
		List<Integer> arr2 = Arrays.stream(i2).boxed().collect(toList());
		int final2 = SolutionApplication.migratoryBirds(arr2);
		assertTrue(final2==4);

		int[] i3 = {1, 2,2,2, 4, 4, 4, 5, 5, 5, 3};
		List<Integer> arr3 = Arrays.stream(i3).boxed().collect(toList());
		int final3 = SolutionApplication.migratoryBirds(arr3);
		assertTrue(final3==2);

		int[] i4 = {1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4};
		List<Integer> arr4 = Arrays.stream(i4).boxed().collect(toList());
		int final4 = SolutionApplication.migratoryBirds(arr4);
		assertTrue(final4==3);

		int[] i5 = {1, 0};
		List<Integer> arr5 = Arrays.stream(i5).boxed().collect(toList());
		int final5 = SolutionApplication.migratoryBirds(arr5);
		assertTrue(final5==0);

		int[] i6 = {1, 1,1,1,1,1,1};
		List<Integer> arr6 = Arrays.stream(i6).boxed().collect(toList());
		int final6 = SolutionApplication.migratoryBirds(arr6);
		assertTrue(final6==1);


	}

	@Test
	void testBonAppetit(){
		int[] arr = {3, 10, 2, 9};
		List<Integer> inputList = Arrays.stream(arr).boxed().collect(toList());
		SolutionApplication.bonAppetit(inputList,1,12);

		int[] arr2 = {3, 10, 2, 9};
		List<Integer> inputList2 = Arrays.stream(arr2).boxed().collect(toList());
		SolutionApplication.bonAppetit(inputList2,1,7);

		int[] arr3 = {3, 10, 2, 10};
		List<Integer> inputList3 = Arrays.stream(arr3).boxed().collect(toList());
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
		List<Integer> inputs = Arrays.stream(arr).boxed().collect(toList());
		result = SolutionApplication.balancedSums(inputs);
		assertTrue(result.equals("YES"));

		arr = new int[]{5,6,8,11};
		inputs = Arrays.stream(arr).boxed().collect(toList());
		result = SolutionApplication.balancedSums(inputs);
		assertTrue(result.equals("YES"));

		arr = new int[]{1,2,3,5,6};
		inputs = Arrays.stream(arr).boxed().collect(toList());
		result = SolutionApplication.balancedSums(inputs);
		assertTrue(result.equals("YES"));

		arr = new int[]{2,0,0,0};
		inputs = Arrays.stream(arr).boxed().collect(toList());
		result = SolutionApplication.balancedSums(inputs);
		assertTrue(result.equals("YES"));

		arr = new int[]{0,0,2,0};
		inputs = Arrays.stream(arr).boxed().collect(toList());
		result = SolutionApplication.balancedSums(inputs);
		assertTrue(result.equals("YES"));

		arr = new int[]{1,2,3};
		inputs = Arrays.stream(arr).boxed().collect(toList());
		result = SolutionApplication.balancedSums(inputs);
		assertTrue(result.equals("NO"));

		arr = new int[]{1,2,3,3};
		inputs = Arrays.stream(arr).boxed().collect(toList());
		result = SolutionApplication.balancedSums(inputs);
		assertTrue(result.equals("YES"));

		arr = new int[]{1,2,3,3,2,3,4,6,1,4};
		inputs = Arrays.stream(arr).boxed().collect(toList());
		result = SolutionApplication.balancedSums(inputs);
		assertTrue(result.equals("NO"));

		arr = new int[]{0,0,0,2};
		inputs = Arrays.stream(arr).boxed().collect(toList());
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
		List<Double>e0 = elements.keySet().stream().filter(a->a==X).collect(toList());
		System.out.println("-------------");
		e0.stream().forEach(System.out::println);
		e0.stream().forEach(elements::remove);
		elements.keySet().stream().forEach(a->System.out.println(a+ " "+elements.get(a)));
		System.out.println("-------------");

		List<Double> e1 = elements.keySet().stream().filter(a->elements.get(elements.get(a))!=null).collect(toList());
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

	@Test
	void testIsAnagrams(){
		SolutionApplication.isAnagram2("anagramm","marganaa");
		SolutionApplication.isAnagram2("Hello","hello");
		SolutionApplication.isAnagram2("java","java");
	}

	@Test
	void testGetSmallestAndLargest(){
		SolutionApplication.getSmallestAndLargest("welcometojava",3);
		SolutionApplication.getSmallestAndLargest("ASDFHDSFHsdlfhsdlfLDFHSDLFHsdlfhsdlhkfsdlfLHDFLSDKFHsdfhsdlkfhsdlfhsLFDLSFHSDLFHsdkfhsdkfhsdkfhsdfhsdfjeaDFHSDLFHDFlajfsdlfhsdlfhDSLFHSDLFHdlfhs",144);
		SolutionApplication.getSmallestAndLargest("ASDFHDSFHsdlfhsdlfLDFHSDLFHsdlfhsdlhkfsdlfLHDFLSDKFHsdfhsdlkfhsdlfhsLFDLSFHSDLFHsdkfhsdkfhsdkfhsdfhsdfjeaDFHSDLFHDFlajfsdlfhsdlfhDSLFHSDLFHdlfhs",30);
		String s ="qwert";
		int a = 5/2;
		System.out.println(a);
	}

	@Test
	void testRepeatedString(){
		SolutionApplication.repeatedString("abc",10);
		SolutionApplication.repeatedString("abcac",10);
		SolutionApplication.repeatedString("a",100000000);
		long a = 685118368975L;

		SolutionApplication.repeatedString("ojowrdcpavatfacuunxycyrmpbkvaxyrsgquwehhurnicgicmrpmgegftjszgvsgqavcrvdtsxlkxjpqtlnkjuyraknwxmnthfpt",a);


	}

	@Test
	void testLibraryFine(){

	}


	@Test
	void testCutTheSticks(){
		int[] output = SolutionApplication.cutTheSticks(new int[]{1, 2, 3, 4, 3, 3 ,2 ,1});
		Arrays.stream(output).forEach(System.out::println);
	}

	@Test
	void testpatternSyntaxChecker(){
		SolutionApplication.patternSyntaxChecker("([A-Z])(.+)");
		SolutionApplication.patternSyntaxChecker("[AZ[a-z](a-z)");
		SolutionApplication.patternSyntaxChecker("batcatpat(nat");
	}

	@Test
	void TestPrimalityTest(){
		SolutionApplication.primalityTest("13");
		SolutionApplication.primalityTest("12");
	}

	@Test
	void testTestBigDecimal(){
		String[] sArr = {"00.002","123.456","0.002","4.5555555"};
		SolutionApplication.testBigDecimal(sArr);
		System.out.println("----------------");
		String[] sArr2 = {"-100","50","0","56.6","90","0.12",".12","02.34","000.000"};
		SolutionApplication.testBigDecimal(sArr2);

	}

	@Test
	void testTestBigInteger(){
		SolutionApplication.testBigInteger("12345","99999");

	}

	@Test
	void testJavaStringTokens(){
		String ss="   He is a very very good boy, isn't he?    ";
//		SolutionApplication.javaStringToken(ss);
		ss="Good luck with this case!!! h jrkjc c l m e i vct h ss pqk_v i olf tuoej_          p r jrpjpuo a.          udc mu tk g dc,          j o mui brljn!jv p rsklqu p?a lv l n dl quo!cml pld qf l s!          t nb ud j etc q           a j f ugc eer c,          ci de lm p iwk_nwa e su s u ga.l w xlkod f e v_          oo ukaa v t xe.          j cl vmh hi tl!          xa aw ugeibo?c r oo v qte ri,          elbf ibg qk i_m nm s ainis s           u m rhd fgi h v!          mji tu oj t c d.x hxtp a bf xj.          l j ela wuj is           pj gu fs e o v i,s s i b k kab tw@          im c vlud k ki!          e ft gpcf t g k'          m c r snv w b rw,hwoh dfl hn u@cb ep ucsse j_          a d h q p w q rjp_          tln j vofvwg_sj rx pur l dx_          vo b lk sljnm?          k xox i cv va l,          du toe sdwx g@c s uded gw od!          tqsv v t v fnl'          o amka ll x s q_          a frs s ltubs?wdjfdrf x jk.jgkb d s d k n m@sedwkpe ev h_icr ggqxvap@          j g hva o kja q?          j j q ra iak c u!          vqnf thfw wx!          ccn mox sp do'u r ei ifah nl'u g m qipu r c e           ws op hng fbp.          fr vle qh d fv_okcei p e oal_a nsxi g to w x!          qfvv sr cjmo_          kchrkonuc f'ush wd xptas!rfrt o llgwf?          jclpl wmt h r           rv o lhnxnbf           h fqfnla pft?n b uu tbba sl_u ij f i jox xu.ext p gs un dc           fx p o kh rl l j'nkgevg xdrq?          q s wv umu olw?jaidu ilpr e?fc qcr p htpn           g xt d d uqk cp,          cts jkg e i op_j utt rf gvm t!          qgjr r r s cpc,          m n a wde pcg v?e ioek nlc fh@ahk ei ejmp d_fq enmeoesu?          skntwnolsx!j bt bgb dhtt!          r jcl mdh i kr,          m jcl fgix gq_enpuk n g rl i?ei xedl o h e a!x wjp uge h w g'wb dg wlkxli qi x ff eq gbe_bakb m c p aos_vv c m labuj r!          s t oign xwn a@c ffwpic wck_          gmkahnse si!q viev a ndfg,f p utcumoxb'          kgd m n g gnk b!          i rr x x uxx g p_          af s piu hgs o?          kpmrltmrqe@s m mbjfnxq p'          g f i v l wc u ij@";
//		SolutionApplication.javaStringToken(ss);
		ss="";
		SolutionApplication.javaStringToken(ss);
	}


	//Java Regex for IP validation
	@Test
	void testJavaRegex(){
//		String s = "000.12.12.034";
		String s = "000.13.123.12";
//		String pattern = "\\b([0-9]|[0-9][0-9]|[0][0-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b\\.";
//		String pattern = "\\b(\\b([0-9]|[0-9][0-9]|[0][0-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b\\.|\\b([0-9]|[0-9][0-9]|[0][0-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b)\\b";
//		String pattern = "\\b([0-9]|[0-9][0-9]|[0][0-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b";
		String pattern = "\\b([0-9]|[0-9][0-9]|[0][0-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b\\.\\b([0-9]|[0-9][0-9]|[0][0-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b\\.\\b([0-9]|[0-9][0-9]|[0][0-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b\\.\\b([0-9]|[0-9][0-9]|[0][0-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b";
		SolutionApplication.pattern(s,pattern);

	}

	@Test
	void testJava2DArray(){
//		int[][] inputs = {{1, 1, 1, 0, 0, 0},{0, 1, 0, 0, 0, 0},{1,1, 1, 0, 0, 0},{0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0},{0, 0, 0,0, 0, 0}};
//
//		int maxSum = SolutionApplication.java2dArray(inputs);
//		System.out.println(maxSum);
//
//		int[][] inputs2 = {{1, 1, 1, 0 ,0 ,0},{0, 1, 0, 0 ,0, 0}, {1, 1, 1, 0, 0, 0}, {0, 0, 2, 4 ,4 ,0},{0 ,0, 0, 2, 0, 0},{0, 0, 1, 2, 4, 0}};
//		maxSum = SolutionApplication.java2dArray(inputs2);
//		System.out.println(maxSum);
//
//		int[][] inputs3 ={    {1, 1, 1, 0, 0, 0,},{0, 1, 0, 0, 0, 0},{1, 1, 1, 0, 0, 0},{0, 9, 2, -4, -4, 0},{0, 0, 0, -2, 0, 0},{0, 0, -1, -2, -4, 0}};
//		maxSum = SolutionApplication.java2dArray(inputs3);
//		System.out.println(maxSum);

		int[][] inputs4 ={    {0, -4, -6, 0, -7, -6},{-1, -2, -6, -8, -3, -1},{-8, -4, -2, -8, -8, -6},{-3, -1, -2, -5, -7, -4},{-3, -5, -3, -6, -6, -6},{-3, -6, 0, -8, -6, -7}};
		int maxSum = SolutionApplication.java2dArray(inputs4);
		System.out.println(maxSum);

	}

	@Test
	void testCanWin(){
//		int[] game = {0,0,0,0,0};
//		boolean b = SolutionApplication.canWin(3,game);
//		assertTrue(b);
//
//		int[] game1 = {0,0,0,1,1,1};
//		b = SolutionApplication.canWin(5,game1);
//		assertTrue(b);
//
//		int[] game2 = {0,0,1,1,1,0};
//		b = SolutionApplication.canWin(3,game2);
//		assertTrue(!b);
//
//		int[] game4 = {0,1,0};
//		b = SolutionApplication.canWin(1,game4);
//		assertTrue(!b);
//
//		int[] game5 = {0,0,0,0,1};
//		b = SolutionApplication.canWin(3,game5);
//		assertTrue(b);
//
//		int[] game6 = {0 ,0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1,0 ,0 ,1 ,1 ,1 ,1 ,0 ,1 ,0 ,1 ,1 ,1 ,1 ,1, 0, 0, 1, 0, 1, 0};
//		b = SolutionApplication.canWin(39,game6);
//		assertTrue(b);
//
//		int[] game7 = {0, 1, 1, 1, 0, 1 ,1, 1, 0, 1, 0};
//		b = SolutionApplication.canWin(4,game7);
//		assertTrue(b);
//
//		int[] game8 = {0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1,0,1,0,0,0,0,1,1,0,1,0,0,1,1,0};
//		boolean b = SolutionApplication.canWin(15,game8);
//		assertTrue(!b);

//		int[] game9 = {0,1,1,1,0,0,0,0,0,0,1};
//		b = SolutionApplication.canWin(5,game9);
//		assertTrue(b);
//
//		int[] game10 = {0,1,1,1,0,0,1,1,1,0,1};
//		b = SolutionApplication.canWin(5,game10);
//		assertTrue(b);
//
//		int[] game11 = {0,1,1,1,1,0,1,1,1,0,1};
//		b = SolutionApplication.canWin(5,game11);
//		assertTrue(!b);
//
//		int[] game12 = {0,1,1,1,1,0,0,0,1,1,1,1,0,1,1};
//		b = SolutionApplication.canWin(7,game12);
//		assertTrue(b);
//
//		int[] game13 = {0,1,1,1,1,0,1,0,1,1,1,1,0,1,1};
//		b = SolutionApplication.canWin(7,game13);
//		assertTrue(!b);

//		int[] game14={0,1,1,1,1,1,1,1,0,1,0,0,1,0,0,1,1,0,1,0,1,0,0,1,1,0,1,1,1,1,1,1,0,0,0,0,1,1,1,1,0,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,1,1,1,1,0,1,0,1,1,1,1,0,1,1,1,0,1,1,0};
//		boolean b= SolutionApplication.canWin(34,game14);
//		assertTrue(b);

		int[] games15 ={0,0,1,1,1,0,1,0,1,0,0,0,1,1,1,1,1,1,0,0,1,0,0,1,1,0,1,1,0,0,1,1,1,1,1};
		boolean b= SolutionApplication.canWin(10,games15);
		assertTrue(b);



		}

		@Test
		void testFindNegativeSums() {
		int[] a = {1,-2,4,-5,1};
			SolutionApplication.findNegativeSums(a);
		}

		@Test
		void testStatck(){
			Stack<Integer> myStack = new Stack<>();
			myStack.add(1);
			myStack.add(2);
			myStack.add(3);
			myStack.stream().forEach(System.out::println);
			myStack.clear();
			myStack.push(1);
			myStack.push(2);
			myStack.push(3);

			myStack.stream().peek(System.out::println);
//			while(!myStack.empty()) {
//				System.out.println(myStack.pop());
//			}

			Hashtable<Integer, String> ht = new Hashtable<>();
			ht.put(1, "hi");
			ht.put(1,"hello");
			System.out.println(ht.get(1));

			HashMap<String,Integer> a = new HashMap<>();
			//a.values()


		}

		@Test
		void testIsBalanced(){
			String s ="{}()";
			boolean b = SolutionApplication.isBalanced(s);
			assertTrue(b);

			s ="{}()()()({})";
 			b = SolutionApplication.isBalanced(s);
			assertTrue(b);

			s ="{}()()()({})))";
			b = SolutionApplication.isBalanced(s);
			assertTrue(!b);

			s ="{(())}";
			b = SolutionApplication.isBalanced(s);
			assertTrue(b);

			s ="{(({{}}))}";
			b = SolutionApplication.isBalanced(s);
			assertTrue(b);
		}

	@Test
	void testLongestSubarray(){
//		Integer[] a = {0,1,2,1,2,3};
//		List<Integer> inputList = Arrays.asList(a);
//		int max = SolutionApplication.longestSubarray(inputList);
//		System.out.println(max);
//
//		Integer[] a1 = {0,1,2,1,2,3};
//		List<Integer> inputList1 = Arrays.asList(a1);
//		int max1 = SolutionApplication.longestSubarray(inputList1);
//		System.out.println(max1);

		Integer[] a2 = {2,9,5,3,3,1,5,3,5};
		List<Integer> inputList2 = Arrays.asList(a2);
		int max2 = SolutionApplication.longestSubarray(inputList2);
		System.out.println(max2);
	}

	@Test
	void testsockMerchant() {
		int n=9;
		int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};
		int a= SolutionApplication.sockMerchant(n,ar);
		System.out.println(a);
		assertTrue(a==3);

	}

	@Test
	void testJumpingOnCloud(){

		SolutionApplication.jumpingOnClouds2(new int[]{0, 0, 1, 0, 0, 1, 0});
		SolutionApplication.jumpingOnClouds2(new int[]{0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1});
		SolutionApplication.jumpingOnClouds2(new int[]{0, 0, 1, 0, 0, 1, 0});
		SolutionApplication.jumpingOnClouds2(new int[]{0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0});
	}

	@Test
	void testSherlockAndAnagrams(){
		SolutionApplication.sherlockAndAnagrams2("cdcd");
		System.out.println("---------------");
		SolutionApplication.sherlockAndAnagrams2("ifailuhkqq");
		System.out.println("---------------");
		SolutionApplication.sherlockAndAnagrams2("kkkk");
	}

	@Test
	void testequalizeArray(){
		int[] a = {2,1,3,4,3,4,4,7,4,8,4,4,6,7,8,5};
		int answer = SolutionApplication.equalizeArray(a);
		System.out.println(answer);
		int[] a1 = {3, 3, 2, 1, 3};
		answer = SolutionApplication.equalizeArray(a1);
		System.out.println(answer);
		int[] a2 = {1, 1, 1, 1, 1};
		answer = SolutionApplication.equalizeArray(a2);
		System.out.println(answer);
		int[] a3 = {3,3,2,1,3};
		answer = SolutionApplication.equalizeArray(a3);
		System.out.println(answer);

	}

	@Test
	void testcircularArrayRotation(){
		int[] a = {1,2,3};

		int[] result = SolutionApplication.circularArrayRotation(a,2,new int[]{1});
		Arrays.stream(result).forEach(System.out::println);

	}

	@Test
	void testAlmostSorted() {
//		int[] a ={2,3,8,7,6,5,4};
//		int[] a ={3,1,2,4};
//		SolutionApplication.almostSorted(a);
//
//		int[] a1 ={2,3,4,7,6,5,8}; //-> Swappable
//		SolutionApplication.almostSorted(a1);
//
//		int[] a2 ={2,3,4,9,7,6,5,10,8};
//		SolutionApplication.almostSorted(a2);
//
//		int[] a3 ={2,3,4,10,9,8,7,6,5};
//		SolutionApplication.almostSorted(a3);
//
//		int[] a4 ={4,3,2,5,10,9,8,7,6};
//		SolutionApplication.almostSorted(a4);

		int[] a5={1, 5, 4, 3, 2, 6};
		SolutionApplication.almostSorted(a5);

//		int[] a6={4,2};
//		SolutionApplication.almostSorted(a6);
//
//		int[] a7={3,1,2};
//		SolutionApplication.almostSorted(a7);
	}

	@Test
	void test123(){
		int[] a2 ={2,3,4,9,7,6,5,10,8};

		ArrayList<Integer> list = new ArrayList<>();
		for(int i : a2){
			list.add(i);
		}

		list.stream().skip(2).limit(4).forEach(j->System.out.print(j+" "));

		System.out.println("");

		list.stream().skip(list.size()-1).forEach(j->System.out.print(j+" "));
		System.out.println("");


		String[] s = {"A","v","G","1","9","0","4","2","0","T"};
		ArrayList<String> list5 = new ArrayList<>();
		for(String each  : s){
			list5.add(each);
		}
		list5.stream().limit(3).forEach(j->System.out.print(j+" "));
		System.out.println(list5.stream().limit(3).allMatch(each->each.matches("[A-Z]")));

		System.out.println("");
		list5.stream().skip(3).limit(4).forEach(j->System.out.print(j+" "));
		System.out.println("");
		list5.stream().skip(list5.size()-1).forEach(j->System.out.print(j+" "));
		System.out.println("");
		list5.stream().skip(7).limit(12-list5.size()).forEach(j->System.out.print(j+" "));
		System.out.println("");
		int ans = SolutionApplication.moves(list);
		assertTrue(ans==3);

		int[] a3 ={1,2};

		ArrayList<Integer> list2 = new ArrayList<>();
		for(int i : a3){
			list2.add(i);
		}

		ans = SolutionApplication.moves(list2);
		System.out.println(ans);
		assertTrue(ans==1);


		String ss = "AVG190420z";
		System.out.println(ss.substring(0,3));
		System.out.println(ss.substring(3,7));
		System.out.println(ss.substring(7,7+12-ss.length()));

		System.out.println("--->"+ss.substring(ss.length()-1));
		if(ss.substring(ss.length()-1).matches("[A-Z]")){
			System.out.println("one last char match");
		}else{
			System.out.println("one last char not match");
		}

		boolean yearPass = false;
		if(!ss.substring(3,7).matches("[^0-9]")) {
			System.out.println(ss.substring(3,7));
			int year =  Integer.parseInt(ss.substring(3,7));
			if(year>=1904 && year <=2019){
				yearPass = true;
				System.out.println("year: "+year+" pass");
			}else{
				System.out.println(" year not pass");
			}
		}


	}

	@Test
	void test777(){
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("AVG190420Z");
//		list2.add("RED190250E");
//		list2.add("RRED190250E");
//		list2.add("TYU20121000E");
//		list2.add("TYU2012100E");
		list2.add("AbC200010E");
		int ans = SolutionApplication.countCounterfeit(list2);
		System.out.println(ans);
		System.out.println("ABc".matches("[a-z]"));
		System.out.println("ABc".matches("[A-Z]"));
		System.out.println("A".matches("[A-Z]"));
	}

	@Test
	void testBigSortings(){
		String[] inputs = {
				"1",
				"2",
				"100",
				"12303479849857341718340192371",
				"3084193741082937",
				"3084193741082938",
				"111",
				"200"};
		String[] results =  SolutionApplication.bigSorting(inputs);
		Arrays.stream(results).forEach(System.out::println);
	}

	@Test
	void testAllSubsetOfASet(){
		int[] a = {1,2,3};
		SolutionApplication.allSubsetOfASet(a);
	}

	@Test
	void testactivityNotifications(){
		int[] input = {2, 3, 4, 2, 3 ,6 ,8 ,4, 5};
		int ans = SolutionApplication.activityNotifications(input,5);
		System.out.println(ans);
	}

	@Test
	void testbeautifulDays(){
		int ans = SolutionApplication.beautifulDays(23,26,6);
		assertTrue(ans==2);
	}

	@Test
	void testlonelyInteger(){
		int ans = SolutionApplication.lonelyInteger(new int[]{0, 0, 1, 2, 1});
		assertTrue(ans==2);

	}

	@Test
	void testFindPrime(){
		SolutionApplication.findPrime(15);
	}

	@Test
	void testPlay(){
		SolutionApplication.play();
	}

	@Test
	void testPermutationEquation(){

		int[] results = SolutionApplication.permutationEquation(new int[]{4, 3, 5, 1, 2});

		assertArrayEquals(new int[]{1,3,5,4,2},results);

		String s = "a";
		System.out.println((int)s.toCharArray()[0]);
	}

	@Test
	void testappendAndDelete(){
		String s = SolutionApplication.appendAndDelete("hackerhappy","hackerrank",9);
		System.out.println(s);
		s = SolutionApplication.appendAndDelete("aba","aba",7);
		System.out.println(s);
		s = SolutionApplication.appendAndDelete("zzzzz","zzzzzzz",4);
		System.out.println(s);
		s = SolutionApplication.appendAndDelete("ashley","ash",2);
		System.out.println(s);




	}

	@Test
	void testextraLongFactorials(){
		SolutionApplication.extraLongFactorials(25);
	}

	@Test
	void testTimeInWords(){
		String s = SolutionApplication.timeInWords(5,23);
		System.out.println(s);
		s = SolutionApplication.timeInWords(5,2);
		System.out.println(s);
		s = SolutionApplication.timeInWords(5,1);
		System.out.println(s);
		s = SolutionApplication.timeInWords(5,32);
		System.out.println(s);
		s = SolutionApplication.timeInWords(5,59);
		System.out.println(s);
		s = SolutionApplication.timeInWords(5,45);
		System.out.println(s);
		s = SolutionApplication.timeInWords(5,15);
		System.out.println(s);
		s = SolutionApplication.timeInWords(5,30);
		System.out.println(s);
		s = SolutionApplication.timeInWords(7,27);
		System.out.println(s);
		s = SolutionApplication.timeInWords(7,00);
		System.out.println(s);
		s = SolutionApplication.timeInWords(7,12);
		System.out.println(s);
		s = SolutionApplication.timeInWords(7,48);
		System.out.println(s);
		s = SolutionApplication.timeInWords(11,48);
		System.out.println(s);


	}

	@Test
	void testorganizingContainers(){
//		int q=3;
//		int[][] c = {{1, 3, 1},{2, 1, 2},{3, 3, 3}};
//		String s = SolutionApplication.organizingContainers(q,c);
//		System.out.println(s);
//
//		q=2;
//		int[][] d={{1,1},{1,1}};
//		s = SolutionApplication.organizingContainers(q,d);
//		System.out.println(s);
//		q=2;
//		int[][] e={{0,2},{1,1}};
//		s = SolutionApplication.organizingContainers(q,e);
//		System.out.println(s);
//
//		q=2;
//		int[][] f = {{999336263, 998799923},
//					{998799923, 999763019}};
//		s = SolutionApplication.organizingContainers(q,f);
//		System.out.println(s);

		int q=4;
		int[][] g = {{997612619, 934920795, 998879231, 999926463},
					 {960369681, 997828120, 999792735, 979622676},
					 {999013654, 998634077, 997988323, 958769423},
					 {997409523, 999301350, 940952923, 993020546}};
		String s = SolutionApplication.organizingContainers(q,g);
		System.out.println(s);
	}

	@Test
	void testTheLoverLetterMystery(){
		int a =SolutionApplication.theLoverLetterMystery("cda");
		System.out.println(a);

		int b =SolutionApplication.theLoverLetterMystery("abcd");
		System.out.println(b);
	}

	@Test
	void testAnagram(){
		int ans = SolutionApplication.anagram("aaabbb");
		System.out.println(ans);
	}

	@Test
	void testStones(){
		List<Integer> list1 = SolutionApplication.stones(7,9,11);
		list1.stream().forEach(System.out::println);
//		System.out.println("---------------");
//		list1 = SolutionApplication.stones(2,2,3);
//		list1.stream().forEach(System.out::println);
		System.out.println("---------------");
		list1=SolutionApplication.stones(3,1,2);
		list1.stream().forEach(System.out::println);
		System.out.println("---------------");
		list1=SolutionApplication.stones(4,10,100);
		list1.stream().forEach(System.out::println);
		System.out.println("---------------");
		list1=SolutionApplication.stones(58,69,24);
		list1.stream().forEach(System.out::println);
		System.out.println("---------------");
		list1=SolutionApplication.stones(5,3,23);
		list1.stream().forEach(System.out::println);
		System.out.println("---------------");
		list1=SolutionApplication.stones(12,73,82);
		list1.stream().forEach(System.out::println);
		System.out.println("---------------");
		list1=SolutionApplication.stones(83,86,81);
		list1.stream().forEach(System.out::println);
		System.out.println("---------------");
		list1=SolutionApplication.stones(73,25,25);
		list1.stream().forEach(System.out::println);
	}


	@Test
	public void testResult(){
		SolutionApplication.Result r = new SolutionApplication.Result();
		r.stepPerms(3);
		System.out.println(r.counter);

	}

	@Test
	public void testResult2(){
		SolutionApplication.Result2 r = new SolutionApplication.Result2();
		r.stepPerms(3);
		System.out.println(r.counter);

	}


	@Test
	public void testResult3(){
		SolutionApplication.Result3 r = new SolutionApplication.Result3();
		r.stepPerms(3);
		System.out.println(r.counter);
		r.stepPerms(5);
		System.out.println(r.counter);
		r.stepPerms(7);
		System.out.println(r.counter);
		r.stepPerms(35);
		System.out.println(r.counter);
	}

	@Test
	public void testResultForIceCreamParlor(){
		ArrayList al = new ArrayList();
		al.add(1);
		al.add(4);
		al.add(5);
		al.add(3);
		al.add(2);
		List<Integer> result = SolutionApplication.ResultForIceCreamParlor.icecreamParlor(4,al);
		result.stream().forEach(System.out::println);

	}

	@Test
	void testMyDfsGraph(){
		SolutionApplication s = new SolutionApplication();
		SolutionApplication.MyDfsGraph myDfsGraph = s.getMyDfsGraph(10);

		myDfsGraph.addEdge(0,1);
		myDfsGraph.addEdge(1,2);
		myDfsGraph.addEdge(1,3);
		myDfsGraph.addEdge(2,4);
		myDfsGraph.addEdge(2,3);
		myDfsGraph.addEdge(3,4);
		myDfsGraph.addEdge(2,3);
		myDfsGraph.addEdge(3,5);
		myDfsGraph.addEdge(5,6);
		myDfsGraph.addEdge(5,7);
		myDfsGraph.addEdge(6,8);

		myDfsGraph.dfs(0);
	}

	@Test
	void testMyQuickSort(){
		SolutionApplication solutionApplication = new SolutionApplication();
		SolutionApplication.MyQuickSort myQuickSort = solutionApplication.getMyQuickSort();
		int[] a ={5,3,7,1,4,9,2,6,8};
		myQuickSort.quickSort(a);
		Arrays.stream(a).forEach(num->System.out.print(num+" "));
	}
}
