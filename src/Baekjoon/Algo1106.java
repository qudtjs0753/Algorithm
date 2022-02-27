package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1106 {
    static final int MAX_COST = 1000001;
    static int C, N, minimumCost=MAX_COST;
    static int[] city;
    static int[] memoMaximumPersonPerCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        city = new int[N+1];
        memoMaximumPersonPerCost = new int[MAX_COST];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            dp(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        System.out.println(minimumCost);
    }

    private static void dp(int cost, int perPerson) {
        for(int i=1; i<MAX_COST; i++){
            if(i>=cost){
                memoMaximumPersonPerCost[i] = Math.max(memoMaximumPersonPerCost[i],
                                                        memoMaximumPersonPerCost[i-cost]+ perPerson);
            }

            if(memoMaximumPersonPerCost[i]>=C){
                minimumCost = Math.min(i, minimumCost);
            }
        }
    }
}
