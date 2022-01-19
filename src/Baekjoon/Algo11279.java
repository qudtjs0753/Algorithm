package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @Author: kbs
 */
public class Algo11279 {
    static int N, x;
    static ArrayList<Integer> maxHeap = new ArrayList<>();
    public static void swap(int parent, int current){
        int temp = maxHeap.get(parent);
        maxHeap.set(parent, maxHeap.get(current));
        maxHeap.set(current,temp);
    }
    public static void insert(int num){
        maxHeap.add(num);
        int current = maxHeap.size()-1;
        int parent = current/2;
        while(true){
            if (parent == 0 || maxHeap.get(parent) >= maxHeap.get(current)) {
                break;
            }
            swap(current, parent);

            current = parent;
            parent = current /2;
        }
    }
    public static int pop(){
        if(maxHeap.size()==1){
            return 0;
        }
        int top = maxHeap.get(1);

        maxHeap.set(1, maxHeap.get(maxHeap.size()-1));
        maxHeap.remove(maxHeap.size()-1);

        int currentPos = 1;
        while(true){
            int leftPos = currentPos * 2;
            int rightPos = currentPos * 2 + 1;

            if(leftPos >= maxHeap.size()){
                break;
            }

            int maxValue = maxHeap.get(leftPos);
            int maxPos = leftPos;

            if(rightPos < maxHeap.size() && maxHeap.get(rightPos) > maxValue){
                maxValue = maxHeap.get(rightPos);
                maxPos = rightPos;
            }
            if(maxHeap.get(currentPos)<maxValue){
                swap(currentPos,maxPos);
                currentPos = maxPos;
            }
            else break;
        }

        return top;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maxHeap.add(0);
        for(int i=0; i<N; i++){
           x = Integer.parseInt(br.readLine());
           if(x==0) System.out.println(pop());
           else{
               insert(x);
           }
        }
    }
}
