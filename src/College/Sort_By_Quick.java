package College;
import java.lang.StringBuilder;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Sort_By_Quick {
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void quick_sort(int[] arr, int low, int high){
        int left = low;
        int right = high;
        int pivot = arr[(low+high)/2];

        do{
            while(arr[left] < pivot) left++;
            while(arr[right] > pivot) right--;
            if(left <= right){
                swap(arr, left, right);
                left++;
                right--;
            }
        }while (left <= right);

        if(low < right) quick_sort(arr, low, right);
        if(high > left) quick_sort(arr, left, high);
    }


    public static void main(String[] args){
        try{
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }
            quick_sort(arr, 0, n-1);

            for(int i=0; i<n; i++){
                bw.write(Integer.toString(arr[i]) + "\n");
            }
            bw.flush();
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
