package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1026 {
    static int N;
    static int[] a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[N];
        b = new int[N];
        for(int i=0; i<N; i++)
            a[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            b[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(a);
        Arrays.sort(b);

        int result = 0;
        for(int i=0; i<N; i++){
            result += a[i]*b[N-1-i];
        }

        System.out.println(result);
    }
}
