package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo15657 {
    static int N,M;
    static int[] arr;
    static ArrayList<Integer> sequence = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        for(int i=0; i<N; i++){
            sequence.add(arr[i]);
            backTracking(1, i);
            sequence.remove(sequence.size()-1);
        }
        System.out.println(sb);
    }

    private static void backTracking(int depth, int idx) {
        if(depth==M){
            for(int i=0; i<M; i++){
                sb.append(sequence.get(i)).append(" ");
            }
            sb.append("\n");
        }else {
            for(int i=idx; i<N; i++){
                sequence.add(arr[i]);
                backTracking(depth+1, i);
                sequence.remove(sequence.size()-1);
            }
        }
    }


}
