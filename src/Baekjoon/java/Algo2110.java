package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2110 {
    static int N, C;
    static int[] house;
    public static int findMaximumDistance(int lo, int hi){
        while(lo+1<hi) {
            int mid = (hi+lo)/2;

            if(getDistance(mid)>=C) {
               lo = mid;
            }else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int getDistance(int mid) {
        int current = 0;
        int dist = 0;
        int count = 1;
        for(int i=1; i<N; i++) {
            dist = house[i] - house[current];
            if(dist>=mid) {
                current = i;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        house = new int[N];
        for(int i=0; i<N; i++){
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);
        System.out.println(findMaximumDistance( 1, house[N-1]-house[0] + 1));
    }
}
