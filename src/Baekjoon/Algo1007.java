package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1007 {
    static int T,N,plusCount=0, minusCount=0;
    static int[] visited;
    static Coordination[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while(T-->0){
            N = Integer.parseInt(br.readLine());
            visited = new int[N];
            arr = new Coordination[N];
            plusCount = N/2;
            minusCount = N/2;
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                arr[i] = new Coordination(y, x);
            }
            sb.append(findMinVector(0,0,0)).append("\n");
        }

        System.out.println(sb);
    }

    /*
     벡터의 합이 최소라는 의미

     */
    private static double findMinVector(int idx, long sumY, long sumX) {
        if(idx==N){
            return Math.sqrt(sumY*sumY + sumX*sumX);
        }
        else{
            double result1 = Double.MAX_VALUE, result2 = Double.MAX_VALUE;
            if(plusCount>0){
                plusCount--;
                result1 = findMinVector(idx+1, sumY + arr[idx].y, sumX + arr[idx].x);
                plusCount++;
            }
            if(minusCount>0){
                minusCount--;
                result2 = findMinVector(idx+1, sumY - arr[idx].y, sumX - arr[idx].x);
                minusCount++;
            }

            return Math.min(result1, result2);
        }
    }

    private static class Coordination {
        int y, x;

        public Coordination(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
