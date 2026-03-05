package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: kbs
 */
public class Algo15829 {
    static final int PRIME = 1234567891;
    static final int r = 31;
    static int L;
    static String input;

    //H=for(i=0; i<l; i++)a[i] * pow(r,i) %PRIME;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long result = 0;
        L = Integer.parseInt(br.readLine());
        input = br.readLine();
        for(int i=0; i<L; i++){
            int n = input.charAt(i)-'a'+1;
            result += n * pow(i);
        }
        System.out.println(result%PRIME);
    }
    private static long pow(int expo) {
        long result = 1;
        for (int i = 0; i < expo; i++)
            result = (r*result) % PRIME;

        return result;
    }
}
