package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo16928 {
    static int N,M;
    static int[] ladderAndSnake = new int[101], map = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<=100; i++){
            ladderAndSnake[i] = i;
        }

        for(int i=0; i<N+M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            ladderAndSnake[start] = end;
        }

        Arrays.fill(map, -1);
        bfs();

        System.out.println(map[100]);
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        map[1] = 0;

        while(!q.isEmpty()){
            int current = q.poll();

            for(int i=1; i<=6; i++){
                int newPos = current + i;
                if(newPos > 100)continue;

                newPos = ladderAndSnake[newPos];

                if(map[newPos]==-1){
                    q.add(newPos);
                    map[newPos] = map[current] + 1;
                }
            }
        }
    }
}
