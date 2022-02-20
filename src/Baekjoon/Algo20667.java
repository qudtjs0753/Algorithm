package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo20667 {
    static int N,M,K;
    static int[][] memoryDp;
    static final int MAX_CPU =1000;
    static final int MAX_PRIORITY=500;
    static final int MIN_VALUE = -10000000;
    static class Chrome {
        int cpu, memory, priority;

        public Chrome(int cpu, int memory, int priority) {
            this.cpu = cpu;
            this.memory = memory;
            this.priority = priority;
        }
    }
    static ArrayList<Chrome> tabs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int cpu = Integer.parseInt(st.nextToken());
            int memory = Integer.parseInt(st.nextToken());
            int priority = Integer.parseInt(st.nextToken());

            tabs.add(new Chrome(cpu, memory, priority));
        }
        System.out.println(findPrioritySum());
    }


    public static int findPrioritySum(){


        //cpu, priority 기준으로 적용시킨다.
        memoryDp = new int[MAX_PRIORITY+1][MAX_CPU+2];
        for(int i=0; i<=MAX_PRIORITY; i++){
                for(int j=0; j<=MAX_CPU+1; j++){
                    memoryDp[i][j] = MIN_VALUE;
                }
        }

        memoryDp[0][0] = 0;
        //점화식
        //dp[i][j+tab.cpu][k+tab.priority] = Math.max(dp[i][j+tab.cpu][k+tab.priority], dp[i-1][j][k] + tab.memory)
        for(int i=0; i<N; i++){
            Chrome tab = tabs.get(i);
            for(int j=MAX_PRIORITY; j>=0; j--){
                for(int k=MAX_CPU+1;k>=0; k--){
                    if(j+tab.priority>MAX_PRIORITY)continue;
                    if(k+tab.cpu <= MAX_CPU){
                        memoryDp[j+tab.priority][k + tab.cpu] =
                                Math.max(memoryDp[j+tab.priority][k+tab.cpu],
                                        memoryDp[j][k] + tab.memory);
                    }
                    if(k+tab.cpu > MAX_CPU){
                        memoryDp[j + tab.priority][MAX_CPU+1] =
                                Math.max(memoryDp[j + tab.priority][MAX_CPU+1],
                                        memoryDp[j][k] + tab.memory);
                    }
                }
            }
        }

        int ans = -1;
        for (int i = 0; i <=MAX_PRIORITY; i++){
            for (int j = M; j <=MAX_CPU+1; j++){
                if (memoryDp[i][j] >= K){
                    if (ans > j || ans == -1){
                        ans = i;
                    }
                }
            }
        }

        return ans;
    }

}
