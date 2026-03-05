//package Baekjoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.math.BigInteger;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    private static final int KARATSUBA_THRESHOLD = 80;
//    static String A, B;
//    static int[] aArr, bArr;
//    static int[] result;
//
//    public static void main(String[] args) throws IOException {
//        init();
//        solve();
//    }
//
//    private static void solve() {
//        result = multiply(aArr,bArr);
//    }
//
//    private static int[] multiply(int[] numberA, int[] numberB) {
//        if(numberA.length<KARATSUBA_THRESHOLD && numberB.length<KARATSUBA_THRESHOLD) {
//            if(numberA.length==1) {
//                return numberB;
//            }
//
//            if(numberB.length==1) {
//                return numberA;
//            }
//
//            return multiplyWithLen(numberA, numberB);
//        }
//
//        return karatsuba(numberA, numberB);
//    }
//
//    private static int[] karatsuba(int[] tempA, int[] tempB) {
//        int half = (Math.max(tempA.length, tempB.length)+1)/2;
//
//        // xl and yl are the lower halves of x and y respectively,
//        // xh and yh are the upper halves.
//        int[] aLow = getLower(tempA, half);
//        int[] aHigh = getUpper(tempA, half);
//        int[] bLow = getLower(tempB, half);
//        int[] bHigh = getUpper(tempB, half);
//
//        int[] p1 = multiply(aHigh, bHigh);  // p1 = xh*yh
//        int[] p2 = multiply(aLow, bLow);  // p2 = xl*yl
//
//        // p3=(xh+xl)*(yh+yl)
//        int[] p3 = multiply(add(aLow, aHigh), add(aHigh, bLow));
//
//        // result = p1 * 2^(32*2*half) + (p3 - p1 - p2) * 2^(32*half) + p2
//
//
//    }
//
//    private static int[] add(int[] aHigh, int[] bLow) {
//        return new int[0];
//    }
//
//    private static int[] multiplyWithLen(int[] numberA, int[] numberB) {
//    }
//
//    private static int[] getLower(int[] number, int half) {
//        if(number.length<=half) {
//            return number;
//        }
//
//        int lowerInts[] = new int[number.length-half];
//        System.arraycopy(number,number.length-half,lowerInts, 0, half);
//        return lowerInts;
//    }
//
//    private static int[] getUpper(int[] number, int half) {
//        if(number.length<=half) {
//            return new int[]{0};
//        }
//
//        int length = number.length-half;
//
//        int[] higherInts = new int[length];
//        System.arraycopy(number,0 ,higherInts, 0, length);
//        return higherInts;
//    }
//
//    private static void init() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = null;
//        st = new StringTokenizer(br.readLine());
//        A = st.nextToken();
//        aArr = new int[A.length()];
//        bArr = new int[A.length()];
//        for (int i = 0; i < A.length(); i++) {
//            aArr[i] = A.charAt(i)-'0';
//        }
//        B = st.nextToken();
//        bArr = new int[B.length()];
//        for (int i = 0; i < B.length(); i++) {
//            bArr[i] = B.charAt(i)-'0';
//        }
//
//        result = new int[300000];
//    }
//}
