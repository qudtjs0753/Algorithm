package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo10866 {
    static int N, back=0, front=0, size=0;
    static int[] deque= new int[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if(input.equals("push_back")){
                push_back(Integer.parseInt(st.nextToken()));
            }else if(input.equals("push_front")){
                push_front(Integer.parseInt(st.nextToken()));
            }else if(input.equals("pop_front")){
                sb.append(pop_front()).append("\n");
            }else if(input.equals("pop_back")){
                sb.append(pop_back()).append("\n");
            }else if(input.equals("size")){
                sb.append(size()).append("\n");
            }else if(input.equals("empty")){
                sb.append(empty()).append("\n");
            }else if(input.equals("front")){
                sb.append(front()).append("\n");
            }else{
                sb.append(back()).append("\n");
            }
        }

        System.out.println(sb);
    }


    static void push_front(int val) {
        deque[front] = val;
        front = (front - 1 + 10000) % 10000;
        size++;
    }

    static void push_back(int val) {

        back = (back + 1) % 10000;
        size++;
        deque[back] = val;
    }

    static int pop_front() {
        if (size == 0) {
            return -1;
        }

        int ret = deque[(front + 1) % 10000];
        front = (front + 1) % 10000;
        size--;
        return ret;
    }

    static int pop_back() {
        if (size == 0) {
            return -1;
        }
        int ret = deque[back];
        back = (back - 1 + 10000) % 10000;
        size--;
        return ret;
    }

    static int size() {
        return size;
    }

    static int empty() {
        if(size == 0) {
            return 1;
        }
        return 0;
    }

    static int front() {
        if(size == 0) {
            return -1;
        }
        return deque[(front + 1) % 10000];
    }

    static int back() {
        if(size == 0) {
            return -1;
        }
        return deque[back];
    }
}
