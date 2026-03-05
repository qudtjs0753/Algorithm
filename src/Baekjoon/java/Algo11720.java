package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo11720 {
    static int N,result=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        for(int i=0;i<N; i++){
            int num = input.charAt(i)-'0';
            result+=num;
        }

        System.out.println(result);
    }
}
