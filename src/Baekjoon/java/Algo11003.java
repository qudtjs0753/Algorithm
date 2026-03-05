package Baekjoon;

import java.io.*;
import java.util.*;

/**
 * @Author: kbs
 */
public class Algo11003 {
    static int N,L;
    static Deque<Data> dq = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    static class Data {
        int idx, value;
        Data(int idx, int value){
            this.idx = idx;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());

            //뒤에서부터 담는다.
            //가장 최근에 들어온놈보다 값 크면 의미 없으므로 뒤에서부터 버린다.
            while(!dq.isEmpty() && dq.peekLast().value>arr[i]) dq.pollLast();

            dq.addLast(new Data(i, arr[i]));
            //dq 설정.
            //만약 i - (i-L+1) = L-1의 count만큼 차면 그 다음엔 poll시킨다.
            //poll시키다가 다 찬놈이 아니면 걔로 담는다.
            while(!dq.isEmpty()&&(i- dq.peekFirst().idx)>L-1) dq.pollFirst();

            sb.append(dq.peekFirst().value).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}
