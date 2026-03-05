package Baekjoon;

import java.util.*;
import java.io.*;
public class Algo16472 {

    static int N;
    static StringBuilder sb = new StringBuilder();
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String input = br.readLine();
        visit = new int[26];
        int count = 0;
        int right = -1;
        int ans = 0;
        for(int left=0; left<input.length(); left++) {
            while(count<=N && right<input.length()) {
                right++;
                if(right==input.length()) break;
                if(visit[input.charAt(right)-'a']==0) {
                    count++;
                    visit[input.charAt(right)-'a']++;
                }else {
                    visit[input.charAt(right)-'a']++;
                }
            }

            ans = Math.max(right-left, ans);
            visit[input.charAt(left)-'a']--;
            if(visit[input.charAt(left)-'a']==0) {
                count--;
            }
        }

        System.out.println(ans);
    }
}
