package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo15650 {
    static StringBuilder sb = new StringBuilder();
    static int N, M, count = 0;
    static int[] arr, depth;
    static List<Integer> sequence = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        depth = new int[N+1];
        for(int i=0; i<=N; i++){
            arr[i] = i;
        }

        for(int i=1; i<=N; i++){
            sequence.add(i);
            dfs(1);
            sequence.remove(sequence.size() - 1);
        }


        System.out.println(sb);
    }



    private static void dfs(int dep) {
        if(dep==M){
            for(int i=0; i<M; i++){
                sb.append(sequence.get(i)).append(" ");
            }
            sb.append("\n");
        }else {
            int current = sequence.get(sequence.size()-1);
            for(int i=current+1; i<=N; i++){
                    sequence.add(i);
                    dfs(dep+1);
                    sequence.remove(sequence.size()-1);
            }
        }

    }
}
