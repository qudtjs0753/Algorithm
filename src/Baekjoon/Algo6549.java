package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo6549 {


    /**
     * 높이가 더 높은 것이 나오면 그냥 스택에 추가
     * 높이가 같은 것이 나오면 cnt ++;
     * 높이가 더 낮은 것이 나오면 더 낮거나 같은 것이 나올때까지 계속 뽑는다.
     */

    static StringBuilder sb = new StringBuilder();
    static int[] height;
    static Deque<int[]> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;
            height = new int[N];

            for (int i = 0; i < N; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }
            long maximum = height[0];
            stack.push(new int[]{height[0], 1});

            for (int i = 1; i < N; i++) {
                if (stack.peek()[0] == height[i]) {
                    stack.peek()[1]++;
                } else if (stack.peek()[0] < height[i]) {
                    stack.push(new int[]{height[i], 1});
                } else {
                    int addCnt = 0;
                    /**
                     * 1. 더한다
                     * 2. maximum 체크
                     * 3. 이미 뽑은 녀석이니까 이녀석을 더할 카운트로 설정
                     */
                    while (!stack.isEmpty() && stack.peek()[0] >= height[i]) {
                        int[] current = stack.pop();
                        current[1] += addCnt;
                        maximum = Math.max((long) current[0] * current[1], maximum);
                        //여기 잘못됨.
                        addCnt = current[1];
                    }

                    //만약 다뽑혔다면..?
                    //이전까지 카운트했던 모든 것을 더해야함
                    stack.push(new int[]{height[i], addCnt + 1});
                }
            }

            int addCnt = 0;
            while (!stack.isEmpty()) {
                int[] current = stack.pop();
                current[1] += addCnt;
                maximum = Math.max((long) current[0] * current[1], maximum);
                //여기 잘못됨.
                addCnt = current[1];
            }

            sb.append(maximum).append("\n");
        }
        System.out.println(sb);
    }
}