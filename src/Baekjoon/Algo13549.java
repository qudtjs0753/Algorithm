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
    static int N,K;
    static int[] memo;
    static boolean[] visited;
    static Queue<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        memo = new int[200_001];
        visited = new boolean[200_001];

        visited[N] = true;
        bfs();
        System.out.println(memo[K]);
    }

    private static void bfs() {
        q.add(2*N);
        visited[2*N]=true;
        if(!visited[N+1]){
            q.add(N+1);
            visited[N+1] = true;
            memo[N+1] = 1;
        }
        if(N-1>=0){
            q.add(N-1);
            visited[N-1] = true;
            memo[N-1] = 1;
        }

        while(!q.isEmpty()){
            int currentIdx = q.poll();

            if(currentIdx==K)continue;
            int backwardIdx = currentIdx-1;
            int forwardIdx = currentIdx+1;
            int teleportIdx = 2*currentIdx;
            if(teleportIdx<=200_000){
                if(visited[teleportIdx] && memo[currentIdx]<memo[teleportIdx]){
                    q.add(teleportIdx);
                    memo[teleportIdx] = memo[currentIdx];
                }else if(!visited[teleportIdx]){
                    q.add(teleportIdx);
                    memo[teleportIdx] = memo[currentIdx];
                    visited[teleportIdx] = true;
                }
            }
            if(forwardIdx<=200_000){
                if(visited[forwardIdx] && memo[currentIdx]+1<memo[forwardIdx]){
                    q.add(forwardIdx);
                    memo[forwardIdx] = memo[currentIdx]+1;
                }else if(!visited[forwardIdx]){
                    q.add(forwardIdx);
                    memo[forwardIdx] = memo[currentIdx] + 1;
                    visited[forwardIdx] = true;
                }
            }
            if(backwardIdx>=0){
                if(visited[backwardIdx] && memo[currentIdx]+1<memo[backwardIdx]){
                    q.add(backwardIdx);
                    memo[backwardIdx] = memo[currentIdx]+1;
                }else if(!visited[backwardIdx]){
                    q.add(backwardIdx);
                    memo[backwardIdx] = memo[currentIdx] + 1;
                    visited[backwardIdx] = true;
                }
            }
        }
    }
}
