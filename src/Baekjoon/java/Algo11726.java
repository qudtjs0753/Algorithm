package Baekjoon;

import java.io.*;

public class Algo11726 {
    static int n;
    static int[] dp = new int[1001];
    public static int divide(int n){
        //n<=2 이면 그냥 arr[n]거 리턴.
        if(n <= 2) return n;
        //만약 dp 배열에 저장이 되어있지 않으면 새로 구해야함.
        if(dp[n]==0) return dp[n] = (divide(n-2) + divide(n-1))%10007;
        //dp가 저장되어있으면 dp 리턴.
        return dp[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dp[1] = 1;
        dp[2] = 2;
        n = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(divide(n)));
        bw.flush();
        bw.close();
    }
}
