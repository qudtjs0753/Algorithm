package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo11728 {
    static int[] A, B;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        int idxA=0, idxB=0;
        while(true){
            //pointA가 넘은경우, pointB가 넘은 경우.
            if(idxA>=N && idxB>=M)break;

            if(idxA<N && idxB<M){
                if(A[idxA]<=B[idxB]){
                    sb.append(A[idxA++]).append(" ");
                }else{
                    sb.append(B[idxB++]).append(" ");
                }
            }else if(idxA<N){
                while(idxA<N){
                    sb.append(A[idxA++]).append(" ");
                }
                break;
            }else{
                while(idxB<M){
                    sb.append(B[idxB++]).append(" ");
                }
                break;
            }
        }
        System.out.println(sb);
    }
}
