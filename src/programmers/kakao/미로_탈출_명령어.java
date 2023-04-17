package programmers.kakao;

public class 미로_탈출_명령어 {
    int endY, endX, K, N, M;
    int[] dx = {1,0,0,-1};
    int[] dy = {0,-1,1,0};
    char[] ch = {'d','l','r','u'};
    StringBuilder result = new StringBuilder();

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        boolean answer = false;
        endX = r;
        endY = c;
        K = k;
        N=n; //x값
        M=m; //y값

        for(int i=0; i<4; i++) {
            if(dfs(1,ch[i], y+dy[i], x + dx[i])) {
                answer = true;
                break;
            }
        }

        if(!answer) return "impossible";

        return result.reverse().toString();
    }

    private boolean dfs(int depth, char movedBefore, int y, int x) {
        /**기저조건
         1. 나간 경우
         2. 남은 거리와 갈 수 있는 횟수의 나머지가 다른 경우 -> 이게 핵심코드
         3. 남은 거리 체크했을 때 k번 이내로 갈 수 없는 경우
         4. K번 이동했을 때 탈출위치에 도달한 경우
         */
        if(isInvalid(y,x)) {
            return false;
        }

        int dist = Math.abs(y-endY) + Math.abs(x-endX);
        int remain = K-depth;
        if(dist%2!=remain%2) {
            return false;
        }

        if(dist>remain) {
            return false;
        }

        if(depth==K) {
            result.append(movedBefore);
            return true;
        }

        //여기서부턴 for문 돈다.
        //만약 결과값이 null이 아니면 movedBefore 붙여서 반환
        for(int i=0; i<4; i++) {
            if(dfs(depth+1, ch[i], y+dy[i], x+dx[i])) {
                result.append(movedBefore);
                return true;
            }
        }
        return false;
    }


    private boolean isInvalid(int y, int x) {
        return (y>M || y<=0 || x>N || x<=0);
    }
}
