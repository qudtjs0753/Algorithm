package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo1253 {

    static int N, ans = 0;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0; i<N; i++) {
           if(search(i)) {
               ans++;
           }
        }

        System.out.println(ans);
    }

    private static boolean search(int indexForFind) {
        int lo = 0, hi = N-1;

        while(lo<hi) {
            int sum = arr[lo] + arr[hi];

            if(lo==indexForFind) {
                lo++;
            }else if(hi==indexForFind) {
                hi--;
            }else {
                if(sum==arr[indexForFind]) {
                    return true;
                }else if(sum>arr[indexForFind]) {
                    hi--;
                }else {
                    lo++;
                }
            }
        }

        return false;
    }

}
