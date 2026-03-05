package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * @Author: kbs
 */
public class Algo1992 {
    static int N;
    static char[][] arr;
    public static String QuadTree(int n, int y1, int x1){
        if(n==1)return Character.toString(arr[y1][x1]);

        String str1 = QuadTree(n/2,y1,x1);
        String str2 = QuadTree(n/2,y1,x1 + n/2);
        String str3 = QuadTree(n/2,y1 + n/2,x1);
        String str4 = QuadTree(n/2,y1 + n/2,x1 +n/2);
        String all = "(" + str1 + str2 + str3 + str4 + ")";

        if(str1.equals(str2)&& str2.equals(str3) && str3.equals(str4)&&isCompress(str1)){
            return str1;
        }
        else{
            return  all;
        }
    }
    public static boolean isCompress(String str){
        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i)!=str.charAt(i+1))
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<N; j++)
                arr[i][j] = input.charAt(j);
        }

        System.out.println( QuadTree(N, 0, 0));
    }
}
