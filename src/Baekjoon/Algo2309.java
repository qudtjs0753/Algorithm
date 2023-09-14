package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo2309 {

    static int sum = 0;
    static int[] dwarf = new int[9];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        for(int i=0; i<8; i++) {
            for(int j=i+1; j<9; j++) {
                int result = sum - dwarf[i] - dwarf[j];
                if(result!=100) continue;
                printResult(i,j);
                return;
            }
        }
    }

    private static void printResult(int num1, int num2) {
        for(int i=0; i<9; i++) {
            if(i!=num1 && i!=num2) {
                sb.append(dwarf[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
            sum += dwarf[i];
        }
        Arrays.sort(dwarf);
    }
}
