package Baekjoon;

import java.io.*;
import java.util.*;

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

        check(startPoint, N, false);
        System.out.println(result);
    }

    private static void check(int startPoint, int n, boolean isMid) {
        if(result!='n') return;

        //조건. 왼쪽, 오른쪽일때 배열값보다 크면 잘못된 구간이므로 버린다.
        if(arr[startPoint]<n && !isMid) {
            return;
        }

        //조건. mid일때 n+3보다 크면 탈출한다.
        if(isMid && n>startPoint+3) {
            return;
        }

        //조건. mid인경우.
        if(isMid) {
            if(n==1) {
                result = 'm';
            }else {
                result = 'o';
            }
            return;
        }

        //조건 3.
        if(startPoint==0 && n<=3 && n>0) {
            if (n == 1) {
                result = 'm';
            } else {
                result = 'o';
            }
            return;
        }

        //1. 왼쪽
        check(startPoint-1, n, false);
        check(startPoint, n-arr[startPoint-1], true);
        check(startPoint-1, n-arr[startPoint-1]-(startPoint+3), false);
    }

    private static int getStartPoint(int n) {
        int i=0;
        while(arr[i]<n) {
            i++;
        }

        return i;
    }
}
