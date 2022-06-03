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
public class Algo15666 {
    static int N, M;
    static boolean[] numCount = new boolean[10001];
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
            int num = Integer.parseInt(st.nextToken());
            if(!numCount[num]){
                arr.add(num);
                numCount[num] = true;
            }
        }
        Collections.sort(arr);

        for(int i=0; i<arr.size(); i++){
            result.add(arr.get(i));
            dfs(1, i);
            result.remove(result.size()-1);
        }

        System.out.print(sb);
    }

    private static void dfs(int count, int idx) {
        if(count==M){
            for (Integer integer : result) {
                sb.append(integer).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=idx; i<arr.size(); i++){
            int current = arr.get(i);

            result.add(current);
            dfs(count+1, i);
            result.remove(result.size()-1);
        }
    }
}
