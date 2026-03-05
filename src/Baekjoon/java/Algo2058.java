package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo2058 {

    static int N, M;
    static ArrayList<Integer> gamunList = new ArrayList<>();
    static String[] names;
    static int[] inbound;
    static Map<String, Integer> nameToIdx = new HashMap<>();
    static Map<String, ArrayList<String>> childOfName = new HashMap<>();
    static ArrayList<Integer>[] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        init();

        setGamun();

        createMap();

        getAllChild();

        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        map = new ArrayList[N];
        for (int i = 0; i < N; i++) map[i] = new ArrayList<>();
        names = new String[N];
        inbound = new int[N];
        for (int i = 0; i < N; i++) {
            names[i] = st.nextToken();
            childOfName.put(names[i], new ArrayList<>());
        }
        Arrays.sort(names); //사전순 정렬
        for (int i = 0; i < N; i++) {
            nameToIdx.put(names[i], i);
        }
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String parent = st.nextToken();
            inbound[nameToIdx.get(child)]++;
            map[nameToIdx.get(parent)].add(nameToIdx.get(child));
        }
    }

    private static void getAllChild() {
        for (int i = 0; i < N; i++) {
            ArrayList<String> childs = childOfName.get(names[i]);
            Collections.sort(childs);
            sb.append(names[i]).append(" ").append(childs.size()).append(" ");
            for (String name : childs) sb.append(name).append(" ");
            sb.append("\n");
        }
    }

    private static void setGamun() {
        int gamunCount = 0;
        for (int i = 0; i < N; i++) {
            if (inbound[i] == 0) {
                gamunCount++;
                gamunList.add(i);
            }
        }

        sb.append(gamunCount).append("\n");
        for (int i = 0; i < gamunList.size(); i++) {
            sb.append(names[gamunList.get(i)]).append(" ");
        }
        sb.append("\n");
    }

    private static void createMap() {
        Queue<Integer> q = new ArrayDeque<>(1000);
        for (int gamun : gamunList) {
            arrangeGamun(q, gamun);
        }
    }

    private static void arrangeGamun(Queue<Integer> q, int gamun) {
        q.add(gamun);
        while (!q.isEmpty()) {
            int current = q.poll();
            ArrayList<String> childs = childOfName.get(names[current]);
            for (int i = 0; i < map[current].size(); i++) {
                int child = map[current].get(i);
                inbound[child]--;
                if (inbound[child] == 0) {
                    q.add(child);
                    childs.add(names[child]);
                }
            }
        }
    }
}
