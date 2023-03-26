package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algo14865 {
    static int N;
    static int noContent, parent;

    static ArrayList<int[]> coordination = new ArrayList<>();
    static ArrayList<int[]> pointForMountain = new ArrayList<>(); //0번인덱스 : x값, 1번인덱스 : 봉우리 선택.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coordination.add(new int[]{y, x});
        }

        //rotate
        int startIdx = compare();

        int count = 0, idx = 0, twoAdder = 0;

        int[] before = coordination.get(startIdx);
        int beforeX = 0;
        while (count++ < N) { //두번째 틀린 부분. 다시 원점까지 돌아가는 것을 해야한다.
            startIdx = (startIdx + 1) % N;
            int[] current = coordination.get(startIdx);

            if ((long) before[0] * current[0] < 0) {
                twoAdder++;
                if (twoAdder % 2 == 0) {
                    pointForMountain.add(new int[]{before[1], beforeX});
                    swap(pointForMountain.get(pointForMountain.size() - 1));
                } else {
                    beforeX = before[1];
                }
            }

            //이전 값을 현재 값에 대입.
            before = current;
        }
        Collections.sort(pointForMountain, Comparator.comparingInt(o -> o[0]));

        checkCount();

        System.out.print(parent + " " + noContent);
    }


    private static void swap(int[] before) {
        if (before[0] > before[1]) {
            int temp = before[0];
            before[0] = before[1];
            before[1] = temp;
        }
    }

    //처음 틀린 부분. compare.
    private static int compare() {
        int idx = 0;
        long minY = coordination.get(0)[0];
        long minX = coordination.get(0)[1];

        for (int i = 1; i < N; i++) {
            int[] current = coordination.get(i);

            //현재 y값이 지금까지 검사한 y보다 작은 경우
            if (minY > current[0]) {
                minY = current[0];
                minX = current[1];
                idx = i;
                continue;
            }

            //Y최소값과 동일한 경우
            if (minY == current[0]) {
                if (minX > current[1]) { //x값이 minX보다 작으면 -> 왼쪽에서 시작해야하니까.
                    minX = current[1];
                    idx = i;
                    continue;
                }
            }
        }

        return idx;
    }

    private static void checkCount() {
        Deque<int[]> st = new ArrayDeque<>();
        //current[0]: x값  current[1]: idx

        for (int[] current : pointForMountain) {
            if (st.isEmpty()) {
                st.addFirst(current);
                parent++;
                continue;
            }

            //포함하지 않는 경우.
            if (current[0] > st.peekFirst()[1]) {
                while (!st.isEmpty() && current[0] > st.peekFirst()[1]) {
                    st.pollFirst();
                }
                noContent++;
            }

            if (st.size() == 0) {
                parent++;
            }
            st.addFirst(current);
        }

        if (st.size() != 0) {
            noContent++;
        }
    }

}
