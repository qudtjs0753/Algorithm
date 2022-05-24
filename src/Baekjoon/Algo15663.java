package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo15663 {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> arr = new ArrayList<>();
    static int[] numbers;
    static LinkedHashSet<String> result =new LinkedHashSet<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            arr.add(Integer.parseInt(st.nextToken()));

        Collections.sort(arr);

        backTracking(0);

        result.forEach( res -> sb.append(res).append("\n"));
        System.out.println(sb);
    }

    private static void backTracking(int count) {
        if (count == M) {
            StringBuilder sub = new StringBuilder();
            for (int num : numbers)
                sub.append(num).append(' ');
            result.add(sub.toString());

            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i])
                continue;
            visit[i] = true;
            numbers[count] = arr.get(i);
            backTracking(count + 1);
            visit[i] = false;
        }
    }
}
