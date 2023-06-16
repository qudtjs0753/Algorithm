package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo1548 {

    static int N;
    static int[] nums;
    static int result = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        if(N<3) {
            System.out.println(N);
            return;
        }
        result = 2;
        Arrays.sort(nums);

        for(int i=0; i<N-2; i++) {
            for(int j=i+1; j<N-1; j++) {
                int sum = nums[i] + nums[j];
                int count = 0;
                int k = j+1;
                while(k<N && sum>nums[k]) {
                    count++;
                    k++;
                }
                result = Math.max(result, count+2);
            }
        }

        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }
}
