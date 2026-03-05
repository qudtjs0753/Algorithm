package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo13549 {
    static int N,K,min=Integer.MAX_VALUE;
    static boolean[] visited;
    static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[200_001];

        bfs();
        System.out.println(min);
    }

    private static void bfs() {
        q.add(new int[]{N,0});
        visited[N] = true;


        while(!q.isEmpty()){
            int[] current = q.poll();
            int currentIdx = current[0];
            int currentTime = current[1];

            if(currentIdx==K)min = Math.min(min, currentTime);
            int backwardIdx = currentIdx-1;
            int forwardIdx = currentIdx+1;
            int teleportIdx = 2*currentIdx;
            if(teleportIdx<=150_000 && !visited[teleportIdx]){
                q.add(new int[]{teleportIdx, currentTime});
                visited[teleportIdx] = true;
            }
            if(backwardIdx>=0 && !visited[backwardIdx]){
                q.add(new int[]{backwardIdx, currentTime+1});
                visited[backwardIdx] = true;
            }
            if(forwardIdx<=100_000 && !visited[forwardIdx]){
                q.add(new int[]{forwardIdx, currentTime+1});
                visited[forwardIdx] = true;
            }

        }
    }
}
