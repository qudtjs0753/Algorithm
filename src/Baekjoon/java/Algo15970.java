package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo15970 {

    static int N,result = 0;
    static ArrayList<Integer>[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            arr[v2].add(v1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(arr[i]);
        }

        for(int i=1; i<=N; i++) {
            if(arr[i].size()!=0) {
                addDist(i);
            }
        }

        System.out.println(result);
    }

    private static void addDist(int color) {
        result += arr[color].get(1) - arr[color].get(0);
        result += arr[color].get(arr[color].size()-1) - arr[color].get(arr[color].size()-2);

        for(int i=1; i<arr[color].size()-1; i++) {
            int left = arr[color].get(i) - arr[color].get(i-1);
            int right = arr[color].get(i+1) - arr[color].get(i);
            result += Math.min(left, right);
        }
    }
}
