package College;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
public class ClosestPair_FastVer {
    public static class Coordinate {
        public int x;
        public int y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    public static void swap(Coordinate[] arr, int a, int b){
        Coordinate temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void merge(Coordinate[] arr, int left, int mid, int right){
        int i=left;
        int j= mid+1;
        int temp_index=0;

        Coordinate[] temp = new Coordinate[right-left+3];

        //분할한 배열간 크기 비교하고 임시 배열에 저장.
        while(i<=mid&&j<=right){
            if(arr[i].y<arr[j].y){
                temp[temp_index++] = new Coordinate(arr[i].x, arr[i].y);
                i++;
            }else{
                temp[temp_index++] = new Coordinate(arr[j].x, arr[j].y);
                j++;
            }
        }
        //오른쪽 남아있는 값들 다 집어 넣어 준다.
        while(i<=mid){
            temp[temp_index++] = new Coordinate(arr[i].x, arr[i].y);
            i++;
        }
        while(j<=right){
            temp[temp_index++] = new Coordinate(arr[j].x, arr[j].y);
            j++;
        }
        for(int index = left; index<temp_index; index++)arr[index] = temp[index];
    }
    //0이면 x 1 이면 y sort
    public static void quick_sort(Coordinate[] arr, int low, int high){
        int left = low;
        int right = high;
        //x sort

        Coordinate pivot = arr[(low+high)/2];

        do{
            while(arr[left].x < pivot.x)left++;
            while(arr[right].x > pivot.x) right--;
            if(left <= right){
                //x에 대해 정렬함과 동시에 y에 대해서도 정렬.
                swap(arr, left, right);
                left++;
                right--;
            }

        }while (left <= right);

        if(low < right) quick_sort(arr, low, right);
        if(high > left) quick_sort(arr, left, high);
    }

    public static double getDistance(int x1, int x2, int y1, int y2){
        double distanceX = x2 -x1;
        double distanceY = y2 -y1;
        double distance = Math.sqrt(distanceX*distanceX +distanceY*distanceY );
        return distance;
    }

    public static double divide_and_conquer(Coordinate[] sorted_x,  int left, int right){
        if(right-left ==0){
            return Double.MAX_VALUE;
        }
        else if(right-left == 1){
            merge(sorted_x, left, (right+left)/2 , right);
            return getDistance(sorted_x[left].x, sorted_x[right].x,sorted_x[left].y,sorted_x[right].y);
        }
//        else if((right-left) == 2){
//            double minDistance=Double.MAX_VALUE;
//            for(int i=left; i<right; i++){
//                for(int j=i+1; j<=right; j++){
//                    minDistance = Math.min(minDistance, getDistance(sorted_x[i].x, sorted_x[j].x,sorted_x[i].y,sorted_x[j].y));
//                }
//            }
//            return minDistance;
//        }
        //4개 이상 남은 경우
        int mid = (left+right)/2;
        double leftSmallest = divide_and_conquer(sorted_x,left,mid);
        double rightSmallest = divide_and_conquer(sorted_x,mid+1,right);
        merge(sorted_x, left, (right+left)/2 , right);
        double smallest = Math.min(leftSmallest, rightSmallest);

        //중간영역
        Coordinate[] middle_sorted_y = new Coordinate[right-left+1];
        double distanceX;
        int count = 0;
        //중간영역에 있는 점들을 찾는다.
        //이때 위에서 뽑은 최소거리를 기준으로 판단.

        for(int i=left; i<right; i++){
            distanceX = sorted_x[mid].x-sorted_x[i].x;
            if(Math.abs(distanceX) < smallest){
                middle_sorted_y[count] = new Coordinate(sorted_x[i].x,sorted_x[i].y);
                count++;
            }
        }

        //이후 최소거리 측정
        if(count<=1)return smallest;

        for(int i=0; i<count-1; i++){
            for(int j=i+1; j<count; j++){
                if(middle_sorted_y[j].y-middle_sorted_y[i].y < smallest) {
                    smallest = Math.min(smallest, getDistance(middle_sorted_y[i].x, middle_sorted_y[j].x,middle_sorted_y[i].y, middle_sorted_y[j].y));
                }else{
                    break;
                }
            }
        }

        return smallest;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Coordinate[] sorted_x = new Coordinate[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), ", ");
            sorted_x[i] = new Coordinate(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        quick_sort(sorted_x, 0, N-1);

        String result = String.format("%.6f",divide_and_conquer(sorted_x,0,N-1));
        System.out.println(result);
    }
}