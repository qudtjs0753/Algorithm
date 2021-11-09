package College;

import java.io.*;
import java.util.StringTokenizer;

public class Knapsack {
    static int n;
    static int w;
    static int[][] thing = new int[101][2];
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        dp = new int[n+1][w+1];
        for(int i=1; i<=n; i++){
            StringTokenizer input = new StringTokenizer(br.readLine(), " ");
            thing[i][0] = Integer.parseInt(input.nextToken());
            thing[i][1] = Integer.parseInt(input.nextToken());
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<w+1; j++){
                if(thing[i][1]>j)dp[i][j] = dp[i-1][j];
                else{
                    dp[i][j] = Math.max(dp[i-1][j-thing[i][1]] + thing[i][0], dp[i-1][j]);
                }
            }
        }
        bw.write(String.valueOf(dp[n][w]));
        bw.flush();
        bw.close();
    }
}
