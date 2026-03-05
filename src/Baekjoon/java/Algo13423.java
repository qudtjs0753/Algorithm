package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo13423 {

    static int T,N;
    static int[] arr;
    static Set<Integer> set = new HashSet<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(sb);
    }

    private static void solve() {
        int result = 0;
        for(int i=0; i<N-2; i++) {
            for(int j=i+2; j<N; j++) {
                if((arr[i] + arr[j])%2==1 || (arr[i]+arr[j])%2==-1)continue;
                int mid = (arr[i] + arr[j])/2;
                if(set.contains(mid)) {
                   result++;
                }
            }
        }

        sb.append(result).append("\n");
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        T = Integer.parseInt(br.readLine());

        for(int testCase = 0; testCase<T; testCase++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            set = new HashSet<>();

            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                set.add(arr[i]);
            }
            Arrays.sort(arr);
            solve();
        }
    }
}
