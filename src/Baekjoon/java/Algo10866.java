package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo10866 {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        MyDeque deque = new MyDeque();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            deque.execute(st);
        }

        System.out.println(sb);
    }

    static class MyDeque {

        private static final int MAX_SIZE = 10000;
        int front = 0, rear = MAX_SIZE;
        int size = 0;
        int[] arr = new int[MAX_SIZE + 1];

        void pushFront(int number) {
            arr[front] = number;
            front = (front + 1) % (MAX_SIZE + 1);
            size++;
        }

        void pushBack(int number) {
            arr[rear] = number;
            rear = (MAX_SIZE + rear) % (MAX_SIZE + 1);
            size++;
        }

        void popFront() {
            if (isEmpty()) {
                sb.append(-1).append("\n");
                return;
            }
            front = (((MAX_SIZE + 1) + front - 1) % (MAX_SIZE + 1));
            size--;
            sb.append(arr[front]).append("\n");
        }

        void popBack() {
            if (isEmpty()) {
                sb.append(-1).append("\n");
                return;
            }
            rear = (rear + 1) % (MAX_SIZE + 1);
            size--;
            sb.append(arr[rear]).append("\n");
        }

        void size() {
            sb.append(size).append("\n");
        }

        void empty() {
            if (isEmpty()) {
                sb.append(1).append("\n");
                return;
            }
            sb.append(0).append("\n");
        }

        void front() {
            if (isEmpty()) {
                sb.append(-1).append("\n");
                return;
            }
            sb.append(arr[(((MAX_SIZE + 1) + front - 1) % (MAX_SIZE + 1))]).append("\n");
        }

        void back() {
            if (isEmpty()) {
                sb.append(-1).append("\n");
                return;
            }
            sb.append(arr[(rear + 1) % (MAX_SIZE + 1)]).append("\n");
        }


        private boolean isEmpty() {
            if ((rear + 1) % (MAX_SIZE + 1) == front) {
                return true;
            }
            return false;
        }

        public void execute(StringTokenizer st) {
            String command = st.nextToken();

            if ("push_front".equals(command)) {
                pushFront(Integer.parseInt(st.nextToken()));
                return;
            }

            if ("push_back".equals(command)) {
                pushBack(Integer.parseInt(st.nextToken()));
                return;
            }

            if ("pop_front".equals(command)) {
                popFront();
                return;
            }

            if ("pop_back".equals(command)) {
                popBack();
                return;
            }
            if ("size".equals(command)) {
                size();
                return;
            }
            if ("empty".equals(command)) {
                empty();
                return;
            }
            if ("front".equals(command)) {
                front();
                return;
            }
            back();
        }
    }
}
