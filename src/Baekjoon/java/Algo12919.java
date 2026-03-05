package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Algo12919 {

    private static String s, t;
    private static boolean canMake = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();
        backTracking(true, 0, t.length()-1);
        if(canMake){
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }

    private static void backTracking(boolean isForward, int start, int end) {
        if(end-start+1<s.length() || canMake) return;

        if(end-start+1==s.length()) {
            canMake = isSameString(isForward,start,end);
        }
        if(isForward) {
            if(t.charAt(start)=='B') {
                backTracking(false, start+1, end);
            }
            if(t.charAt(end)=='A') {
                backTracking(true, start, end-1);
            }
        }else {
            if(t.charAt(start)=='A') {
                backTracking(false, start+1, end);
            }
            if(t.charAt(end)=='B') {
                backTracking(true, start, end-1);
            }
        }
    }

    private static boolean isSameString(boolean isForward, int start, int end) {
        if(isForward) {
            for(int i=start; i<=end; i++) {
                if(s.charAt(i-start)!=t.charAt(i)) {
                    return false;
                }
            }
        }else {
            for(int i=end; i>=start; i--) {
                if(s.charAt(end-i)!=t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
