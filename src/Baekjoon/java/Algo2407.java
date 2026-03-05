package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2407 {
    static BigInteger[][] memo;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        memo = new BigInteger[101][101];
        for(int i=0; i<=100; i++){
            for(int j=0; j<=100; j++){
                if(i==j || j==0)
                    memo[i][j] = new BigInteger("1");
                else
                    memo[i][j] = new BigInteger("0");
            }
        }
        memoization(N,M);
        System.out.println(memo[N][M]);
    }

    private static BigInteger memoization(int n, int m){
        if(n<0 || m<0) return BigInteger.ZERO;
        if(memo[n][m].equals(BigInteger.ZERO)){
            return memo[n][m] = memoization(n-1,m).add(memoization(n-1,m-1));
        }else{
            return memo[n][m];
        }
    }
}
