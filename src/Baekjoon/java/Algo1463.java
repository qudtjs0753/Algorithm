package Baekjoon;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Algo1463 {
    static int[] count = new int[1000001];

    public static int make1(int n){
        if(n<2)return 0;
        if(count[n]==0){
            if(n%6==0){
                count[n] = Math.min(Math.min(make1(n/3), make1(n/2)), make1(n-1)) +1;
            }
            else if(n%3==0){
                count[n] = Math.min(make1(n/3), make1(n-1))+1;
            }
            else if(n%2==0){
                count[n] = Math.min(make1(n/2), make1(n-1))+1;
            }else{
                count[n] = make1(n-1)+1;
            }
        }
        return count[n];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        System.out.println(make1(x));
    }
}
