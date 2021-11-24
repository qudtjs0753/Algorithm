package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo10828 {
    static int N, top=0;
    static int[] arr= new int[10000];
    public static void push(int num){
        arr[top++] = num;
    }
    public static void pop(){
        if(top==0) System.out.println(-1);
        else System.out.println(arr[--top]);
    }
    public static void size(){
        System.out.println(top);
    }
    public static void empty(){
        if(top==0) System.out.println(1);
        else System.out.println(0);
    }
    public static void top(){
        if(top==0) System.out.println(-1);
        else System.out.println(arr[top-1]);
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
        else
            top();

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
