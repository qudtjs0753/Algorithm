package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo20922 {
    static int N, K, max=0;
    static int[] arr;
    static int[] count = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = stoi(st.nextToken());
        }

        int start = 0, end = 0;

        for(; end<N; end++){
            count[arr[end]]+=1;
            while(count[arr[end]]>K && start<=end){
                count[arr[start]]--;
                start += 1;
            }
            max = Math.max(max, end-start+1);
        }
        System.out.println(max);
    }

    private static int stoi(String str){
        return Integer.parseInt(str);
    }
}
