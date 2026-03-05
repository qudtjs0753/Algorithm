package Baekjoon;

import java.io.*;
import java.util.*;

public class Algo3107 {

    static int zerosIdx = -2;
    static String[] arr;
    static ArrayList<String> divided = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        StringBuilder result = new StringBuilder();

        for(int i=0; i<divided.size(); i++) {
            String tempString = divided.get(i);
            if(tempString.equals("")) {
                for(int cnt=0; cnt<9-divided.size(); cnt++) {
                    result.append("0000:");
                }
                continue;
            }
            StringBuilder zeros = new StringBuilder();
            for(int cnt=0; cnt<4-tempString.length(); cnt++) {
                zeros.append("0");
            }
            zeros.append(tempString).append(":");
            result.append(zeros.toString());
        }

        String ans = result.toString();
        if(ans.charAt(ans.length()-1)==':') {
            ans = ans.substring(0, ans.length()-1);
        }
        System.out.println(ans);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();


        //find ::
        for(int i=0; i<input.length()-1; i++) {
            if(input.charAt(i)==':' && input.charAt(i+1)==':') {
                zerosIdx=i;
                break;
            }
        }


        StringBuilder sb = new StringBuilder();
        //divide
        for(int i=0; i<input.length(); i++) {
            if(i==zerosIdx+1) {
                continue;
            }

            if(input.charAt(i)==':') {
                if(sb.toString().length()!=0){
                    divided.add(sb.toString());
                    sb = new StringBuilder();
                }
                if(i==zerosIdx) {
                    divided.add("");
                }
                continue;
            }

            sb.append(input.charAt(i));
        }
        //check
        if(sb.toString().length()!=0) {
            divided.add(sb.toString());
        }
    }
}
