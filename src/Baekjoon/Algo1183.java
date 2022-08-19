package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1183 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int promise = Integer.parseInt(st.nextToken());
            int arrive = Integer.parseInt(st.nextToken());
            arr[i] = promise-arrive;
        }

        Arrays.sort(arr);

        if(N%2==1){
            System.out.println(1);
        }else{
            System.out.println(arr[N/2]-arr[N/2-1] + 1);
        }
    }
}
