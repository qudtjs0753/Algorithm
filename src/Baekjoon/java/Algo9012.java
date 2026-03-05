package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @Author: kbs
 */
public class Algo9012 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            String input = br.readLine();
            if(checkValid(input)){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }

    private static boolean checkValid(String input) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i)=='('){
                st.push(')');
            }else{
                if(st.isEmpty() || st.pop()!=')')return false;
            }
        }

        if(!st.isEmpty())return false;
        return true;
    }
}
