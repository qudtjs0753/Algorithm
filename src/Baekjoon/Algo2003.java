package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2003 {
    static int N, M,count=0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0;
        int high = 0;
        int sum = 0;
        while(true) {
            if(sum>=M){
                sum -= arr[low++];
            }
            else if(high>=N)break;
            else{
                sum += arr[high++];
            }
            if (sum == M) count++;
        }
        System.out.println(count);
    }
}
