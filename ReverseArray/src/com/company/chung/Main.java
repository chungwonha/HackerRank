package com.company.chung;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    System.out.println("main from ReverseArray");
	    int[] a = {1,3,5,8};
	    int[] b = reverseArray(a);
        Arrays.stream(b).forEach(System.out::println);

    }

    static int[] reverseArray(int[] a) {

        int[] newArr = new int[a.length];

        for(int i=0;i<a.length;i++){
            newArr[i]=a[a.length-(i+1)];
        }

        return newArr;
    }
}
