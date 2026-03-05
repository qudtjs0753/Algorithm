package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */

public class Algo1967 {
    static int n;
    static final int MAX_NODE_NUM = 10001;
    static ArrayList<Node>[] arr = new ArrayList[MAX_NODE_NUM];
    static ArrayList<Integer> diameter = new ArrayList<>();
    static class Node {
        int weight, child;
        Node(int child, int weight){
            this.child = child;
            this.weight = weight;
        }
    }
    public static int findMaxWeight(int index, int weight){
        int size = arr[index].size();
        int ret = 0;
        if(size==0){
            return weight;
        }
        ArrayList<Integer> dia = new ArrayList<>();
        for(int i=0; i<size; i++){
            Node node  = arr[index].get(i);
            int radius = findMaxWeight(node.child, node.weight);
            ret = Math.max(radius, ret);
            dia.add(radius);
        }
        if(dia.size()>=2){
            Collections.sort(dia);
            diameter.add(dia.get(dia.size()-1) + dia.get(dia.size()-2));
        }
        return ret+weight;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<MAX_NODE_NUM; i++) arr[i] = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        while(n>1){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            arr[x].add(new Node(y, z));
            n--;
        }
       int ret = findMaxWeight(1,0);
        Collections.sort(diameter);
        int size = diameter.size();
        if(size==0)
            System.out.print(ret);
        else
            System.out.print(Math.max(ret, diameter.get(size-1)));
    }
}
