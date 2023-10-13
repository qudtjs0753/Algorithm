package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo12101 {

    static int n,k;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> ans = new ArrayList<>();
    static int count;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        //1 ,1 2->2 [3] = 2+ 1, [4] = 3 + 2 + 1
        boolean result = backTracking(n);

        if(result) {
            System.out.println(sb);
        }else {
            System.out.println(-1);
        }
    }

    private static boolean backTracking(int n) {
        if(n<0) return false;
        if(n==0) {
            count++;

            if(count==k) {
                for(int i=0; i<ans.size()-1; i++) {
                   sb.append(ans.get(i)).append("+");
                }
                sb.append(ans.get(ans.size()-1));
                return true;
            }
        }

        for(int i=1; i<=3; i++) {
            ans.add(i);
            if(backTracking(n-i))return true;
            ans.remove(ans.size()-1);
        }
        return false;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
    }
}
