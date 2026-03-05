package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo2628 {

    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] arr= new ArrayList[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width= Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int cnt = Integer.parseInt(br.readLine());
        arr[0] = new ArrayList<>();
        arr[0].add(0); arr[0].add(height);
        arr[1] = new ArrayList<>();
        arr[1].add(0); arr[1].add(width);

        for(int i=0; i<cnt; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<2; i++) {
            Collections.sort(arr[i]);
        }
        int max = 0;
        for(int i=0; i<arr[0].size()-1; i++) {
            for(int j=0; j<arr[1].size()-1; j++) {
                int row = arr[0].get(i+1) - arr[0].get(i);
                int col = arr[1].get(j+1) - arr[1].get(j);
                max = Math.max(row*col, max);
            }
        }

        System.out.println(max);
    }
}
