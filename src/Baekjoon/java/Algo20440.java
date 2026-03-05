package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo20440 {

    static int N, ansStartTime, ansEndTime, ansCount;
    static ArrayList<Mosquito> mosquitos;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {

        ArrayDeque<Integer> in = new ArrayDeque<>(N);
        int frontMax = 0 ;
        for (int i = 0; i < mosquitos.size(); i++) {
            Mosquito current = mosquitos.get(i);

            //들어오는 케이스
            //만약 기록된 최대값보다 크면 start 갱신
            if (current.cnt == 1) {
                in.push(current.time);
                if (frontMax < in.size()) {
                    ansStartTime = current.time;
                    frontMax = in.size();
                }
                continue;
            }

            //나가는 케이스
            //기록된 최대값과 동일하면
            //동일한 경우에는 top의 시간과 비교
            int currentTime = in.pop();

            if ((ansCount == in.size()+1 && currentTime == ansEndTime) || ansCount<in.size()+1) {
                ansEndTime = current.time;
                ansCount = in.size()+1;
            }
        }

        System.out.println(ansCount);
        System.out.println(ansStartTime + " " + ansEndTime);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        mosquitos = new ArrayList<>(2 * N);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());

            mosquitos.add(new Mosquito(t1, 1));
            mosquitos.add(new Mosquito(t2, -1));
        }

        Collections.sort(mosquitos, (o1, o2) -> {
            if (o1.time == o2.time) {
                return o1.cnt - o2.cnt;
            }
            return o1.time - o2.time;
        });
    }

    private static class Mosquito {
        int time;
        int cnt;

        public Mosquito(int time, int cnt) {
            this.time = time;
            this.cnt = cnt;
        }
    }
}
