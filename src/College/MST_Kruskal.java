package College;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class MST_Kruskal {
    public static class Coordinate {
        public int x;
        public int y;
        int distance;
        Coordinate(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    static int N, M;
    static Coordinate[] graph = new Coordinate[19800];
    static int[] distance = new int[19800];
    static int[] parent = new int[200];

    public static void swap(int left,int right){
        Coordinate temp = graph[left];
        graph[left] = graph[right];
        graph[right] = temp;
    }
    public static void quick_sort(int low, int high){
        int left = low;
        int right = high;
        Coordinate pivot = graph[(low+high)/2];

        do{
            while(graph[left].distance < pivot.distance)left++;
            while(graph[right].distance > pivot.distance) right--;

            if(left <= right){
                //x에 대해 정렬함과 동시에 y에 대해서도 정렬.
                swap(left, right);
                left++;
                right--;
            }

        }while (left <= right);
        if(low < right) quick_sort(low, right);
        if(high > left) quick_sort(left, high);
    }

    public static int calculateDistance(){
        int ret = 0;
        for(int i=0; i<N; i++){
            ret += distance[i];
        }
        return ret;
    }

    public static int getParent(int x) {
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent[x]);
    }

    public static void unionParent(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    //parent가 동일하면 0을 반환해서 union 못하게 할 것.
    //parent가 동일하지 않으면 1반환.
    public static boolean findParent(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(a==b) return false;
        else return true;
    }

    public static int unionFind(){
        int count = 0;
        int a,b;
        for(int i=0; i<M; i++){
            if(count == N-1) return calculateDistance();
            if(findParent(graph[i].x, graph[i].y)){
                unionParent(graph[i].x, graph[i].y);
                distance[count++] = graph[i].distance;
            }
        }
        return calculateDistance();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0; i<N+1; i++){
            parent[i] = i;
        }
        for(int i=0; i<M; i++){
            StringTokenizer input = new StringTokenizer(br.readLine(), " ");
            graph[i] = new Coordinate(Integer.parseInt(input.nextToken()),Integer.parseInt(input.nextToken()),Integer.parseInt(input.nextToken()));
        }
        quick_sort(0, M-1);

        System.out.println(unionFind());
    }
}
