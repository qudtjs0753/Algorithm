package Baekjoon;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Algo1003 {
    //0이 나온 횟수, 1이나온 횟수를 세는 클래스 object 정의.
    public static class Num {
        int zero; int one;
        Num(int zero, int one){
            this.zero = zero;
            this.one = one;
        }
    }
    static Num[] fibo = new Num[41];

    //fibo
    public static Num fibo(int n){
        if(fibo[n].zero!=0 || fibo[n].one!=0)return fibo[n];
        else{
            int one = fibo(n-1).one + fibo(n-2).one;
            int zero = fibo(n-1).zero + fibo(n-2).zero;

            fibo[n].one = one;
            fibo[n].zero =zero;
            return fibo[n];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<41; i++){
            fibo[i] = new Num(0,0);
        }
        fibo[0].zero = 1;
        fibo[1].one = 1;
        Num result = new Num(0,0);
        for(int i=0; i<N; i++){
            int fiboNum = Integer.parseInt(br.readLine());
            result = fibo(fiboNum);
            bw.write(result.zero + " " + result.one + "\n");
            bw.flush();
        }
        bw.close();
    }
}
