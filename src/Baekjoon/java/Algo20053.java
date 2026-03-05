package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo20053 {
    static int T, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int min = 1_000_001, max = -1_000_001;
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                int num = Integer.parseInt(st.nextToken());

                if(num<min)min = num;
                if(num>max)max = num;
            }
            sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }
}
