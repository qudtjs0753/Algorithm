package swexpert.memoization;

import java.io.*;
import java.util.*;

public class 키순서_5643 {
    private static int N, M;
    private static int[][] arr;
    private static int result;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException { // main start
        System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader로 빠른 입력.

        int T = Integer.parseInt(br.readLine());

        for(int testCase=1; testCase<=T; testCase++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            arr = new int[N+1][N+1];

            for(int i=0; i<=N; i++) {
                Arrays.fill(arr[i], 10000);
            }

            for(int i=0; i<=N; i++) {
                arr[i][i] = 0;
            }

            result = 0;
            for(int i=0; i<M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                arr[v1][v2] = 1;
            }

            floyd();
            checkAns();
            sb.append("#").append(testCase).append(" ").append(result).append("\n");
        }

        System.out.println(sb); // 최종결과 출력
    }

    private static void checkAns() {
        for(int i=1; i<=N; i++) {
            int count = 0;
            for(int j=1; j<=N; j++) {
                if(i==j) continue;
                if(arr[i][j]!=10000 || arr[j][i]!=10000) {
                    count++;
                }
            }
            if(count==N-1) {
                result++;
            }
        }
    }

    private static void floyd() {
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
    }
}
