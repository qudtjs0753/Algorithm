package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo13144 {

    static int N;
    static int[] arr;
    static int [] visit = new int[100001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
             arr[i] = Integer.parseInt(st.nextToken());
        }

        int end = -1;
        long result = 0;
        for(int start = 0; start<N; start++) {
            while( end+1<N && visit[arr[end+1]]==0) {
                end++;
                visit[arr[end]]++;
            }

            result += (end - start + 1);
            visit[arr[start]]--;
        }

        System.out.println(result);
    }
}
