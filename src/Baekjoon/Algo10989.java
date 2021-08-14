package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Algo10989 {
    public static void main(String[] args){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        try{
            int N = Integer.parseInt(input.readLine());
            int arr[] = new int[10001];
            for(int i=0; i<10001; i++){
                arr[i]=0;
            }
            int num = 0;

            for(int i=0; i<N; i++){
                num = Integer.parseInt(input.readLine());
                arr[num] +=1;
            }
            input.close();

            StringBuilder sb = new StringBuilder();

            for(int i=0; i<10001; i++){
                for(int j=0; j<arr[i]; j++){
                    sb.append(i).append('\n');
                }
            }
            System.out.println(sb);

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}