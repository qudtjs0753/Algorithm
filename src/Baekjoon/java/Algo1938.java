package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo1938 {
    /**
     * 1 : 세워진 기둥 0 : 아무것도 없음 B : 기둥의 각 파트 E : 도착지
     * 
     */
    static int N; //가로세로 크기
    static int[] moveY = { -1, 0, 1, 0 }; //이동방향을 정해줄 배열
    static int[] moveX = { 0, 1, 0, -1 }; //이동방향을 정해줄 배열
    static int[][][] dy = { // 0번째 상태 : 수평 수직, 1번째상태 : 대각
            { { 0, 0, 0 }, { 0, -1, 1 } }, { { 0, -1, 1 }, { 0, -1, 1 } } };
    static int[][][] dx = { // 0번째 상태 : 수평 수직 ,1번째 상태 : 대각
            { { 0, -1, 1 }, { 0, 0, 0 } }, { { 0, -1, 1 }, { 0, 1, -1 } } };
    static int[] rotateY = { -1, -1, -1, 0, 0, 1, 1, 1 }; //회전시키기 위해 체크할 위치 지정
    static int[] rotateX = { -1, 0, 1, -1, 1, -1, 0, 1 }; //회전시키기 위해 체크할 위치 지정
    static int startY, startX, endY, endX; // 시작점과 종료지점에 대한 변수들

    // status:가로세로 이거나 대각인경우를 체크, directionOfCurrent: 현재 시작하는 기둥의 방향. endDirection : 끝나는 지점의 방향
    static int status = -1, directionOfCurrent, endDirection; 
    static boolean isValidDestinationStatus = false; //끝나는 지점의 status가 시작지점과 동일한지 체크
    static char[][] map; //입력받을 map.
    static boolean[][][] visit; // BFS에 활용할 visit

    public static void main(String[] args) throws IOException { // 메인 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 입력을 위한 BufferedReader
        StringBuilder sb = new StringBuilder(); // String 파싱을 위해 StringBuilder 사용

        N = Integer.parseInt(br.readLine()); //N 입력
        map = new char[N][N]; //map 입력 
        visit = new boolean[2][N][N]; //visit 배열 입력

        for (int i = 0; i < N; i++) {
            String input = br.readLine(); //줄별로 입력받고
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j); //각 character map에 삽입
            }
        }

        init(); //초기화.
        
        if (!isValidDestinationStatus) { //만약 시작 기둥의 상태와 끝 지점의 상태가 다르면 체크할 필요도 없이 아웃.
            System.out.print(0); //0 출력하고
            return; //종료
        }

        System.out.print(getResult()); //결과값을 얻고 출력한다.
    }

    private static int getResult() { //결과값을 확인하기 위한 함수로 BFS를 활용했다.
        Queue<int[]> q = new ArrayDeque<>(); //q 선언
        q.add(new int[] { directionOfCurrent, startY, startX,0}); //초기지점 추가
        visit[directionOfCurrent][startY][startX] = true; //visit 추가

        while (!q.isEmpty()) { //BFS 시작.
            int[] current = q.poll(); //현재지점 체크를 위해 뽑는다.
            
            //만약 종료지점과 상태, 위치 모두 동일하면
            if (current[0] == endDirection && current[1] == endY && current[2] == endX) {
                return current[3]; //이동 횟수를 저장하여 반환한다.
            }

            for (int direction = 0; direction < 4; direction++) { //move direction별로 
                int ny = current[1] + moveY[direction];
                int nx = current[2] + moveX[direction];

                if (isInvalidMove(ny, nx, current[0]) || visit[current[0]][ny][nx]) //valid한 move인지를 체크
                    continue;

                q.add(new int[] { current[0], ny, nx, current[3] + 1});
                visit[current[0]][ny][nx] = true;
            }

            // rotate
            if (isInvalidRotate(current[1], current[2]) || visit[(current[0] + 1) % 2][current[1]][current[2]])
                continue;

            q.add(new int[] { (current[0] + 1) % 2, current[1], current[2], current[3]+1});
            visit[(current[0] + 1) % 2][current[1]][current[2]] = true;

        }

        return 0;
    }

    /**
     * 회전이 가능한지 체크하는 메서드
     * @param y
     * @param x
     * @return
     */
    private static boolean isInvalidRotate(int y, int x) {
        for (int i = 0; i < 8; i++) {
            int ny = rotateY[i] + y;
            int nx = rotateX[i] + x;

            if (isInvalid(ny, nx) || map[ny][nx] == '1') {
                return true;
            }
        }

        return false;
    }

    /**
     * 이동방향에 따라 이동이 가능한지 체크할 메서드
     * @param y
     * @param x
     * @param direction
     * @return
     */
    private static boolean isInvalidMove(int y, int x, int direction) {
        for (int i = 0; i < 3; i++) {
            int ny = dy[status][direction][i] + y;
            int nx = dx[status][direction][i] + x;

            if (isInvalid(ny, nx) || map[ny][nx] == '1') {
                return true;
            }
        }
        return false;
    }

    /**
     * 초기화.
     * 우선 시작할 때 기둥의 상태를 체크한다.
     * 이후 종료지점의 상태도 확인한다.
     */
    private static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'B') {
                    if (checkStatus(i, j)) {
                        startY = i;
                        startX = j;
                        checkIsDestinationValidStatus();
                        return;
                    }
                }
            }
        }
    }

    /**
     * map의 각 지점을 방문하면서 확인을 수행하는 메서드
     */
    private static void checkIsDestinationValidStatus() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'E') {
                    checkDestination(i, j);
                }
            }
        }

    }

    /**
     * 종료지점의 status,방향, 좌표값을 체크하는 메서드
     * @param y
     * @param x
     */
    private static void checkDestination(int y, int x) {
        for (int direction = 0; direction < 2; direction++) {
            boolean isValid = true;
            for (int i = 0; i < 3; i++) {
                int ny = dy[status][direction][i] + y;
                int nx = dx[status][direction][i] + x;

                if (isInvalid(ny, nx) || map[ny][nx] != 'E') {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                isValidDestinationStatus = true;
                endDirection = direction;
                endY = y;
                endX = x;
                return;
            }
        }
        return;
    }

    /**
     * 시작점의 상태를 확인하기 위한 메서드
     * @param y
     * @param x
     * @return
     */
    private static boolean checkStatus(int y, int x) {
        for (int st = 0; st < 2; st++) {
            for (int direction = 0; direction < 2; direction++) {
                boolean isValid = true;
                for (int i = 0; i < 3; i++) {
                    int ny = dy[st][direction][i] + y;
                    int nx = dx[st][direction][i] + x;

                    if (isInvalid(ny, nx) || map[ny][nx] != 'B') {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    directionOfCurrent = direction;
                    status = st;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 좌표가 넘어가는지 확인할 메서드
     * @param y
     * @param x
     * @return
     */
    private static boolean isInvalid(int y, int x) {
        return (y < 0 || y >= N || x < 0 || x >= N);
    }
}
