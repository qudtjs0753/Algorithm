package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo25206 {


    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        double divisor = 0;
        double dividend = 0;
        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if("P".equals(grade)) continue;
            dividend += credit * getGradeAsDouble(grade);
            divisor += credit;
        }

        System.out.println(((int)((dividend/divisor)*1_000_000))/1_000_000.0);
    }

    private static double getGradeAsDouble(String grade) {
        if("A+".equals(grade)) {
            return 4.5;
        }

        if("A0".equals(grade)) {
            return 4.0;
        }

        if("B+".equals(grade)) {
            return 3.5;
        }

        if("B0".equals(grade)) {
            return 3.0;
        }

        if("C+".equals(grade)) {
            return 2.5;
        }

        if("C0".equals(grade)) {
            return 2.0;
        }

        if("D+".equals(grade)) {
            return 1.5;
        }

        if("D0".equals(grade)) {
            return 1.0;
        }

        return 0;
    }
}
