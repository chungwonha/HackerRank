package com.company.chung;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        	 Main main = new Main();
        	 main.tryThis();
    }

    public void tryThis(){

        MyCompartor1 myCompartor1 = new MyCompartor1();
        String[] s ={"2.0","123.00","4.5","0.07","00.07"};
        Arrays.stream(s).sorted(myCompartor1).forEach(System.out::println);
    }
    //a>b -> 1
    //a==b=0
    //a<b=-1

    class MyCompartor1 implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            BigDecimal o1_integer = new BigDecimal(o1);
            BigDecimal o2_integer = new BigDecimal(o2);
                    if(o2_integer.compareTo(o1_integer)==0){
                        return 1;
                    }
            return o2_integer.compareTo(o1_integer);
        }
    }
    class MyCompartor2 implements Comparator<BigInteger> {

        @Override
        public int compare(BigInteger o1, BigInteger o2) {
            return o1.compareTo(o2);
        }
    }
}
