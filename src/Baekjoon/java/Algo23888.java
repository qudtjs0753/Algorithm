package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo23888 {

    private static long a,d;
    private static int q;

    private static long maxDivisor = Long.MAX_VALUE;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(sb);
    }

    private static void solve(int type, long start, long end) {
        if(type==1) {
            long result = (end-start+1)*(a+(start-1)*d + a+(end-1)*d)/2;
            sb.append(result).append("\n");
            return;
        }

        if(start==end) {
            sb.append(a +(end-1)*d).append("\n");
            return;
        }
        sb.append(maxDivisor).append("\n");
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(br.readLine());

        maxDivisor = gcd(a, d);

        for(int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            solve(type,start,end);
        }
    }

    private static long gcd(long a, long b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }
}
