package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo20364 {

    static int N, Q;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];

        for(int i=0; i<Q; i++) {
            int v = Integer.parseInt(br.readLine());

            int temp = v;
            int firstMeet = v;
            boolean canGo = true;
            while(temp!=1) {
                if(visit[temp]) {
                    canGo = false;
                    firstMeet = temp;
                }
                temp/=2;
            }
            if(canGo) {
                visit[v] = true;
                sb.append(0).append("\n");
            }else {
                sb.append(firstMeet).append("\n");
            }
        }
        System.out.println(sb);
    }
}
