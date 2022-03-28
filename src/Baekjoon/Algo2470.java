package Baekjoon;

import java.io.*;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo2470 {
    static int N,min = Integer.MAX_VALUE;
    static int[] arr, ans = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);


        find();

        System.out.println(ans[0] + " " + ans[1]);
    }

    private static void find(){
        int start = 0, end = N-1;

        while(start < end){
            int sum = arr[start] + arr[end];
            if(Math.abs(sum)<min){
                ans[0] = arr[start];
                ans[1] = arr[end];
                min = Math.abs(sum);
            }
            if(sum<0){
                start++;
            }else{
                end--;
            }
        }
    }
}
