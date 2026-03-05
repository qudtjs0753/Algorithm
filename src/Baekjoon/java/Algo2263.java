package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2263 {
    static int n;
    static int[] inOrder, postOrder, index = new int[100001];
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        inOrder = new int[n];
        postOrder = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
            index[inOrder[i]] = i;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            postOrder[i] = Integer.parseInt(st.nextToken());
        }


        findPreOrder(n-1,  n-1);

        System.out.println(sb);
    }

    private static void findPreOrder(int postOrderIdx,
                                      int inOrderEndIdx) {
        if(postOrderIdx<0 || visited[postOrderIdx])return;
        visited[postOrderIdx]=true;
        sb.append(postOrder[postOrderIdx]).append(" ");
        int rootIdx = index[postOrder[postOrderIdx]];
        int rightChildSize = inOrderEndIdx-rootIdx+1;
        //왼쪽
        findPreOrder(postOrderIdx-rightChildSize, rootIdx-1);
        //오른쪽
        findPreOrder(postOrderIdx-1, inOrderEndIdx);
    }
}
