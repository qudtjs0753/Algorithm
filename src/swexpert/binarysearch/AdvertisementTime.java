package swexpert.binarysearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AdvertisementTime {

    static int N, L;
    static int result = 0;
    static int[] sum;
    static int[][] time;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            L = Integer.parseInt(br.readLine()); //광고 진행 시간.
            N = Integer.parseInt(br.readLine()); //피크타임 수.
            sum = new int[N + 1]; //누적합을 저장한다.
            time = new int[N + 1][2]; //각 피크타임별 시작시간, 종료시간을 저장한다.
            result = 0;
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine()); 
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + e - s;
                time[i][0] = s;
                time[i][1] = e;
            }

            for (int i = 1; i <= N; i++) {
                binarySearch(i);
            }

            sb.append("#").append(testCase).append(" ").append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }

    private static void binarySearch(int start) {
        int lo = start, hi = N + 1;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (!(L >= time[mid][0] - time[start][0])) { //hi를 upperbound로 설정해준다. -> 즉, lo가 lowerbound가 됨.
                hi = mid;
            } else {
                lo = mid;
            }
        }

        int comp = sum[lo] - sum[start - 1]; //선택한 구간에서 겹치는 최대 시간.

        //끝점에서 시작점을 뺀 길이가 L보다 크거나 같을 때.
        if (L >= time[lo][1] - time[start][0]) {
            result = Math.max(result, comp);
            return;
        }
        result = Math.max(result, comp - (time[lo][1] - (L + time[start][0]))); //L보다 클때는 그 차이만큼 빼주어야 한다.
    }
}
