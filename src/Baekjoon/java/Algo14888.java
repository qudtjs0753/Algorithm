package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo14888 {
    static int[] arr, oper;
    static int N;
    static int max= -1 * Integer.MAX_VALUE;
    static int min=Integer.MAX_VALUE;

    public static void findExtreme(int count,int result){
        if(count==N-1){
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        if(oper[0]>0){
            oper[0]--;
            findExtreme(count+1, result+arr[count+1]);
            oper[0]++;
        }
        if(oper[1]>0){
            oper[1]--;
            findExtreme(count+1, result-arr[count+1]);
            oper[1]++;
        }
        if(oper[2]>0){
            oper[2]--;
            findExtreme(count+1, result*arr[count+1]);
            oper[2]++;
        }
        if(oper[3]>0){
            oper[3]--;
            findExtreme(count+1, result/arr[count+1]);
            oper[3]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        oper = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<4; i++){
            oper[i] = Integer.parseInt(st.nextToken());
        }
        findExtreme(0, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }
}
