package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo9466 {
    static int T,N, count;
    static int[] arr;
    static boolean[] cycleChecked, visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-->0){
            N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            cycleChecked = new boolean[N+1];
            visit = new boolean[N+1];

            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=1; i<=N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=N; i++){
                if(!visit[i])
                   findCycle(i);
            }

            sb.append(N-count).append("\n");
        }

        System.out.println(sb);
    }

    private static void findCycle(int startIdx) {
        List<Integer> path = new ArrayList<>();
        int current = startIdx;

        while (true) {
            visit[current] = true;
            path.add(current);
            int next = arr[current];

            if(cycleChecked[next])break;

            if(visit[next] && !cycleChecked[next]){
                int cyclePath = arr[next];

                while(cyclePath!=next){
                    count++;
                    cyclePath = arr[cyclePath];
                }
                count++;
                break;
            }
            current = next;
        }

        for(int i=0; i<path.size(); i++)
            cycleChecked[path.get(i)] = true;

    }
}
