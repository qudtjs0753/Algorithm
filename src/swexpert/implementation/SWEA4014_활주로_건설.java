package swexpert.implementation;

import java.io.*;
import java.util.*;
public class SWEA4014_활주로_건설 {
    private static int N, X, result=0;
    private static int[][] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException { // main start
        System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader로 빠른 입력.

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            result = 0;
            arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                findRow(i);
                findCol(i);
            }

            sb.append("#").append(testCase).append(" ").append(result).append("\n");
        }

        System.out.println(sb); // 최종결과 출력
    }

    private static void findRow(int startY) {
        int idx = 0;
        int flatCount = 1;

        while(true) {
            if(idx>=N-1) { //끝까지 도달한 경우.
                result++;
                return;
            }
            if(idx<-1) return;

            int sub = arr[startY][idx]-arr[startY][idx+1];

            if(Math.abs(sub)>=2) {
                return;
            }
            if(sub==0) {
                flatCount++;
            }else if(sub==1) {
                idx = checkRow(startY, idx+1);
                flatCount = 0;
            }else if(sub==-1) {
                if(flatCount<X) {
                    return;
                }
                flatCount = 1;
            }
            idx++;
        }
    }

    private static int checkRow(int startY, int startX) {
        if(startX+X-1>=N) return -100;

        for(int i=startX; i<startX+X-1; i++) {
            if(arr[startY][i]!=arr[startY][i+1]) {
                return -100;
            }
        }

        return startX+X-2;
    }

    private static void findCol(int startX) {
        int idx = 0;
        int flatCount = 1;

        while(true) {
            if(idx>=N-1) { //끝까지 도달한 경우.
                result++;
                return;
            }
            if(idx<-1) return;

            int sub = arr[idx][startX]-arr[idx+1][startX];
            if(Math.abs(sub)>=2) {
                return;
            }

            if(sub==0) {
                flatCount++;
            }else if(sub==1) {
                idx = checkCol(idx+1, startX);
                flatCount = 0;
            }else if(sub==-1) {
                if(flatCount<X) {
                    return;
                }
                flatCount = 1;
            }
            idx++;
        }
    }

    private static int checkCol(int startY, int startX) {
        if(startY+X-1>=N) return -100;
        for(int i=startY; i<startY+X-1; i++) {
            if(arr[i][startX]!=arr[i+1][startX]) {
                return -100;
            }
        }
        return startY+X-2;
    }


}
