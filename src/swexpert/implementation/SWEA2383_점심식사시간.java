package swexpert.implementation;

import java.io.*;
import java.util.*;


public class SWEA2383_점심식사시간 {

    static int N, result;
    static ArrayList<int[]> person, stair;
    static ArrayList<int[]>[] sortedListForStair;
    static ArrayList<Integer> peopleForStair1;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            result = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            person = new ArrayList<>();
            stair = new ArrayList<>();
            peopleForStair1 = new ArrayList<>();
            sortedListForStair = new ArrayList[2];
            for (int i = 0; i < 2; i++) {
                sortedListForStair[i] = new ArrayList<>();
            }
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(st.nextToken());

                    if (num == 1) {
                        person.add(new int[]{i, j});
                        continue;
                    }

                    if (num >= 2) {
                        stair.add(new int[]{i, j, num});
                    }
                }
            }

            //combination으로 선택
            comb(0);
            sb.append("#").append(testCase).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static void comb(int depth) {
        if (depth == person.size()) {
            checkMinimum();
            return;
        }

        peopleForStair1.add(depth);
        comb(depth + 1);
        peopleForStair1.remove(peopleForStair1.size() - 1);
        comb(depth + 1);
    }

    private static void checkMinimum() {
        //초기화
        init();
        // 각 stair 별로 시간 뽑는다.
        int time = Math.max(checkTime(0), checkTime( 1));
        // 최소값과 비교한다.
        result = Math.min(time, result);
    }

    private static void init() {
        sortedListForStair[0] = new ArrayList<>();
        sortedListForStair[1] = new ArrayList<>();
        for (int i = 0; i < person.size(); i++) {
            if (!peopleForStair1.contains(i)) {
                sortedListForStair[1].add(person.get(i));
            }else {
                sortedListForStair[0].add(person.get(i));
            }
        }

        Collections.sort(sortedListForStair[0], (o1, o2) -> {
            int dist1 = getDist(o1, stair.get(0));
            int dist2 = getDist(o2, stair.get(0));
            return dist1 - dist2;
        });
        Collections.sort(sortedListForStair[1], (o1, o2) -> {
            int dist1 = getDist(o1, stair.get(1));
            int dist2 = getDist(o2, stair.get(1));
            return dist1 - dist2;
        });
    }

    //시간 측정.
    private static int checkTime(int stairNum) {
        int idx = 0, time = 0;
        Queue<Integer> q = new ArrayDeque<>(); //내려가는 시작 시간 저장할  queue.

        while (idx !=sortedListForStair[stairNum].size()) {
            time++;
            //먼저 담은 녀석들부터 확인한다.
            int count = q.size();

            //q에 담기전에 빼는것 부터 확인.
            while (count-- > 0) {
                if (time - q.peek() == stair.get(stairNum)[2]) {
                    q.poll();
                }
            }

            //시간체크 + q size 체크해서 들어갈 수 있으면 3개까지 들어간다.
            while (idx < sortedListForStair[stairNum].size() && q.size() < 3 &&
                    time - 1 >= getDist(sortedListForStair[stairNum].get(idx), stair.get(stairNum))) {
                q.add(time);
                idx++;
            }
        }

        while (!q.isEmpty()) {
            time++;
            int count = q.size();
            while (count-- > 0) {
                if (time - q.peek() == stair.get(stairNum)[2]) {
                    q.poll();
                }
            }
        }

        return time;
    }

    private static int getDist(int[] person, int[] stair) {
        return Math.abs(person[0] - stair[0]) + Math.abs(person[1] - stair[1]);
    }
}
