package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo11728 {
    static int[] arrA, arrB;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arrA = new int[N];
        arrB = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        int idxA=0, idxB=0;
        while(idxA<N && idxB<M){
            if(arrA[idxA] < arrB[idxB]) {
                sb.append(arrA[idxA++]).append(" ");
                continue;
            }

            sb.append(arrB[idxB++]).append(" ");
        }

        while(idxB<M) {
            sb.append(arrB[idxB++]).append(" ");
        }

        while(idxA<N) {
            sb.append(arrA[idxA++]).append(" ");
        }

        System.out.println(sb);
    }
}
