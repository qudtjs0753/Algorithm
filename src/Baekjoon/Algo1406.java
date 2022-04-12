package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1406 {
    static int M;
    static String input;
    static Deque<Character> left = new ArrayDeque<>();
    static Deque<Character> right = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        input = br.readLine();
        for(int i=0; i<input.length();i ++)
            left.push(input.charAt(i));
        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            char oper = st.nextToken().charAt(0);

            if(oper=='P'){
                char newChar = st.nextToken().charAt(0);
                left.push(newChar);
            }else if(oper=='L'){
                if(!left.isEmpty())
                    right.push(left.pop());
            }else if(oper=='D'){
                if(!right.isEmpty())
                    left.push(right.pop());
            }else if(oper=='B') {
                if (!left.isEmpty()) {
                    left.pop();
                }
            }
        }

        while(!left.isEmpty()){
            sb.append(left.pollLast());
        }
        while(!right.isEmpty()){
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}
