package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo2250 {

    static int N, max = 1;
    static int position = 1, maxDepth = 1;
    static int[][] map;
    static ArrayList<Integer>[] positionOfDepth;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        System.out.println(maxDepth + " " + max);

    }

    private static void solve() {
        //1. depth 체크
        for(int i=1; i<=N; i++) {
            if(parents[i]==i) {
                dfs(i, 1);
                break;
            }
        }

        //2. 계산
        checkMaximumWidth();
    }

    private static void checkMaximumWidth() {
        for (int i = 1; i <= N; i++) {
            if(positionOfDepth[i].size()<=1) continue;
            Collections.sort(positionOfDepth[i]);
            int v1 = positionOfDepth[i].get(0);
            int v2 = positionOfDepth[i].get(positionOfDepth[i].size()-1);
            if(v2-v1+1 > max) {
                max = v2 - v1 + 1;
                maxDepth = i;
            }
        }
    }

    private static void dfs(int root, int rootDepth) {
        dfsIfChildExist(root, rootDepth, 0);
        addDepth(rootDepth);
        dfsIfChildExist(root, rootDepth, 1);
    }

    private static void dfsIfChildExist(int root, int rootDepth, int child) {
        if (map[root][child] != -1) {
            dfs(map[root][child], rootDepth + 1);
        }
    }

    private static void addDepth(int rootDepth) {
        positionOfDepth[rootDepth].add(position);
        position++;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][2];
        positionOfDepth = new ArrayList[N + 1];
        parents = new int[N+1];
        for(int i=1; i<=N; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < N + 1; i++) positionOfDepth[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int root = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            map[root][0] = left;
            map[root][1] = right;
            if(left!=-1) {
                parents[left] = root;
            }
            if(right!=-1) {
                parents[right] = root;
            }
        }
    }
}
