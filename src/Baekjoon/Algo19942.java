package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Algo19942 {

    static int N;
    static int[] limit;
    static int[][] nutrients;
    static ArrayList<Integer> answer = new ArrayList<>();
    static ArrayList<String> answerList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static int minimumCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        Collections.sort(answerList);

        if (answerList.size() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(minimumCost);
            System.out.println(answerList.get(0));
        }
    }

    private static void solve() {
        answer.add(0);
        backTracking(1);
        answer.remove(0);
        backTracking(1);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        limit = new int[4];
        nutrients = new int[N][5];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                nutrients[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void backTracking(int index) {
        if (index == nutrients.length) {
            int[] result = addAll(nutrients);
            if (check(result)) {
                if (minimumCost < result[4]) return;

                if (minimumCost > result[4]) {
                    minimumCost = result[4];
                    answerList = new ArrayList<>();
                }
                createAnswer();
            }
            return;
        }

        answer.add(index);
        backTracking(index + 1);
        answer.remove(answer.size() - 1);
        backTracking(index + 1);
    }

    private static void createAnswer() {
        sb = new StringBuilder();
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i) + 1).append(" ");
        }
        answerList.add(sb.toString());
    }

    private static boolean check(int[] result) {
        for (int i = 0; i < 4; i++) {
            if (result[i] < limit[i]) return false;
        }
        return true;
    }

    private static int[] addAll(int[][] nutrients) {
        int[] added = new int[5];
        for (int i = 0; i < answer.size(); i++) {
            int index = answer.get(i);
            for (int j = 0; j < 5; j++) {
                added[j] += nutrients[index][j];
            }
        }
        return added;
    }
}
