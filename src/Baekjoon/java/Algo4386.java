package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo4386 {
    static int N;
    static ArrayList<double[]> coordination = new ArrayList<>();

    static boolean[] visit;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            coordination.add(new double[]{
                Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())});
        }


        System.out.println(prim());
    }

    private static double prim() {
        PriorityQueue<double[]> vertex = new PriorityQueue<>(Comparator.comparingDouble(o -> o[2]));
        int count = 1;
        double result = 0;

        visit[0] = true;
        for(int i=1; i<N; i++){
            vertex.add(new double[]{0, i, calDist(coordination.get(0), coordination.get(i))});
        }

        while(count<N){
            double[] current = vertex.poll();
            int next = (int)current[1];
            if(visit[next])continue;
            count++;
            visit[next] = true;
            result += current[2];
            for(int i=0; i<N; i++){
                if(!visit[i]){
                    vertex.add(new double[]{next, i, calDist(coordination.get(next), coordination.get(i))});
                }
            }
        }

        return result;
    }

    private static double calDist(double[] coor1, double[] coor2) {
        return  Math.sqrt((coor1[0]-coor2[0])*(coor1[0]-coor2[0]) + (coor1[1]-coor2[1])*(coor1[1]-coor2[1]));
    }
}
