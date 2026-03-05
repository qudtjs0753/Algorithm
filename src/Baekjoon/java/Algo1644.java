package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @Author: kbs
 */
public class Algo1644 {
    static int N;
    static boolean[] checked;
    static ArrayList<Integer> prime = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        checked = new boolean[N+1];
        for(int i=2; i<=N; i++){
            if(!checked[i])prime.add(i);
        }
    }

}
