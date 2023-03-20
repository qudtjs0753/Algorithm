package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EnglishStudy {

    private static final int LAST_DATE = (int) (1e6 + 1);
    static int N, P, result;
    static boolean[] visit;
    static int[] blankCount;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            result = 0;
            blankCount = new int[LAST_DATE + 1];
            visit = new boolean[LAST_DATE + 1];

            int maxStudyDay = 0;
            for (int i = 1; i <= N; i++) {
                int day = Integer.parseInt(st.nextToken());
                visit[day + 1] = true;
                maxStudyDay = Math.max(maxStudyDay, day + 1); //0일부터 시작한다는 것을 고려하지 못해 많이 틀림.
            }
            int count = 0;
            for (int i = 1; i <= LAST_DATE; i++) {
                if (visit[i]) blankCount[i] = count;
                else blankCount[i] = ++count;
            }

            for (int i = 0; i < maxStudyDay; i++) {
                binarySearch(i);
            }
            sb.append("#").append(testCase).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    /**
     * 이분탐색에서 중요한 것은 문제를 뒤집는 것.
     * 공부를 한날의 수 주어지고 한 날짜 주어진다.
     * 뒤집는 방법은?
     * 주어진 날짜의 최대값을 활용하여 이분탐색을 한다.
     * 시작날짜를 마지막날짜 - p까지 잡는다.
     * <p>
     * 만약 왼쪽의 공백 날짜들이 p보다 작거나 같으면 일단 추가.
     * 이후 오른쪽에서 공백이 나머지와 같아질때까지 쭉 줄인다.
     * 11100000000100101011
     *
     */

    private static void binarySearch(int start) {
        int lo = start, hi = LAST_DATE + 1;
        int dayCount = 0;
        int p = P;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            int blank = blankCount[mid] - blankCount[lo];
            if (!(p < blank)) {
                dayCount += mid - lo;
                lo = mid;
                p -= blank;
            } else {
                hi = mid;
            }
        }
        //+1해주는 이유. hi가 lo + 1까지이고, hi는 p가 허용할 수 있는 최대 날짜까지 이동하기 때문에(lower bound).
        result = Math.max(result, dayCount);
    }

}
