package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo5430 {
    static int T,N;
    static String opers;
    static boolean isReversed;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            boolean isErrored = false;
            opers = br.readLine();
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            isReversed = false;
            st = new StringTokenizer(br.readLine(), ",[]");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int start = 0, end = N-1;

            for(int i=0; i<opers.length(); i++){
                char oper = opers.charAt(i);
                if(oper=='D'){
                    if(end<start){
                        isErrored = true;
                        break;
                    }
                    if(isReversed)end--;
                    else start++;
                }else if(oper=='R'){
                    isReversed = !isReversed;
                }
            }

            if(isErrored)
                sb.append("error").append("\n");
            else{
                sb.append("[");
                if(end<start);
                else if(isReversed){
                    sb.append(arr[end]);
                    for(int i=end-1; i>=start; i--){
                        sb.append(",").append(arr[i]);
                    }
                }else{
                    sb.append(arr[start]);
                    for(int i=start+1; i<=end; i++){
                        sb.append(",").append(arr[i]);
                    }
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb);
    }
}
