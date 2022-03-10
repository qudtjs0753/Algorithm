package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo22857 {
    static int N,K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        int oddCount = 0, evenCount=0;
        int max = 0;
        while(true){
            //끝부분 이동.
            while(end < arr.length && oddCount<=K){
                if(arr[end]%2==1){
                    oddCount++;
                }else{
                    evenCount++;
                    max = Math.max(evenCount, max);
                }
                end++;
            }

            while(start < arr.length){
                if(arr[start]%2==1){
                    oddCount--;
                    start++;
                    break;
                }else{
                    evenCount--;
                    start++;
                }
            }

            if(start==arr.length && end==arr.length)break;
        }

        System.out.println(max);
    }
}
