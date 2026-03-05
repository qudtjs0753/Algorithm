package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Algo11053 {
    static int N;
    static int[] input = new int[1000];
    static int maxindex = 0;
    static int maxcount = 1;
    static int[] dp = new int[1000];
    public static void find_smaller(int num,int count){
        for(int i=0; i<count; i++){
            //끊긴 시점의 num보다 작은 숫자에서
            // 1을 더한 값이 그 시점에서 연속된 값.
            if(num<input[i])continue;
            if(num>input[i]) {
                dp[count] = Math.max(dp[count], dp[i]+1);
            }
            else if(num == input[i]){
                dp[count] = Math.max(dp[count], dp[i]);
            }
        }
    }
    public static int find_longest(int n){
        for(int i=0; i<n; i++){
            if(input[maxindex] < input[i]){
                dp[i] = dp[maxindex]+1;
                maxcount = dp[i];
                maxindex = i;
            }else if(input[maxindex] > input[i]) {
                find_smaller(input[i], i);
                if(maxcount <= dp[i]){
                    maxcount = dp[i];
                    maxindex = i;
                }
            }else {
                dp[i] = dp[maxindex];
            }
        }

        return maxcount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            input[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        bw.write(String.valueOf(find_longest(N)));
        bw.flush();
        bw.close();
    }
}
