package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo13702 {


    static int N,K;
    static int[] drink;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        max = max+1;
        System.out.println(binarySearch());
    }

    private static long binarySearch() {
        long low = 0, high = max;

        while(low+1<high) {
            long mid = (low+high)/2;

            if(getCountOfDrink(mid)>=K) {
                low = mid;
            }else {
                high = mid;
            }
        }
        return low;
    }

    private static long getCountOfDrink(long mid) {
        long count = 0;
        for(int i=0; i<N; i++) {
            count += drink[i]/mid;
        }

        return count;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        drink = new int[N];
        for(int i=0; i<N; i++) {
            drink[i] = Integer.parseInt(br.readLine());
            max = Math.max(drink[i],max);
        }
    }
}
