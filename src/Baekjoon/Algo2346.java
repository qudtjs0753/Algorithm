package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2346 {
    static class Balloon {
        int index, dist;

        public Balloon(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }
    }
    static int N;
    static Deque<Balloon> balloons = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            balloons.addFirst(new Balloon(i+1, Integer.parseInt(st.nextToken())));
        }

        popBalloon();
        System.out.println(sb);
    }

    private static void popBalloon() {
        Balloon current = balloons.pollLast(); //첫번째

        while(true){
            int dist = current.dist;
            sb.append(current.index).append(" ");

            if(balloons.isEmpty())return;

            if(dist<0){
                while(++dist<0){
                    balloons.addLast( balloons.pollFirst());
                }

                current = balloons.pollFirst();
            }else{
                while(--dist>0){
                    balloons.addFirst(balloons.pollLast());
                }

                current = balloons.pollLast();
            }
        }
    }

}
