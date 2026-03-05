package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @Author: kbs
 */
public class Algo10799 {
    static String parentheses;
    static int result = 0;
    static Stack<Character> st = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        parentheses = br.readLine();

        slice();
        System.out.println(result);
    }

    private static void slice(){
        for(int i=0; i<parentheses.length(); i++){
            char ch = parentheses.charAt(i);
            if(ch=='('){
                st.push('(');
            }else if(ch==')'){
                st.pop();
                if(parentheses.charAt(i-1)=='('){
                    result += st.size();
                }else{
                    result++;
                }
            }
        }
    }
}
