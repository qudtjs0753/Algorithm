package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo13702 {

    static int N,K; //N: 주전자 수 K : 인원 수
    static int[] mak;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        mak = new int[N];

        for(int i=0 ;i<N; i++) {
            mak[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(binarySearch());
    }

    //기준점을 어떻게 잡아줘야 하지?
    //
    private static long binarySearch() {
        long lo = -1, hi = (1<<31) -1;
        long max = 0;
        while(lo+1<hi) {
            long mid = (lo+hi)/2;
            long[] result = distributeMak(mid);
            if(result[1]>=K) {
                lo = mid;
                max = Math.max(result[0], max);
            }else {
                hi = mid;
            }
        }

        return lo;
    }

    private static long[] distributeMak(long mid) {
        long sum = 0;
        long count = 0;
        for(int i=0; i<N; i++) {
            long curCount =  mak[i] / mid;
            sum += mid*curCount;
            count += curCount;
        }

        return new long[]{sum ,count};
    }

    /**
     * 주전자의 개수가 사람보다 많을수는 없다
     */
}
