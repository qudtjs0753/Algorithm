package swexpert.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ClubManage {

    public static void main(String[] args) throws IOException {
        // 1. 담당이 있음. -> 이건 무조건 1. 아니면 넘긴다.
        // 2. 담당이 아닌 녀석. -> 담당이 만약 다음날 참여하지 않는다면 반드시 한사람은 와야됨. 즉, 0이 되면 안됨.
        Map<Character, Integer> map = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int testCase = 1;

        for(int i=0; i<4; i++) {
            map.put((char)('A'+i), 1 << i);
        }

        while(testCase<=T) {
            String input = br.readLine();
            int[][] memo = new int[input.length()][16];
            int duty = map.get(input.charAt(0));
            for(int i=1; i<16; i++) {
                if((i&duty)==0 || (i & 1)==0) continue;
                memo[0][i] = 1;
            }

            for(int i=1; i<input.length(); i++) {
                //이전것과 현재 상태를 비교
                int currentDuty = map.get(input.charAt(i));

                for(int j=1; j<16; j++) {
                    for(int k=1; k<16; k++) {
                        if((k&currentDuty)==0 || (memo[i-1][j]==0 || (j&k)==0))continue;
                        memo[i][k] = (memo[i][k] + memo[i-1][j])%1_000_000_007;
                    }
                }
            }

            int ans = 0;
            for(int i=1; i<16; i++) {
                ans = (ans + memo[input.length()-1][i])%1_000_000_007;
            }

            sb.append("#").append(testCase).append(" ").append(ans).append("\n");
            testCase++;
        }
        System.out.println(sb);
    }
}



