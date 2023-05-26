package Baekjoon;
import java.io.*;
import java.util.*;
public class Algo15991 {
    static StringBuilder sb = new StringBuilder();
    static final long MAXIMUM = 1_000_000_009L;
    static final int MAX_COUNT = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] memo = new long[MAX_COUNT+1];
        long[] memoHalf = new long[MAX_COUNT+1];
        memo[1] = 1;
        if(MAX_COUNT>=2) memo[2] = 2;
        if(MAX_COUNT>=3) memo[3] = 4;

        //1. 전처리 작업
        for(int i=4; i<=MAX_COUNT; i++) {
            memo[i] = (memo[i-1] + memo[i-2] + memo[i-3])%MAXIMUM;
        }
        //2. 중간을 기준으로 0, 1, 2, 3 넣는다.
        memoHalf[1] = 1;
        memoHalf[2] = 2;
        memoHalf[3] = 2;
        for(int i=4; i<=MAX_COUNT; i++) {
            for(int sub = 0; sub<=3; sub++) {
                if((i-sub)%2==0) memoHalf[i] = (memoHalf[i]+memo[(i-sub)/2])%MAXIMUM;
            }
        }
        for(int testCase=1; testCase<=T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(memoHalf[N]).append("\n");
        }

        System.out.println(sb);
    }
}
