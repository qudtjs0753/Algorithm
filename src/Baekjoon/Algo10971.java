package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo10971 {
    private static int[][] map; // i에서 j까지 가는 거리를 저장한다. 가는 길이와 오는 길이는 다르다.
    private static int[] order; // 방문 순서를 저장할 배열
    private static boolean[] visit; // 방문을 했던 곳인지 체크할 배열
    private static int N,result = Integer.MAX_VALUE; // N: 방문할 위치의 수 , result: 최종 결과


    public static void main(String[] args) throws IOException { //main start
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader로 빠른 입력.
        N = Integer.parseInt(br.readLine()); //N값 입력 받는다.
        map = new int[N][N]; // 벽을 확인할 맵 초기화

        for (int i = 0; i < N; i++) { // 세로 길이만큼.
            StringTokenizer st = new StringTokenizer(br.readLine()); // 공백기준으로 입력받는다.
            for (int j = 0; j < N; j++) { // 가로 길이만큼
                map[i][j] = Integer.parseInt(st.nextToken()); //거리를 저장.
            }
        }

        order = new int[N+1]; // 마지막 돌아갈 위치까지 저장해서 N+1개.
        visit = new boolean[N]; // visit배열 초기화 .

        for(int i=0; i<N; i++) { //N-1번 방문위치까지
            order[0] = i; //0번째 방문장소를 저장하고
            order[N] = i; //첫위치로 돌아올거니 마지막 방문장소도 저장한다.
            visit[i] = true; //이미 선택했음을 체크하고
            sales(1); //다음으로 넘어간다.
            visit[i] = false; //방문을 취소한다.
        }

        System.out.println(result); //최종결과 출력
    }


    /**
     * 그냥 모든 경우의수 하나하나 체크하면서 방문할 메서드
     * @param depth : 현재 순서
     */
    private static void sales(int depth) {
        if(depth==N) { //만약 N번 다 뽑았으면
            findMin(); //최소 길이를 찾으러 간다.
        }

        for(int i=0; i<N; i++) { //0부터 N-1 방문위치까지
            if(visit[i]) continue; //이미 선택한곳이면 넘어가고
            order[depth] = i; // 그렇지않으면 현재 순서에 i를 저장한다.
            visit[i] = true; // 현재 위치에 방문했음을 확인하고
            sales(depth+1); // 다음 위치로 넘어간다.
            visit[i] = false; // visit false
        }
    }


    /**
     * 가장 작은 경우인지 확인하는 메서드
     */
    private static void findMin() {
        int sum = 0; //최종 길이 합산
        for(int i=0; i<N; i++) { // 각 방문지별로
            if(map[order[i]][order[i+1]]==0) { //만약 경로가 없다면
                return; //종료
            }
            sum += map[order[i]][order[i+1]]; //그렇지않으면 더한다.
        }

        result = Math.min(sum, result); // 한바퀴를 다 돌 수 있다면, 최종 결과를 비교
    }
}
