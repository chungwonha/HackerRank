package com.company.chung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfElements = scanner.nextInt();
        LinkedList<String> list = new LinkedList<>();
        String input = scanner.nextLine();
        String input1 = scanner.nextLine();
        String[] elements = input1.split(" ");
        Arrays.stream(elements).forEach(list::add);
        list.stream().forEach(j->System.out.print(j+" "));
        System.out.println("");
        int numCommands = scanner.nextInt();
        String command = scanner.nextLine();
        while(numCommands>0) {
            System.out.println("--> "+numCommands);
            command = scanner.nextLine();
            if(command.equals("Insert")){
                String indexAndNum = scanner.nextLine();
                String[] info = indexAndNum.split(" ");
                list.add(Integer.parseInt(info[0]),info[1]);
            }else if(command.equals("Delete")){
                String indexToRemove = scanner.nextLine();
                list.remove(Integer.parseInt(indexToRemove));
            }
            numCommands--;
        }
        list.stream().forEach(j->System.out.print(j+" "));
        System.out.println("");
    }
}
