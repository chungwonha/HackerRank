package com.example.demo;

import java.util.ArrayList;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

/*
This question is designed to help you get a better understanding of basic heap operations.

There are

types of query:

    "

"1 v" - Add an element
to the heap.
"
"2 v - Delete the element
from the heap.
"
"3 - Print the minimum of all the elements in the heap.

Sample Input

STDIN       Function
-----       --------
5           Q = 5
1 4         insert 4
1 9         insert 9
3           print minimum
2 4         delete 4
3           print minimum

 */
public class QHeap1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        ArrayList<Integer> heap = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();

        for(int i=0;i<a;i++){
            int b = scan.nextInt();
            if(b==1 || b==2){
                int c = scan.nextInt();
                if(b==1) {
                    if(heap.size()==0) heap.add(0,c);
                    else{
                        int root = heap.get(0);
                        if(root>c){
                            //heap.add(heap.size()-1,root);
                            heap.add(0,c);
                        }else{
                            heap.add(c);
                        }

                    }
                    // if(c==-419921){
                    //  System.out.println("-------------->added: "+c);
                    // }
                }else if(b==2) {
                    for(int j=0;j<heap.size();j++)
                    {
                        if(heap.get(j)==c)
                        {
                            //System.out.println("found "+c+" at "+j+" heap size: "+heap.size());
                            heap.remove(j);
                            //System.out.println("removed "+c+" from "+j+" heap size: " +heap.size());


                            if(j==0){
                                // System.out.println(" found j==0 "+"heap.size: "+heap.size());
                                // heap.stream().forEach(a1->System.out.print(a1+" "));
                                if(heap.size()>0){
                                    //System.out.println(heap.get(0)+" at 0");

                                    int newMin = heap.stream().reduce(Integer::min).get();
                                    //System.out.println("newMin is "+newMin);
                                    int index = heap.indexOf(newMin);
                                    heap.remove(index);
                                    heap.add(0,newMin);
                                }

                            }
                            Integer count = heap.stream().filter(t->t==-419921).collect(toList()).size();
                            // System.out.println("---------->count for "+c+" "+count);
                            break;
                        }
                    }
                    // System.out.println("heap.size: "+heap.size());
                }
            }else if(b==3){
                int r = heap.get(0);
                System.out.println(r);
            }

        }

    }
}
