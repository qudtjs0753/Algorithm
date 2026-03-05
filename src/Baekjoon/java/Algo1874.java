package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: kbs
 */
public class Algo1874 {
    static int N,num=1,top=1;
    static Boolean result = true;
    static int[] input, stack;
    static List<String> push_pop = new ArrayList<>();
    public static void push(){
        push_pop.add("+");
        stack[top++] = num++;
    }
    public static int pop(){
        push_pop.add("-");
        return stack[top--];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        stack = new int[N+2];
        input = new int[N];
        push();

        for(int i=0; i<N; i++){
            input[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<N; i++){
            if(top<1){
                result = false;
                break;
            }
            while(stack[top-1]<input[i])
                push();
            if(stack[top-1]>input[i]){
                result = false;
                break;
            }
            if(stack[top-1]==input[i])pop();
        }
        if(result) {
            for (int i = 0; i < push_pop.size(); i++) {
                bw.write(push_pop.get(i) + "\n");
            }
        }else{
            bw.write("NO");
        }
        bw.flush();
        bw.close();
    }
}
