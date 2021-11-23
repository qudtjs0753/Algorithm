package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1920 {
    static int N,M;
    static int[] arr,input;
    public static int binarySearch(int start, int end, int find){
        if(start>end) return 0;
        else{
            int mid = (start+end)/2;
            if(find ==arr[mid]) return 1;
            else if(find>arr[mid])return binarySearch(mid+1, end, find);
            else return binarySearch(start, mid-1, find);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        M = Integer.parseInt(br.readLine());
        input = new int[M];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<M; i++){
            System.out.println(binarySearch(0, N-1, Integer.parseInt(st.nextToken())));
        }
    }
}
