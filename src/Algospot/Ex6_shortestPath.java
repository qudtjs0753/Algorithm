package Algospot;
import java.util.List;
public class Ex6_shortestPath {
    final static int INF = 100000000;
    final static int  MAX = 1000;
    static int n; //도시의 수
    double[][] dist = new double[MAX][MAX]; //두 도시간 거리를 저장하는 배열

    //path: 지금까지 만든 경로
    //visited: 각 도시의 방문 여부
    //currentLength: 지금까지 만든 경로의 길이
    //나머지 도시들을 모두 방문하는 경로들 중 가장 짧은 겅싀 길이를 반환한다.
    //시작점을 정해서해도 결과는 동일!
    double shortestPath(List<Integer> path, List<Boolean> visited, double currentLength){
        //기저사례: 모든 도시를 다 방문했을 경우 시작도시로 돌아가서 종료 -> 요기 중요.
        if(path.size() == n) return currentLength + dist[path.get(0)][path.get(path.size()-1)];
        double ret= INF;//매우 큰값으로 초기화
        //다음 방문할 도시를 전부 시도해본다.
        for(int next=0; next<n; next++){
            if(visited.get(next))continue;
            int here = path.get(path.size()-1);
            path.add(next);
            visited.set(next,true);

            //나머지 경로를 재귀 호출을 통해 완성하고 가장 짧은 경로의 길이를 얻는다.
            double cand = shortestPath(path, visited, currentLength+ dist[here][next]);
            ret = Math.min(ret, cand);
            visited.set(next,false);
            path.remove(path.size()-1);
        }
        return ret;
    }
}
