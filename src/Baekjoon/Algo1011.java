package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1011 {
    static int N, x, y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            x= Integer.parseInt(st.nextToken());
            y= Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(countMinimum(y-x)) + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static int countMinimum(int distance) {
        long sum = 0;
        int k=1;
        int count = 0;
        while(true){
            for(int i=0; i<2; i++){
                if(sum>=distance) return count;
                if(sum<distance){
                    sum+=k;
                    count++;
                }
            }
            k++;
        }
    }
}
