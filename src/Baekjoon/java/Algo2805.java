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
        int high = maxHeight+1, low = 0;

        while(low+1<high) {
            int mid = (high+low)/2;
            long sum = calculateWoodLength(mid);
            if(sum>=M) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private static long calculateWoodLength(long mid) {
        long ret = 0;
        for (int num : arr) {
            if (mid >= num) continue;
            ret += (long) num - mid;
        }
        return ret;
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
