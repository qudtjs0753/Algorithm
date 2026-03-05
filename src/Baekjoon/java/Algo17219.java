package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo17219 {
    static int N,M;
    static Map<String, String> sites = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            sites.put(st.nextToken(), st.nextToken());
        }

        for(int i=0; i<M; i++){
            sb.append(sites.get(br.readLine())).append("\n");
        }

        System.out.print(sb);
    }
}
