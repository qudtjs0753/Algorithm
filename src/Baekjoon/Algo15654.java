package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo15654 {
    static int N,M;
    static boolean[] existence = new boolean[10001];
    static boolean[] visited = new boolean[10001];
    static ArrayList<Integer> arr = new ArrayList<>();
    static ArrayList<Integer> result = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            int input = Integer.parseInt(st.nextToken());
            if(existence[input])continue;
            existence[input] = true;
            arr.add(input);
        }
        Collections.sort(arr);

        for(int i=0; i<arr.size(); i++){
            result.add(arr.get(i));
            visited[arr.get(i)] = true;
            backTracking(1, i);
            visited[arr.get(i)] = false;
            result.remove(result.size()-1);
        }
        System.out.print(sb);
    }

    private static void backTracking(int depth, int idx) {
        if(depth == M){
            for(int i=0; i<result.size(); i++){
                sb.append(result.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }else{
            for(int i=0; i<arr.size(); i++){
                if(!visited[arr.get(i)]){
                    result.add(arr.get(i));
                    visited[arr.get(i)] = true;
                    backTracking(depth+1, i);
                    visited[arr.get(i)] = false;
                    result.remove(result.size()-1);
                }
            }
        }
    }
}
