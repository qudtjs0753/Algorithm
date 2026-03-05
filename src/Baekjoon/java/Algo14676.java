package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Algo14676 {

    static int N, M, K;
    static boolean result = true;
    static int[] inDegree;
    static ArrayList<Integer>[] essential;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        /**
         * 건물을 짓는 순서가 정해져 있음.
         * 한 건물은 최대 3개의 건물에만 영향을 미침.
         * 치트키 사용 시 원하는 건물을 마음대로 설치 가능.
         *
         */
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        inDegree = new int[N + 1];
        count = new int[N + 1];
        essential = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            essential[i] = new ArrayList<>(3);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            essential[v1].add(v2);
            inDegree[v2]++;
        }

        for (int i = 0; i < K; i++) {
            if (!result) {
                break;
            }
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int building = Integer.parseInt(st.nextToken());

            if (command == 1) {
                build(building);
            } else {
                destory(building);
            }
        }

        if (result) {
            System.out.println("King-God-Emperor");
        } else {
            System.out.println("Lier!");
        }
    }

    private static void build(int building) {
        if (inDegree[building] != 0) {
            result = false;
            return;
        }
        if (count[building] == 0) {
            for (int child : essential[building]) {
                inDegree[child]--;
            }
        }
        count[building]++;
    }

    private static void destory(int building) {
        if (count[building] < 1) {
            result = false;
            return;
        }
        count[building]--;
        if(count[building]==0) {
            for (int child : essential[building]) {
                inDegree[child]++;
            }
        }
    }
}
