package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2458 {
    static int[][] tree;
    static int N, M;
    static final int MAX_VALUE = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new int[N+1][N+1];
        for(int i=0; i<=N; i++){
            for(int j=0; j<=N; j++){
                if(i==j)tree[i][j] = 0;
                else{
                    tree[i][j] = MAX_VALUE;
                }
            }
        }


        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int student1 = Integer.parseInt(st.nextToken());
            int student2 = Integer.parseInt(st.nextToken());
            tree[student1][student2] = 1;
        }
        floyd();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(tree[i][j]!=MAX_VALUE){
                    tree[j][i] = tree[i][j];
                }
            }
        }
        System.out.println(findAns());
    }

    private static int findAns() {
        int ret = 0;
        boolean checked;
        for(int i=1; i<=N; i++){
            checked = true;
            for(int j=1; j<=N; j++){
                if(tree[i][j]==MAX_VALUE){
                    checked = false;
                    break;
                }
            }
            if(checked)ret++;
        }
        return ret;
    }

    static void floyd(){
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    tree[i][j] = Math.min(tree[i][k] + tree[k][j], tree[i][j]);
                }
            }
        }
    }

}
