package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Algo11652 {

    static int N;

    static StringBuilder sb = new StringBuilder();
    static ArrayList<long[]> arr = new ArrayList<>();
    static HashMap<Long, Integer> count = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i =0; i<N ;i++) {
            long num = Long.parseLong(br.readLine());
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for(Long key : count.keySet()) {
            arr.add(new long[]{key, count.get(key)});
        }

        Collections.sort(arr, (o1, o2) -> {
            if(o1[1]==o2[1]) {
                return Long.compare(o1[0],o2[0]);
            }
            return Long.compare(o2[1], o1[1]);
        });

        System.out.println(arr.get(0)[0]);
    }
}
