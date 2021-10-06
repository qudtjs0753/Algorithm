package College;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class ClosestPair {
    public static class Coordinate {
        public int x;
        public int y;
    }
    static int N;
    public static void swap(Coordinate[] arr, int a, int b){
        Coordinate temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //0이면 x 1 이면 y sort
    public static void quick_sort(Coordinate[] arr, int low, int high,int x_or_y){
        int left = low;
        int right = high;
        //x sort
        if(x_or_y==0){
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
        }
        //y sort
        else if(x_or_y==1){
            int pivot = arr[(low+high)/2].y;

            do{
                while(arr[left].y < pivot) left++;
                while(arr[right].y > pivot) right--;
                if(left <= right){
                    //y에 대해 정렬함과 동시에 x에 대해서도 정렬.
                    swap(arr, left, right);
                    left++;
                    right--;
                }
            }while (left <= right);
        }

        if(low < right) quick_sort(arr, low, right,x_or_y);
        if(high > left) quick_sort(arr, left, high,x_or_y);
    }
    public static double getDistance(int x1, int x2, int y1, int y2){
        double distanceX = x2 -x1;
        double distanceY = y2 -y1;
        double distance = Math.sqrt(distanceX*distanceX +distanceY*distanceY );
        return distance;
    }

    public static double divide_and_conquer(Coordinate[] sorted_x,  int left, int right){
        int mid = (left+right)/2;
        if(right-left <= 1){
            return getDistance(sorted_x[left].x, sorted_x[right].x,sorted_x[left].y,sorted_x[right].y);
        }
        else if((right-left) == 2){
            double minDistance=9999999;
            for(int i=left; i<right; i++){
                for(int j=i+1; j<=right; j++){
                    minDistance = Math.min(minDistance, getDistance(sorted_x[i].x, sorted_x[j].x,sorted_x[i].y,sorted_x[j].y));
                }
            }
            return minDistance;
        }

        //4개 이상 남은 경우
        double smallest = 0;
        double leftSmallest;
        double rightSmallest;
        if(right>left){
            leftSmallest = divide_and_conquer(sorted_x,left,mid);
            rightSmallest = divide_and_conquer(sorted_x,mid+1,right);
            smallest = Math.min(leftSmallest, rightSmallest);
        }

        //중간영역
        int middleArea = 0;
        Coordinate[] middle_sorted_y = new Coordinate[right-left];
        double distanceX;
        double distanceY;
        int count = 0;
        //중간영역에 있는 점들을 찾는다.
        //이때 위에서 뽑은 최소거리를 기준으로 판단.
        for(int i=0; i<right-left; i++){
            distanceX = sorted_x[mid].x-sorted_x[left+i].x;
            distanceY =  sorted_x[mid].y-sorted_x[left+i].y;
            middle_sorted_y[i] = new Coordinate();
            if(Math.abs(distanceX) < smallest){
                middle_sorted_y[count] = sorted_x[left+i];
                count++;
            }
        }
        quick_sort(middle_sorted_y, 0, count-1, 1);
        //이후 최소거리 측정
        if(count<=1)return smallest;
        for(int i=0; i<count-1; i++){
            for(int j=i+1; j<count; j++){
                if(middle_sorted_y[i+1].y-middle_sorted_y[i].y < smallest) {
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
        String[] str = new String[2];

        for(int i=0; i<N; i++){
            str = br.readLine().split(", ");
            sorted_x[i] = new Coordinate();
            sorted_x[i].x = Integer.parseInt(str[0]);
            sorted_x[i].y = Integer.parseInt(str[1]);
        }
        quick_sort(sorted_x, 0, N-1, 0);

        String result = String.format("%.6f",divide_and_conquer(sorted_x,0,N-1));
        System.out.println(result);
    }
}
