package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo2374 {
    static int N;
    static int minimum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        minimum = Integer.parseInt(br.readLine());
        long result = 0;
        int max = minimum;

        for(int i=0; i<N-1; i++){
            int num = Integer.parseInt(br.readLine());
            max = Math.max(max, num);

            if(minimum< num){
                result+=num - minimum;
                minimum = num;
            }else if(minimum > num){
                minimum = num;
            }
        }


        result += max-minimum;


        System.out.println(result);
    }
}
