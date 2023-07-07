package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2671 {

    static String[] sounds = {"100", "1", "01", "0"};
    static String input;
    static boolean result = false;


    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        doDfsIf(0, 0);
        doDfsIf(2, 0);

        if(result) {
            System.out.println("SUBMARINE");
        }else {
            System.out.println("NOISE");
        }
    }

    private static void dfs(int before, int startIdx) {
        if(result) return;

        if (startIdx == input.length() && before!=3 && before!=0) {
            result = true;
            return;
        }

        //이전 것 100인 경우 1 또는 100
        if (before == 0) {
            doDfsIf(1, startIdx);
            doDfsIf(3, startIdx);
        } else if (before == 1) {
            doDfsIf(0, startIdx);
            doDfsIf(1, startIdx);
            doDfsIf(2, startIdx);
        } else if(before==2) {
            doDfsIf(0, startIdx);
            doDfsIf(2, startIdx);
        }else {
            doDfsIf(3, startIdx);
            doDfsIf(1, startIdx);
        }
    }

    private static void doDfsIf(int caseOf, int startIdx) {
        if (startIdx + sounds[caseOf].length() <= input.length() &&
                sounds[caseOf].equals(input.substring(startIdx, startIdx + sounds[caseOf].length()))) {
            dfs(caseOf, startIdx + sounds[caseOf].length());
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
    }
}
