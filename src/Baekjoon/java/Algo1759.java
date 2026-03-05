package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo1759 {
    //dfs
    static int L,C;
    static char[] arr,answer;
    public static void dfsAll(){
        for(int i=0; i<C; i++){
            if(C-i < L-1)break;
            answer[0] = arr[i];
            dfs(i, 0);
        }
    }

    public static void dfs(int minIdx,int dep) {
        if(dep==L-1)checkAnsAndPrint();
        else{
            for(int i = minIdx+1; i<C; i++){
                answer[dep+1] = arr[i];
                dfs(i, dep+1);
            }
        }

    }
    public static void checkAnsAndPrint() {
        int consonant=0, gather=0;
        for(int i=0; i<L; i++){
            if(answer[i]=='a' || answer[i]=='e' ||
                    answer[i]=='i' || answer[i]=='o' || answer[i]=='u')
                    gather++;
            else
                consonant++;
        }
        if(consonant>=2 && gather>=1){
            System.out.println(String.valueOf(answer));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        answer = new char[L];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++){
            char input = st.nextToken().charAt(0);
//            for(int j=0; j<i; j++){
//                if(arr[j]==input)
//
//            }
            arr[i] = input;
        }
        Arrays.sort(arr);
        dfsAll();
    }
}
