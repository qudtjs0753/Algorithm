package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Author: kbs
 */
public class Algo9935 {
    static String findStr;
    static Stack<Character> st = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        findStr = br.readLine();
        for(int i=0; i<input.length(); i++){
            st.push(input.charAt(i));

            if(st.size() >= findStr.length()){
                boolean isSame = true;
                for(int j=0; j<findStr.length(); j++){
                    char ch1 = st.get(st.size()-findStr.length()+j);
                    char ch2 = findStr.charAt(j);
                    if(ch1 != ch2){
                        isSame = false;
                        break;
                    }
                }
                if(isSame){
                    for(int j=0; j<findStr.length(); j++)
                        st.pop();
                }
            }
        }
        if(st.size()==0){
            System.out.println("FRULA");
        }else{
            while(!st.isEmpty()){
                sb.append(st.pop());
            }
            System.out.println(sb.reverse());
        }
    }



}
