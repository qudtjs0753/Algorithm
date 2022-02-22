package Baekjoon;

import java.io.*;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo2800 {
    static int[] parentheses;
    static StringBuilder input = new StringBuilder();
    static StringBuilder output = new StringBuilder();
    static Stack<Integer> st = new Stack<>();
    static Set<String> result = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input.append(br.readLine());

        parentheses = new int[input.length()];

        int index=1;
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)=='('){
                parentheses[i] = index++;
            }else if(input.charAt(i)==')')
                parentheses[i] = --index;
        }

        findMathematicalEquation(0, "");
        List<String> list = new ArrayList<>(result);
        Collections.sort(list);

        for(int i=1; i<list.size();i++)
            output.append(list.get(i)).append("\n");

        bw.write(output.toString());
        bw.flush();
        bw.close();
    }

    //(가 나올때마다 스택에 visit이 true인지를 쌓는다.
    //)가 나올때마다 스택에서 뽑는다.
    //확인해서 true값이면 sb에 추가하고 false면 그냥 지나간다.

    private static void findMathematicalEquation(int idx, String s){
        if(idx == input.length()) {
            result.add(s);
            return;
        }

        if(input.charAt(idx)=='('){
            st.add(parentheses[idx]);
            findMathematicalEquation(idx+1, s + '(');
            st.pop();
            findMathematicalEquation(idx+1, s);
        }else if(input.charAt(idx)==')'){
            if(!st.isEmpty()&& st.peek() == parentheses[idx]){
                st.pop();
                findMathematicalEquation(idx+1,s + ')');
                st.add(parentheses[idx]);
            }else{
                findMathematicalEquation(idx+1, s);
            }
        }else{
            findMathematicalEquation(idx+1, s + input.charAt(idx));
        }
    }
}
