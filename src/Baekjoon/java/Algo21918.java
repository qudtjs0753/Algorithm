package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo21918 {
    static int N,M;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int input = Integer.parseInt(st.nextToken());
            if(input==1)
                arr[i] = true;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            checkCommand(command, num1, num2);
        }
        for(int i=1; i<=N; i++){
            if(arr[i])sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }

        System.out.println(sb);
    }

    private static void checkCommand(int command, int num1, int num2){
        if(command==1){
            if(num2==0){
                arr[num1] = false;
            }else{
                arr[num1] = true;
            }
        }else if(command==2){
            for(int i=num1; i<=num2; i++){
                arr[i] = !arr[i];
            }
        }else if(command==3){
            for(int i=num1; i<=num2; i++){
                arr[i] = false;
            }
        }else if(command==4){
            for(int i=num1; i<=num2; i++){
                arr[i] = true;
            }
        }
    }
}
