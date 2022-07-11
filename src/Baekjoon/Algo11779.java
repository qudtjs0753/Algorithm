package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo11779 {
    static int n,m,start,end, count=0;
    static final long MAX_VALUE = 100_000_000_000L;
    static ArrayList<int[]>[] map;
    static ArrayList<Integer> result = new ArrayList<>();
    static int[] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new ArrayList[n+1];
        path = new int[n+1];

        for (int i = 0; i <= n; i++) map[i] = new ArrayList<>();

        StringTokenizer st;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            map[v1].add(new int[]{v2, dist});
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        System.out.println(dajikstra());

        int point = end;
        while(point!=0){
            result.add(point);
            count++;
            point = path[point];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=result.size()-1; i>=0; i--){
            sb.append(result.get(i)).append(" ");
        }
        System.out.println(count);
        System.out.println(sb);
    }

    private static long dajikstra() {
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        long[] dist = new long[n+1];
        Arrays.fill(dist, MAX_VALUE);
        dist[start] = 0;
        pq.add(new long[]{start, 0});

        while (!pq.isEmpty()) {
            long[] current = pq.poll();

            if(current[1] > dist[(int) current[0]])continue;

            for(int[] next : map[(int)current[0]]){
                long cumDist = current[1] + next[1];

                if(cumDist<dist[next[0]]){
                    dist[next[0]] = cumDist;
                    path[next[0]] = (int)current[0];
                    pq.add(new long[]{next[0],cumDist});
                }
            }
        }

        return dist[end];
    }
}
