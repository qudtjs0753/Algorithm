package Algospot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Traversal {
    static int C,N;


    public static ArrayList<Integer> slice(ArrayList<Integer>preOrder, int start, int end)
    {
        return new ArrayList<>(preOrder.subList(start, end));
    }
    public static void printPostOrder(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder){

        int nodeSize = preOrder.size();
        if(nodeSize==0) return;

        int root = preOrder.get(0);
        int index = inOrder.indexOf(root);

        //오른쪽 서브트리 크기
        int right = nodeSize - (index+1);

        printPostOrder(slice(preOrder, 1, index+1),slice(inOrder, 0, index));
        printPostOrder(slice(preOrder, index+1, nodeSize), slice(inOrder, index+1, nodeSize));

        System.out.print(root + " ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());
        while(C>0){
            ArrayList<Integer> preOrder = new ArrayList<>();
            ArrayList<Integer> inOrder = new ArrayList<>();
            N = Integer.parseInt(br.readLine());


            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) preOrder.add(Integer.parseInt(st.nextToken()));


            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) inOrder.add(Integer.parseInt(st.nextToken()));


            printPostOrder(preOrder, inOrder);
            C--;
        }

    }
}
