package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo3584 {

    static int N;
    static int[] parents;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        for(int testCase=1; testCase<=T; testCase++) {
            N = Integer.parseInt(br.readLine());
            parents = new int[N+1];
            for(int i=1; i<=N; i++) {
                parents[i] = i;
            }

            for(int i=0; i<N-1; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                parents[v2] = v1;
            }

            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            HashSet<Integer> path = new HashSet<>();

            while(parents[v1]!=v1) {
                path.add(v1);
                v1 = parents[v1];
            }
            path.add(v1);

            while(true) {
                if(path.contains(v2)) {
                    sb.append(v2).append("\n");
                    break;
                }
                v2 = parents[v2];
            }
        }

        System.out.print(sb);
    }
}
