package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2473 {
static int N;
static long result = Long.MAX_VALUE;
static long[] arr, last = new long[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[N];
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0; i<N-2; i++){
            findNum(i);
        }

        for(int i=0; i<3; i++){
            System.out.print(last[i] + " ");
        }
    }

    private static void findNum(int idx) {
        int left = idx+1, right = arr.length-1;

        while(left < right){
            long sum = arr[idx] + arr[left] + arr[right];

            if(Math.abs(sum)<result){
                last[0] = arr[idx];
                last[1] = arr[left];
                last[2] = arr[right];
                result = Math.abs(sum);
            }

            if(sum<0){
                left++;
            }else if(sum>0){
                right--;
            }else{
                return;
            }
        }

    }


}
