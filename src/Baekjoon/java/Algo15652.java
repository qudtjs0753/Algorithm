package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo15652 {
    static int N,M;
    static ArrayList<Integer> sequence = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++){
            sequence.add(i);
            backTracking(i, 1);
            sequence.remove(sequence.size()-1);
        }

        System.out.print(sb);
    }

    private static void backTracking(int idx,int depth) {
        if(depth==M){
            for(int i=0; i<sequence.size();i++){
                sb.append(sequence.get(i)).append(" ");
            }
            sb.append("\n");
        }else {
            for(int i=idx; i<=N; i++){
                sequence.add(i);
                backTracking(i, depth+1);
                sequence.remove(sequence.size()-1);
            }
        }
    }
}
