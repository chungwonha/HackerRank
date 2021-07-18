package com.example.demo;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class CoinChange {

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */

    static long counter=0;
    static HashMap<List<Long>,Long> bucket;
    public static long getWays(int n, List<Long> c) {
        // Write your code here
        bucket = new HashMap<>();

        ArrayList<Long> numList = new ArrayList<Long>();
        addNextLevel(n,numList,c);
        // System.out.println("counter: "+counter);
        // ArrayList<Long> aaa = new ArrayList();
        // aaa.add(1L);
        // aaa.add(1L);
        // aaa.add(1L);
        // aaa.add(1L);
        // Long test111 = bucket.get(aaa);
        // System.out.println(test111!=null?"Found: "+test111.toString():"NOT FOUND");

        // bucket.keySet().stream().forEach(k->{
        //     k.stream().forEach(p->{
        //         System.out.print(p+ " ");
        //     });
        //     System.out.print("--->"+bucket.get(k));
        //     System.out.println("");
        // });

        return bucket.values().stream().filter(v->v==n).count();
    }

    public static void addNextLevel(int n, List<Long> numArr, List<Long> c){
        long sum = 0;
        for(Long each:c){
            // System.out.print(each+" ");
            List<Long> sortedList = getSortedList(numArr,each);
            Long foundNum = bucket.get(sortedList);

            if(foundNum!=null){
                sum=foundNum+each;
            }else{
                sum = sortedList.stream().reduce(0L,Long::sum);
                bucket.put(sortedList,new Long(sum));
            }

            if(sum==n){
                // System.out.println("");
                counter++;
                continue;
            }else if (sum>n){
                break;
            }else{
                addNextLevel(n,sortedList,c);
            }
        }
    }

    public static List<Long> getSortedList(List<Long> numArr, Long newLong){
        ArrayList<Long> al = new ArrayList<>();
        if(numArr.size()>0){
            numArr.stream().forEach(al::add);
        }

        al.add(newLong);
        List<Long> sortedAl = al.stream().sorted().collect(toList());
        return sortedAl;
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

        long ways = CoinChange.getWays(n, c);

        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

