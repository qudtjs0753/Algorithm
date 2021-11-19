package College;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DPCoinChange {
    static int[] coin = new int[10];
    static int N,k;
    static int[] dp;
    public static int coinChange(int change){
        for(int i=1; i<=N; i=i+1){
            dp[i] = 10000;
            for(int j=0; j<k; j++)
                if(i>=coin[j] && dp[i-coin[j]] +1 < dp[i])
                    dp[i] = dp[i-coin[j]] + 1;
        }
        return dp[N];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ", ");
        k = st.countTokens();
        for(int i=0; i<k; i++){
            coin[i] = Integer.parseInt(st.nextToken());
        }
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st1.nextToken());
        dp = new int[N+1];
        dp[0] =0;
        System.out.println(coinChange(N));
    }
}
