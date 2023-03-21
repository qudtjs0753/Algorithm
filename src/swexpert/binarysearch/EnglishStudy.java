package swexpert.binarysearch;

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
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

//            inputForBinarySearch1();
            inputForBinarySearch2();

            for (int i = 0; i < N; i++) {
                binarySearch2(i);
            }
            sb.append("#").append(testCase).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static void inputForBinarySearch1() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
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
        result = P + 1;
    }

    private static void inputForBinarySearch2() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        result = 0;
        blankCount = new int[N + 1];

        for (int i = 0; i < N; i++) {
            blankCount[i] = Integer.parseInt(st.nextToken());
        }

        result = P + 1;
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
     */

    private static void binarySearch1(int start) {
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

    /**
     * 2번 방법
     * 시작 날짜를 한정시켜놓고, 인덱스로 접근한다.
     * 시작날짜는 고정됨.
     * 다음 시작 날짜와 비교.
     * 만약 다음 시작날짜까지 p로 커버가 불가능하다?
     * 그러면 여기서 계산 끝내야 함.
     */

    private static void binarySearch2(int start) {
        int lo = start, hi = N - 1;
        int blank;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            blank = (blankCount[mid] - blankCount[start] + 1) - (mid - start + 1);

            if (!(blank <= P)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
                result = Math.max(result, blankCount[mid] + (P - blank) - blankCount[start] + 1);
            }
        }
    }
}
