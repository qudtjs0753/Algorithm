package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo10845 {
    static int N, rear=0, front=0;
    static int[] arr= new int[10000];
    public static void push(int num){
        arr[rear = ((rear+1)%10000)] = num;
    }
    public static void pop(){
        if(rear==front) System.out.println(-1);
        else System.out.println(arr[(front =(front+1)%10000)]);
    }
    public static void size(){
        System.out.println(Math.abs(rear-front));
    }
    public static void empty(){
        if(rear==front) System.out.println(1);
        else System.out.println(0);
    }
    public static void front(){
        if(rear==front) System.out.println(-1);
        else System.out.println(arr[(front+1)%10000]);
    }
    public static void back(){
        if(rear==front) System.out.println(-1);
        else System.out.println(arr[rear]);
    }
    public static void selectCommand(String com){
        StringTokenizer st = new StringTokenizer(com, " ");
        com = st.nextToken();
        if(com.equals("push"))
            push(Integer.parseInt(st.nextToken()));
        else if(com.equals("size"))
            size();
        else if(com.equals("pop"))
            pop();
        else if(com.equals("empty"))
            empty();
        else if(com.equals("front"))
            front();
        else
            back();

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String str = br.readLine();
            selectCommand(str);
        }
    }
}
