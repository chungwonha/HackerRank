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

class Result {

    /*
     * Complete the 'swapNodes' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY indexes
     *  2. INTEGER_ARRAY queries


        List parent = indexes.get(i)

        Integer left = root.get(0)

        Integer right = root.get(1)
        2->4->8->16
       1->2->(# of -1 of parent Level))->
 1
2 3   p=1 d=1 [1]       [2] [3]
4 -1  p=2 d=2 [2]       [4] [0]
5 -1  p=3 d=2 [3]       [5] [0]
6 -1  p=4 d=3 [4]       [6] [0]
7 8   p=5 d=3 [5]       [7] [8]
-1 9  p=6 d=4 [6]       [0] [9]
-1 -1 p=7 d=4 [7]       [0] [0]
10 11 p=8 d=4 [8]       [10][11]
-1 -1         [9]
-1 -1         [10]
-1 -1         [11]

[0]   1
[1]  2 3   p=1:[0] d=1                                    [1][2]
[2]  4 11  if[1][0]!=-1 p=2 else if[1][1]!=-1 p=3    d=2  [3][4]
[3]  5 12  if[1][1]!=-1 p=3 else if[1] d=2                [5][6]
[4]  6 13  p=4 d=3
     7 8   p=5 d=3
    -1 9  p=6 d=4
-1 -1 p=7 d=4
10 11 p=8 d=4
-1 -1
-1 -1
-1 -1
     */

    static class Node{
        int data;
        Node left;
        Node right;
        int level;

        Node(int d){
            data = d;
        }
        Node(int d,int l){
            data = d;
            level = l;
        }
    }

    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        // Write your code here
        Node root = new Node(1,0);
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        for(int i=0;i<indexes.size();i++){
            int left_i  = indexes.get(i).get(0);
            int right_i = indexes.get(i).get(1);


            Node p = stack.pop();
            Node left = left_i!=-1?new Node(left_i,p.level+1):null;
            Node right = right_i!=-1?new Node(right_i,p.level+1):null;;

            p.left = left;
            p.right= right;
            if(right!=null)stack.push(right);
            if(left!=null)stack.push(left);
        }

        printTree(root);
        return new ArrayList<List<Integer>>();
    }
    /*

    root

    qsize 2
    nextItemCounter
    check if list.get(0).get(0) ==-1
    check if list.get(0).get(1) ==-1




      2 * non-minus one nodes = qsize

        1.
           minusOneCounter
           qsize = 2
           while(!q.isEmpty){
                pnode = q.pop;

               for int i = 0 ;i<

                  lnode = new Node(list.get(0));
                  rnode = new Node(list.get(1));
                  q.add(lnode)
                  q.add(rnode)
                  if(lnode.data==-1) minusOneCounter++
                  if(rnode.data==-1) minusOneCounter++
                  pnode.left = lnode;
                  pnode.right= rnode;

                }
            }

             if node.data != -1
        2. get childnodes
        2. add both nodes in queue
        3. count -1 node
        4.
     */
//    static List<List<Node>> buildBfsTree2(List<List<Integer>> indexes){
//        Queue<Node> queue = new LinkedList<>();
//        Node root = new Node(1);
//        queue.add(root);
//        int childCounter = 0;
//        long childNodesSize = 0;
//        for(int k=0;k<indexes.size();k++){
//            List<Integer> childNodes = indexes.get(k);
////            childNodesSize = childNodes.stream().filter(a->a!=-1).count();
//
//            int qsize = childNodes.size();//int)childNodesSize;
//            ArrayList<Node> currentLevelNodes = new ArrayList<>();
//            System.out.println("qsize: "+qsize);
//            for(int i=0;i<qsize;i++){
//                Integer child = childNodes.get(i);//queue.remove();
//                Node n = new Node(child);
//                currentLevelNodes.add(n);
//
//                for(int j=0;j<2;j++) {
//
//                    if (n.left != null) queue.add(n.left);
//                    if (n.right != null) queue.add(n.right);
//                }
//            }
//            bfsTree.add(currentLevelNodes);
//        }
//        return bfsTree;
//    }

    static List<List<Node>> buildBfsTree(Node root){

        Queue<Node> queue = new LinkedList<>();
        ArrayList<List<Node>> bfsTree = new ArrayList<>();
        if(root==null)return bfsTree;

        queue.add(root);
        while(!queue.isEmpty()){
            int qsize = queue.size();
            ArrayList<Node> currentLevelNodes = new ArrayList<>();
            for(int i=0;i<qsize;i++){
                Node n = queue.remove();
                currentLevelNodes.add(n);
                if(n.left!=null)queue.add(n.left);
                if(n.right!=null)queue.add(n.right);
            }
            bfsTree.add(currentLevelNodes);
        }
        return bfsTree;
    }

    static void printBfsTree(List<List<Node>> bfsTree){
        bfsTree.stream().forEach(p->{
            for(Node n:p){
                System.out.print(n.data+" ");
            }
            System.out.println("");
        });
    }

    static void printTree(Node root){
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node n = stack.pop();
            System.out.print(n.data+" ");
            Node l  = n.left;
            Node r = n.right;
            if(r!=null)stack.push(r);
            if(l!=null)stack.push(l);

        }
    }


}

public class SwapNodes {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> indexes = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                indexes.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<List<Integer>> result = Result.swapNodes(indexes, queries);

        result.stream()
                .map(
                        r -> r.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                )
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

