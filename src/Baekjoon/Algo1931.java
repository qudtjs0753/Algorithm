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
public class Algo1931{
    static int N, count=0, endTime=0;
    static Conf[] arr;
    public static class  Conf{
        int start, end;
        Conf(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public static int greedy(){
        for(int i=0; i<N;i++){
            if(arr[i].start >= endTime){
                endTime = arr[i].end;
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Conf[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new Conf(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr, new Comparator<Conf>() {
            @Override
            public int compare(Conf o1, Conf o2) {
                if(o1.end==o2.end)
                    return o1.start-o2.start;
                return o1.end-o2.end;
            }
        });
        System.out.println(greedy());
    }
}
