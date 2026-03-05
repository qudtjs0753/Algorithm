package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo1676 {
    static int N, countTwo=0, countFive=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++){
            int number = i;

            while(number%2==0){
                number/=2;
                countTwo++;
            }
            while(number%5==0){
                number/=5;
                countFive++;
            }
        }

        int result = Math.min(countTwo, countFive);
        System.out.println(result);
    }
}
