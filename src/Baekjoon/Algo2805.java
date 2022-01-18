package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2805 {
    static int N, M, maxHeight;
    static int[] arr;
    public static int binarySearch(){
        int high = maxHeight, low = 0;
        int mid=0;
        while(high>low){
            mid = (high + low)/2;
            long sum = 0;
            for(int i=0; i<N; i++){
                if(arr[i]>mid)sum+=(arr[i]-mid);
            }
            if(sum<M){
                high = mid;
            } else{
                low = mid+1;
            }
        }
        return low-1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(maxHeight<arr[i])maxHeight = arr[i];
        }
        System.out.println(binarySearch());
    }
}
