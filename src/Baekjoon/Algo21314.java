package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo21314 {
    static ArrayList<String> max = new ArrayList<>(), min = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 최대
        boolean isK = false;
        StringBuilder sb = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) == 'M') {
                if (isK) {
                    sb.append("0");
                } else {
                    sb.append("1");
                }
            } else {
                max.add(sb.toString());
                sb.setLength(0);
                sb.append("5");
                isK = true;
            }
        }
        max.add(sb.toString());


        sb.setLength(0);
        //최소
        boolean isM = false;
        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) == 'M') {
                if (isM) {
                    sb.append("0");
                } else {
                    isM = true;
                    sb.append("1");
                }
            } else {
                min.add(sb.toString());
                sb.setLength(0);
                min.add("5");
                isM = false;
            }
        }
        min.add(sb.toString());

        StringBuilder result = new StringBuilder();
        for (int i = max.size() - 1; i >= 0; i--) {
            result.append(max.get(i));
        }
        result.append("\n");

        for (int i = min.size() - 1; i >= 0; i--) {
            result.append(min.get(i));
        }

        System.out.println(result);
    }
}
