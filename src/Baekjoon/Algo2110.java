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
    public static int findMaximumDistance(int left, int right){
        int mid = (right+left)/2;
        int count = 0;
        int mark = house[0];

        if(right<left)return right;
        else{
            for(int i=1; i<N;i++){
                if(house[i]-mark>=mid){
                    count++;
                    mark = house[i];
                }
            }
            if(count>=C-1)return findMaximumDistance(mid+1, right);
            else return findMaximumDistance(left, mid-1);
        }
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
        int min_length = house[N-1];
        System.out.println(findMaximumDistance( 0, min_length));
    }
}
