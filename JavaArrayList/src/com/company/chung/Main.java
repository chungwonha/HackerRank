package com.company.chung;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        String d = scan.nextLine();
        int numLineCounter = n;
        ArrayList<String[]> numList = new ArrayList<>();

        while(numLineCounter>0) {

            String dd = scan.nextLine();
            System.out.println(dd);
            String[] sArr = dd.split(" ");
            numList.add(sArr);
            numLineCounter--;
        }

        numList.stream().forEach(a->{
            for(String s : a){
                System.out.print(s);
            }
            System.out.println("");
        });

        int q = scan.nextInt();
        int qCounter = q;
        String[] qArr = new String[q];
        String eachQ = scan.nextLine();
        for(int i=0;i<q;i++){
            String dd = scan.nextLine();
            System.out.println(dd);
            qArr[i]=dd;
        }

        Arrays.stream(qArr).forEach(each->{
            String[] s = each.split(" ");
            int lineIndex = Integer.parseInt(s[0]);
            int itemIndex = Integer.parseInt(s[1]);

            if(lineIndex<numList.size()){
            String[] line = numList.get(lineIndex-1);

                if(line!=null&& itemIndex<line.length) {
                    int numberFound = Integer.parseInt(line[itemIndex]);
                    System.out.println(numberFound);
                }else{
                    System.out.println("ERROR!");
                }
            }else{
                System.out.println("ERROR!");
            }

        });


        scan.close();
    }


    public void findNumber(){

    }

}
