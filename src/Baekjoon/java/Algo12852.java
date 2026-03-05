package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author: kbs
 */
public class Algo12852 {
    static int N, count=0;
    static int[] order = new int[1_000_001];
    static boolean[] visit = new boolean[1_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        bfs();

        String result = getPath();
        System.out.println(count);
        System.out.println(result);
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);

        while (!q.isEmpty()) {
            int current = q.poll();
            if(current==N)return;
            if(current*3<=N && !visit[current*3]){
                int next = current*3;
                addNext(q,current,next);

            }
            if(current*2<=N && !visit[current*2]){
                int next = current*2;
                addNext(q,current,next);
            }
            if(current+1<=N && !visit[current+1]){
                int next = current+1;
                addNext(q,current,next);
            }
        }
    }

    private static void addNext(Queue<Integer> q, int current, int next) {
        visit[next] = true;
        q.add(next);
        if(order[next]==0){
            order[next] = current;
        }
    }

    private static String getPath() {
        StringBuilder sb = new StringBuilder();
        int current = N;

        while(true){
            sb.append(current).append(" ");
            if(current==1){
                return sb.toString();
            }
            count++;
            current = order[current];
        }
    }
}
