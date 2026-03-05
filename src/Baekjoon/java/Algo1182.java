package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
class Algo1182 {
    static int S,N, result=0, sum=0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            sum += arr[i];
            checkSequence(i);
            sum -= arr[i];
        }

        System.out.println(result);
    }

    private static void checkSequence(int idx) {
        if(sum==S)result++;

        for(int i=idx+1; i<N; i++){
            sum+= arr[i];
            checkSequence(i);
            sum -= arr[i];
        }
    }
}
