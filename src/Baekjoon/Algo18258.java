package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo18258 {

    private static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        solve();
    }


    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        MyQueue queue = new MyQueue();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            queue.execute(st);
        }

        System.out.println(sb);
    }

    static class MyQueue {
        int[] arr = new int[2_000_000];
        int front = 0, rear = 0;

        void push(int number) {
            arr[rear++] = number;
        }

        void pop() {
            if (front == rear) {
                sb.append("-1").append("\n");
                return;
            }
            sb.append(arr[front++]).append("\n");
        }

        void front() {
            if (front == rear) {
                sb.append(-1).append("\n");
                return;
            }
            sb.append(arr[front]).append("\n");
        }

        void size() {
            sb.append(rear - front).append("\n");
        }

        void empty() {
            if (rear == front) {
                sb.append(1).append("\n");
                return;
            }
            sb.append(0).append("\n");
        }

        void back() {
            if (rear == front) {
                sb.append(-1).append("\n");
                return;
            }
            sb.append(arr[rear - 1]).append("\n");
        }

        public void execute(StringTokenizer st) {
            String command = st.nextToken();

            if ("push".equals(command)) {
                push(Integer.parseInt(st.nextToken()));
                return;
            }

            if("pop".equals(command)) {
                pop();
                return;
            }

            if("front".equals(command)) {
                front();
                return;
            }

            if ("back".equals(command)) {
                back();
                return;
            }

            if ("empty".equals(command)) {
                empty();
                return;
            }

            if ("size".equals(command)) {
                size();
            }
        }
    }
}
