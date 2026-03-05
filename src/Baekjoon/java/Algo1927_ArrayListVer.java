package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @Author: kbs
 */
public class Algo1927_ArrayListVer {
    static int N, x, last = 1;
    static ArrayList<Integer> minHeap  = new ArrayList<>();
    public static void swap(int parent, int current){
        int temp = minHeap.get(parent);
        minHeap.set(parent, minHeap.get(current));
        minHeap.set(current,temp);
    }
    public static void insert(int num){
        minHeap.add(num);
        int current = minHeap.size()-1;
        int parent = current/2;
        while(true){
            if (parent == 0 || minHeap.get(parent) <= minHeap.get(current)) {
                break;
            }
            swap(current, parent);

            current = parent;
            parent = current /2;
        }
    }
    public static int pop(){
        if(minHeap.size()==1){
            return 0;
        }
        int top = minHeap.get(1);

        minHeap.set(1, minHeap.get(minHeap.size()-1));
        minHeap.remove(minHeap.size()-1);

        int currentPos = 1;
        while(true){
            int leftPos = currentPos * 2;
            int rightPos = currentPos * 2 +1;

            if(leftPos>=minHeap.size()){
                break;
            }

            int minValue = minHeap.get(leftPos);
            int minPos = leftPos;

            if(rightPos < minHeap.size() && minHeap.get(rightPos) < minValue){
                minValue = minHeap.get(rightPos);
                minPos = rightPos;
            }
            if(minHeap.get(currentPos)>minValue){
                swap(currentPos,minPos);
                currentPos = minPos;
            }
            else break;
        }

        return top;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        minHeap.add(0);
        for(int i=0; i<N; i++){
           x = Integer.parseInt(br.readLine());
           if(x==0) System.out.println(pop());
           else{
               insert(x);
           }
        }
    }
}
