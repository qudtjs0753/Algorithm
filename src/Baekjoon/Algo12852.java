package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @Author: kbs
 */
public class Algo12852 {
    static int N, count=0;
    static int[] order = new int[1_000_001];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        bfs();

        ArrayList<Integer> result = getPath();
        for(int i=result.size()-1; i>=0; i--){
            sb.append(result.get(i)).append(" ");
        }
        System.out.println(count);
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);

        while (!q.isEmpty()) {
            int current = q.poll();
            if(current==1)return;
            if(current<1)return;
            if(current%3==0){
                int next = current/3;
                q.add(next);
                if(order[next]==0){
                    order[next] = current;
                }
            }
            if(current%2==0){
                int next = current/2;
                q.add(next);
                if(order[next]==0){
                    order[next] = current;
                }
            }

            int next = current-1;
            q.add(next);
            if(order[next]==0){
                order[next] = current;
            }
        }
    }

    private static ArrayList<Integer> getPath() {
        ArrayList<Integer> arr = new ArrayList<>();
        int current = 1;

        while(true){
           arr.add(current);
            if(current==N){
                return arr;
            }
            count++;
            current = order[current];
        }
    }
}
