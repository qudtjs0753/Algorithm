package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2960 {
    static int N, K, count = 0, ans;
    static boolean[] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        checked = new boolean[N+1];
        for(int i=2; i<=N; i++){
            if(checked[i])continue;
            int num = i;
            while(num<=N){
                if(!checked[num]){
                    checked[num] = true;
                    count++;
                }
                if(count==K){
                    ans = num;
                    System.out.println(ans);
                    return;
                }
                num += i;
            }
        }
    }
}
