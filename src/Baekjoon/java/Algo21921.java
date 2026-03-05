package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo21921 {
    static int N, X, max=0, sum=0, count=1;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        X= Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());


        for(int i=0; i<X; i++){
            sum += arr[i];
        }
        max = Math.max(sum, max);
        int start = 0,end = X-1;

        for(int i=0; i<N-X; i++){
            sum -= arr[start++];
            sum += arr[++end];

            if(sum>max){
                count = 1;
                max = sum;
            }else if(sum==max){
                count++;
            }
        }

        if(max==0) System.out.println("SAD");
        else{
            System.out.println(max);
            System.out.println(count);
        }

    }
}
