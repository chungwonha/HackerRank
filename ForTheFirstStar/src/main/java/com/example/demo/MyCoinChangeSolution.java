package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyCoinChangeSolution {
    /*

    1, 1, 1, 1, ..... 15
    2  1  1  1
    targetamt 0  1  2  3  4  5
       {1}    1  1  1  1  1  1 =1
       {2}    0  1  1  1  2
                 1  1  0
     coin = 1
    1
    f(n-1)+f(n)


     for each new coin in all availabe coins loop
					 target[targetamt+1];
					 		for target loop target.size
					 		if(each coin == each target) then
					 		   put in bucket[i]
					 		else if each coin < each target and then
					 		   	 append 1 + bucket[i-1]

					 		   each coin+bucket[i-1]

					 		     5                    5           5               4
                                  1  4                2 3 ->      3  2            1 3
                                     1 3  ->  1,1,3     2 1 ->       3 -1 ->out     1 2
                                       1 2 ->             2 -1 ->out
                                         1 1 ->           1  1
                                           1 0 ->exit        1

        1   2   5   10
        15                                  15        15                 14             14
         1  14  (2+2+2+2+2+2+2)              2  13     5 10               1  13          2   12
             1 13                               2  11     5                   1  12           2  10
                1  12  2+2+2+2+2+2                  2 9                                           2  8
                    1  11                                  2 10                                      2  6
                        1  10   2+2+2+2+2                    2 8
                            1  9                               2 6->
                               1  8  2+2+2+2                    2 4
                                  1  7                           2 2 ->
                                     1  6 ->2+2+2                 2 0
                                        1  5 ->
                                           1  4 ->2 + 2
                                              1 3
                                                1 2 ->
                                                  1 1 ->
                                                    1 0


        15
         2 13
            2 11
               2 9
                 2 7
                   2 5 ->
                     2 3
                       2 1

        t=
        2,3,6,7
        1 2 3 4 5 6
      2   1   1   1
      4   1   1   1
      7   1   1

     6              6
     2  4  ->       4 2
        2  2 ->       4 2 -exit
           2  0 ->exit

        t=5
        1,4,7
        1 2 3 4 5
      1 1 1 1 1 1
      4       1 1
      7 1 1

      5
      1 4 ->
        1 3
          1 2
            1 1->
              1 0

        15
        1  2  5

     subtractcoin(target,coin, string stringCoin)
				 result = target-coin;
				 if(result<=0) return;
				 if(result is one of available coins)
				 	add so-far-numbers to bucket
				 	return subtract(result,coin,stringCoin)
				 else
				 	return subtract(result,coin,stringCoin)


				for i in coins loop

					subtractcoin(target,coins[i],

				end loop
     */


    public void findWaysToSumCoins(int[] coins, int target){

        ArrayList<String> bucket = new ArrayList<>();

        for (int i=0;i<coins.length;i++){

            String s = Integer.toString(coins[i]);
            subtractCoins(target,coins[i],coins,s,bucket);
        }

        bucket.stream().forEach(System.out::println);
    }

    public void subtractCoins(int target, int coin, int[] availableCoins, String stringOfCoins,List<String> bucket){

        int result = target-coin;
        if(result<=0) return;
        boolean found=false;
        for(int e:availableCoins){
            if(e==result) found=true;
        }

        if(found) {
            String s = stringOfCoins+", "+result;
//            System.out.println(s);
            bucket.add(s);
            subtractCoins(result, coin, availableCoins, stringOfCoins+", "+coin,bucket);
        }else {
            stringOfCoins=stringOfCoins+", "+coin;
            subtractCoins(result,coin,availableCoins,stringOfCoins,bucket);
        }

    }


    public void findWaysToSumCoins2(int[] coins, int target){
        int[] possibleTargets = new int[target+1];

        ArrayList<String> bucket = new ArrayList<>();

        for (int i=0;i<coins.length;i++){

            String s = Integer.toString(coins[i]);
            subtractCoins2(target,coins[i],coins,s,bucket);
        }

        bucket.stream().forEach(System.out::println);
    }

    public void subtractCoins2(int target, int coin, int[] availableCoins, String stringOfCoins,List<String> bucket){

        int result = target-coin;
        if(result<=0) return;
        boolean found=false;
        for(int e:availableCoins){
            if(e==result) found=true;
        }

        if(found) {
            String s = stringOfCoins+", "+result;
//            System.out.println(s);
            bucket.add(s);
            subtractCoins(result, coin, availableCoins, stringOfCoins+", "+coin,bucket);
        }else {
            stringOfCoins=stringOfCoins+", "+coin;
            subtractCoins(result,coin,availableCoins,stringOfCoins,bucket);
        }

    }
}
