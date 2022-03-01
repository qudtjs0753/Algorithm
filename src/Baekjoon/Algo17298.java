package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo17298 {

    static int N;
    static Stack<Integer> nums = new Stack<>();
    static Stack<Integer> rightNum = new Stack<>();
    static Stack<Integer> result = new Stack<>();

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums.push(Integer.parseInt(st.nextToken()));
        }



        for(int i=0; i<N; i++){
            int number = nums.pop();

            while(true){
                if(rightNum.isEmpty()){
                    result.push(-1);
                    rightNum.push(number);
                    break;
                }else{
                    if(rightNum.peek()>number){
                        result.push(rightNum.peek());
                        rightNum.push(number);
                        break;
                    }else{
                        rightNum.pop();
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            sb.append(result.pop()).append(" ");
        }

        System.out.println(sb);
    }
}
