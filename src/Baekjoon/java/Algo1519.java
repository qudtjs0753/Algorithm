package Baekjoon;

import java.io.*;
import java.util.*;
public class Algo1519 {


    static int[] memo;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
    }

    private static void solve(String n) {
        memo = new int[Integer.parseInt(n)+1];
        Arrays.fill(memo, -1);
        Set<Integer> numSet = new TreeSet<>();
        createNumber(n, numSet);

        for(int number : numSet) {
            if(memoization(Integer.parseInt(n) - number)==0) {
                System.out.println(number);
                return;
            }
        }
        System.out.println(-1);
    }

    private static int memoization(int number) {
        if(memo[number]!=-1) return memo[number];
        if(number<10) {
            return memo[number]=0;
        }

        Set<Integer> numSet = new HashSet<>();

        createNumber(Integer.toString(number), numSet);

        for(int next : numSet) {
            if(memoization(number - next)==0) {
                return memo[number]=1;
            }
        }
        return memo[number]=0;
    }

    private static void createNumber(String n, Set<Integer> numSet) {
        StringBuilder numberGenerator = new StringBuilder();

        for(int i = 0; i< n.length()-1; i++) {
            numberGenerator.append(n.charAt(i));
            numSet.add(Integer.parseInt(numberGenerator.toString()));
        }

        for(int i = 1; i< n.length(); i++) {
            numberGenerator = new StringBuilder();
            for(int j = i; j< n.length(); j++) {
                numberGenerator.append(n.charAt(j));
                numSet.add(Integer.parseInt(numberGenerator.toString()));
            }
        }
        numSet.remove(0);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solve(br.readLine());
    }
}
