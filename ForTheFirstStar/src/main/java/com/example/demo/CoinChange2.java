package com.example.demo;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CoinChange2 {
    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */

    public static long getWays(int n, List<Long> c) {

        long[] coins = new long[c.size()];
        for(int i=0;i<c.size();i++){
            coins[i]=c.get(i);
        }

        long[] dp = new long[n+1];

        dp[0]=1;

        for(long coin:coins){

            for(int j=1;j<dp.length;j++){
                if(coin<=j){
                    int i = j - (int)coin;
                    dp[j] += dp[i];
                }
            }

        }
        return dp[n];

    }

    public static long getWays2(int n, List<Long> c) {
        // Write your code here
        //int[] dp = new int[n+1];
        HashMap<Long,Long> dp = new HashMap<>();
        //Arrays.fill(dp,n+1);
        dp.put(new Long(0),new Long(0));
        for(int k=1;k<=n;k++){
            dp.put(new Long(k),new Long(0));
        }
        Queue<Integer> a = new LinkedList<>();

        for(int i=0;i<=n;i++){
            for(int j=0;j<c.size();j++){
                long selectedCoin = c.get(j);
                if(selectedCoin<=i){
                    /*i => represents a smaller target amt
                    because we need counts that was done for the amounts minus
                    selectedCoin.  In other words,
                 ** one new count for selected coin for the current amount
                 **             PLUS
                 ** counts for the amounts without the select coin
                    therefore, dp[i-selectedCoinget] will retrieve the counts for
                    amounts without/before the select coin

                    therefore, add 1 to the counts
                    and that is stored in the currnet dp, which is dp[i]
                    */
                    long tempI = i-selectedCoin;

                    dp.put(new Long(i),new Long(1+dp.get(tempI)));
                }
            }
        }
        dp.keySet().stream().forEach(k->System.out.println(k+" "+dp.get(k)));
        System.out.println(dp.get(new Long(n)));

        return dp.get(new Long(n));
    }




    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = CoinChange2.getWays(n, c);

        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
