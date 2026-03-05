package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo9489 {

    static int N, K;
    static int[] input;
    static int[] parents;
    static ArrayList<Integer>[] children;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        //그냥 인덱스로 저장하면 되지 않을까?
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            if (N == 0 && K == 0) break;

            parents = new int[N];
            children = new ArrayList[N];
            input = new int[N];
            for (int i = 0; i < N; i++) {
                children[i] = new ArrayList<>();
            }


            int findIdx = 0;
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                input[i] = Integer.parseInt(st.nextToken());
                if (input[i] == K) {
                    findIdx = i;
                }
            }

            createTree();


            int sibling = parents[findIdx];
            if (sibling==-1 || parents[sibling] == -1) {
                sb.append(0).append("\n");
                continue;
            }
            int cnt = 0;
            for (int next : children[parents[sibling]]) {
                if (next == sibling) continue;
                cnt += children[next].size();
            }

            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    private static void createTree() {
        int childIdx = 1;
        int parentIdx = 0;
        parents[parentIdx] = -1;

        if (N >= 2) {
            parents[childIdx] = parentIdx;
            children[parentIdx].add(childIdx);
            childIdx++;
        }

        while (childIdx < N) {
            if (input[childIdx] != input[childIdx - 1] + 1) {
                parentIdx++;
            }
            parents[childIdx] = parentIdx;
            children[parentIdx].add(childIdx);
            childIdx++;
        }
    }
}
