package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo6064 {
    static int T,M,N,x,y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            //d
            x = Integer.parseInt(st.nextToken())-1;
            y = Integer.parseInt(st.nextToken())-1;

            sb.append(getCalander()).append("\n");
        }
        System.out.println(sb);
    }

    private static int getCalander() {
        for(int i=0; i<N; i++){
            int sum = x + i*M;
            if(sum % N ==y){
                return sum+1;
            }
        }

        return -1;
    }
}
