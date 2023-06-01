package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo2015 {

    static int N,K;
    static int[] accSum;
    static Map<Integer, Integer> nums = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        accSum = new int[N+1];

        for(int i=1; i<=N; i++) {
            accSum[i] = accSum[i-1] + Integer.parseInt(st.nextToken());
        }
        long result = 0;

        for(int start=1; start<=N; start++) {
            nums.put(accSum[start-1], nums.getOrDefault(accSum[start-1],0)+1);
            int base = accSum[start];
            int toFind = base-K;
            result += nums.getOrDefault(toFind, 0);
        }

        System.out.println(result);
    }
}
