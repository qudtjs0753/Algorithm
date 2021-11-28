package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo10773 {
    static int N, top=0;
    static int[] arr= new int[100000];
    public static void push(int num){
        arr[top++] = num;
    }
    public static int pop(){
        return arr[--top];
    }
    public static int size(){
        return top;
    }
    public static int top(){
        return arr[top-1];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int input = Integer.parseInt(br.readLine());
            if(input!=0)push(input);
            else pop();
        }
        int sum=0;
        while(top>0){
            sum +=pop();
        }
        System.out.println(sum);
    }
}
