package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo16139 {

    static int[][] count;
    static boolean[][] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        String str = br.readLine();
        int q = Integer.parseInt(br.readLine());
        count = new int[26][str.length()];
        visit = new boolean[26][str.length()];

        count[str.charAt(0)-'a'][0] = 1;
        visit[str.charAt(0)-'a'][0] = true;

        for(int i=1; i<str.length(); i++) {
            for(int alphabet=0; alphabet<26; alphabet++) {
                count[alphabet][i] = count[alphabet][i-1];
            }
            count[str.charAt(i)-'a'][i] = count[str.charAt(i)-'a'][i-1]+1;
            visit[str.charAt(i)-'a'][i] = true;
        }

        for(int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(
                    check(st.nextToken().charAt(0) - 'a',
                            Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.print(sb);
    }

    private static int check(int num, int start, int end) {
        if(visit[num][start]) {
            return count[num][end]-count[num][start]+1;
        }
        return count[num][end]-count[num][start];
    }
}
