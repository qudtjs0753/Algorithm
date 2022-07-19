package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2170 {
    static int N;
    static Line[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Line[N];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new Line(start, end);
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o.start));
        int start = arr[0].start, end = arr[0].end;
        int total = end-start;
        for(int i=1; i<N; i++){
            int curX = arr[i].start, curY = arr[i].end;

            if(curX>end){
                start = curX;
                end = curY;
                total+=end-start;
            }else {
                if(curY>end){
                    total += curY-end;
                    end = curY;
                }
            }
        }

        System.out.println(total);
    }

    private static class Line {
        int start, end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
