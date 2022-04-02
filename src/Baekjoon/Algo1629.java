package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1629 {
    static long A,B,C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(divideHalf(B));
    }

    private static long divideHalf(long exp){

        if(exp ==1)
            return A%C;

        long tmp = divideHalf(exp/2);

        if(exp%2==1)
            return ((tmp*tmp%C)*A)%C;

        return (tmp*tmp)%C;
    }
}
