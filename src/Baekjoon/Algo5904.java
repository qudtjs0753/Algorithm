package Baekjoon;

import java.io.*;

public class Algo5904 {

    static int[] arr = new int[29];
    static char result = 'n';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr[0] = 3;
        for(int i=1; i<=28; i++) {
            arr[i] = arr[i-1]*2 + i+3;
        }

        int startPoint = getStartPoint(N);

        if(arr[startPoint]==N) {
            System.out.println("o");
            return;
        }

        side(startPoint, N);
        System.out.println(result);
    }

    private static void side(int startPoint, int n) {
        if(result!='n') return;

        //조건. 왼쪽, 오른쪽일때 배열값보다 크면 잘못된 구간이므로 버린다.
        if(arr[startPoint]<n) {
            return;
        }

        if(startPoint==0 && n<=3 && n>0) {
            if (n == 1) {
                result = 'm';
            } else {
                result = 'o';
            }
            return;
        }

        side(startPoint-1, n);
        mid(startPoint, n-arr[startPoint-1]);
        side(startPoint-1, n-arr[startPoint-1]-(startPoint+3));
    }

    private static void mid(int startPoint, int n) {
        if(result!='n') return;

        //조건. mid일때 n+3보다 크면 탈출한다.
        if(n>startPoint+3) {
            return;
        }
        if(n==1) {
            result = 'm';
        }else {
            result = 'o';
        }
    }

    private static int getStartPoint(int n) {
        int i=0;
        while(arr[i]<n) {
            i++;
        }

        return i;
    }
}
