package com.company.chung;

import java.util.Scanner;

public class Main {

    static void minimumBribes(int[] q){
//1. find diff between index+1 and value
//2. if diff > 2 then chaos
//3. if diff <=2 then increase counter
        //1 2 3 4 5 6 7 8
        //1 2 5 3 4 6 7 8
        //1 2 4 5 3 6 7 8
        //1 2 4 6 5 3 7 8
        //1 2 5 3 7 8 6 4
        // 5 -> 4-2 = 2
        // 7 -> 6-4 = 2
        // 8 -> 7-5 = 2
        //
        int bribeCounter=0;
        boolean tooChaotic=false;
        for(int i=0;i<q.length-1;i++){

                System.out.println(q[i] + "," + (i + 1) + "," + (q[i] - (i + 1)));
                int diff = q[i] - (i + 1);
                if (diff > 2) {
                    tooChaotic = true;
                    break;
                } else {
                    for (int j = i-1; j >= 0; j--) {
                        if (q[j] > q[i]) {
                            int temp = q[j];
                            q[j]=q[i];
                            q[i]=temp;
                            bribeCounter++;
                            i--;
                        }
                    }
                }
        }
        System.out.println(tooChaotic?"Too chaotic":bribeCounter);
    }



//    static void minimumBribes3(int[] q){
//        int bribeCounter=0;
//        boolean tooChaotic=false;
//
//        for(int i=q.length;i>=1;i--){
//
//            if()
//
//        }
//
//        System.out.println(tooChaotic?"Too chaotic":bribeCounter);
//    }

    static void minimumBribes2(int[] q){
            int bribes=0;
            for(int i=q.length;i>=1;--i)
            {
                if (q[i - 1] - i > 2) {
                    System.out.println("Too chaotic");
                    return;
                }
                //Check to front of my position, if there are numbers greater than me then they must have bribed me to get ahead.
                for(int j=i-2;j>=Integer.max(q[i-1]-2,0);--j) {
                    if (q[j] > q[i - 1]) {
                        System.out.println(q[j]+","+q[i-1]);
                        bribes++;
                    }
                }
            }
            System.out.println(bribes);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");


        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
