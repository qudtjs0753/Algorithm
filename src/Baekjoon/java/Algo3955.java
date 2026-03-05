package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo3955 {
    static int t;
    static Long A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());
        while(--t >= 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            //A(-x) + By = 1
            A = Long.parseLong(st.nextToken());
            B = Long.parseLong(st.nextToken());

            //해검증
            //D = gcd(A,B);
            //Ax + By = C일때 C % D == 0이어야 해를 가질 수 있다. -> 베주 항등식
            //C%D != 0-> 해가 없음.
            //확장 유클리드 호제법에서 나온 r값이 gcd(A,B)값.
            EGResult tmp = extendedGcd(A, B);
            if(1 != tmp.r) {
                sb.append("IMPOSSIBLE\n");
                continue;
            }

            //초기해 구하기
            // x0 = s * C / D
            // y0 = t * C / D
            long x0 = tmp.s;
            long y0 = tmp.t;

            //일반해 구하기
            // x = x0 + B/D * k
            // y = y0 - A/D * k
            //k의 범위
            //D는 1이므로 생략
            //x < 0이어야 힘.
            //x0 + B * k < 0
            //1) k < - x0 / B


            //0 < y <= 1e9
            //0 < y0 - A * k <= 1e9
            //-y0 < -A * k <= 1e9 - y0
            //2) (y0 - 1e9) / A <= k < yo/ A
            //                     k < -x0 / B
            long kFromY = (long) Math.ceil((double) y0/(double)A)-1;
            long kFromX = (long) Math.ceil((double) -x0/(double)B)-1;
            long k = Math.min(kFromY, kFromX);
            long kLimitFromY = (long)Math.ceil((y0-1e9)/(double)A);

            //5. 만족하는 k가 있는지 찾고 k를 통해 y를 구한다.
            if(kLimitFromY <= k){
                sb.append(y0 - A*k);
                sb.append("\n");
            }else{
                sb.append("IMPOSSIBLE\n");
            }
        }
        System.out.println(sb);
    }
    static EGResult extendedGcd(long a, long b){
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;

        //유클리드 호제법 사용
        //r_i+1 = - q *ri + ri_1
        long temp;
        while(r1 != 0){
            long q = r0 / r1;

            //r
            temp = r0 - q * r1;
            r0 = r1;
            r1 = temp;

            //s(x의 특수해)
            temp = s0 - q * s1;
            s0 = s1;
            s1 = temp;

            //t(y의 특수해)
            temp = t0 - q * t1;
            t0 = t1;
            t1 = temp;
        }
        return new EGResult(s0, t0, r0);
    }
    static class EGResult {
        long s,t,r;

        public EGResult(long s, long t, long r){
            super();
            this.s = s;
            this.t = t;
            this.r = r;
        }
    }
}
