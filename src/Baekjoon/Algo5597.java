package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo5597 {
    static boolean[] arr = new boolean[31];
    static int[] result = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<28; i++){
            int input = Integer.parseInt(br.readLine());
            arr[input] = true;
        }

        int idx = 0;
        for(int i=1; i<=30; i++){
            if(!arr[i]){
                result[idx] = i;
                idx++;
            }
        }

        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
