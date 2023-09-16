package Baekjoon;
import java.io.*;
import java.util.*;

public class Algo9007 {

    static int T,N,K;
    static int[][] arr;
    static int[] team1, team2;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                team1[i*N + j] = arr[0][i] + arr[1][j];
                team2[i*N + j] = arr[2][i] + arr[3][j];
            }
        }
        Arrays.sort(team1);
        Arrays.sort(team2);

        int diff = 1_000_000_000;
        int result = 0;
        for(int i=0; i<N*N; i++) {
            int sum = team1[i] + binarySearch(K-team1[i]);

            int abs = Math.abs(K-sum);
            if(abs<diff) {
                diff = abs;
                result = sum;
            }else if(abs==diff) {
                result = Math.min(result, sum);
            }
        }

        sb.append(result).append("\n");
    }

    private static int binarySearch(int key) {
        int left = 0, right = N*N;
        int mid = 0;
        while(left+1<right) {
            mid = (left+right)/2;

            if(team2[mid]<=key) {
                left = mid;
            }else {
                right = mid;
            }
        }
        if(left==N*N-1) {
            return team2[left];
        }

        if(Math.abs(key-team2[left]) <= Math.abs(key-team2[right])) {
            return team2[left];
        }
        return team2[right];
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        T = Integer.parseInt(br.readLine());
        arr = new int[4][1000];
        team1 = new int[1000*1000];
        team2 = new int[1000*1000];

        for(int i = 0; i< T; i++) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            Arrays.fill(team1, Integer.MAX_VALUE);
            Arrays.fill(team2, Integer.MAX_VALUE);
            for(int team=0; team<4; team++) {
                st = new StringTokenizer(br.readLine());
                initMyTeam(team, st);
            }
            solve();
        }
        System.out.println(sb);
    }

    private static void initMyTeam(int team, StringTokenizer st) {
        for(int i=0; i<N; i++) {
            arr[team][i] = Integer.parseInt(st.nextToken());
        }
    }
}
