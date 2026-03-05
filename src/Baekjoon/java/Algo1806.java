package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1806 {
    static int N, S;
    static final int MAX_LENGTH = 100000000;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = findMinLength();
        if(result>MAX_LENGTH) System.out.println(0);
        else System.out.println(result);
    }
    public static int findMinLength(){
        int start = 0, end = 0, minLength = MAX_LENGTH+1;
        int sum = 0;
        while(true){
            //이 조건을 먼저 안하면 틀렸음.
            //이유? -> end 증가해서 마지막에 도달했을 때의 합까지 확인시켜줘야하니까.
            if(sum>=S) {
                minLength = Math.min(minLength, end-start);
                sum -= arr[start++];
            }else if(end>=N)break;
            else {
                sum += arr[end++];
            }
        }
        return minLength;
    }
}
