package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @Author: kbs
 */
public class Algo2374 {
    static int N;
    static Stack<Integer> st = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        st.push(Integer.parseInt(br.readLine()));
        long result = 0;
        int max = st.peek();

        for(int i=0; i<N-1; i++){
            int num = Integer.parseInt(br.readLine());
            max = Math.max(max, num);

            if(st.peek()< num){
                result+=num - st.pop();
                st.push(num);
            }else if(st.peek() > num){
                st.pop();
                st.push(num);
            }
        }


        result += max-st.pop();


        System.out.println(result);
    }
}
