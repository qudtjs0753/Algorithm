package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo28278 {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        MyStack stack = new MyStack();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            stack.operate(command, st);
        }

        System.out.println(sb);
    }


    static class MyStack {

        private int point = 0;
        private int[] arr = new int[1_000_000];

        void push(int input) {
            arr[point++] = input;
        }

        void pop() {
            if (point == 0) {
                sb.append(-1).append("\n");
                return;
            }
            sb.append(arr[--point]).append("\n");
        }

        void size() {
            sb.append(point).append("\n");
        }

        void isEmpty() {
            if (point == 0) {
                sb.append(1).append("\n");
                return;
            }
            sb.append(0).append("\n");
        }

        void peek() {
            if (point == 0) {
                sb.append(-1).append("\n");
                return;
            }
            sb.append(arr[point-1]).append("\n");
        }

        public void operate(int command, StringTokenizer st) {
            if (command == 1) {
                int value = Integer.parseInt(st.nextToken());
                push(value);
                return;
            }

            if (command == 2) {
                pop();
                return;
            }

            if (command == 3) {
                size();
                return;
            }

            if (command == 4) {
                isEmpty();
                return;
            }

            peek();
        }
    }
}
