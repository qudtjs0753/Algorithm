package College;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Arrays;

public class TaskScheduling {

    public static class Task {
        int start;
        int end;
        Task(int start, int end){
            this.start= start;
            this.end = end;
        }
    }

    static Comparator<Task> comp = new Comparator<Task>() {
        @Override
        public int compare(Task o1, Task o2) {
            return o1.start - o2.start;
        }
    };

    static Task[] task;
    static int[] machine;
    public static void swap(int left, int right){
        Task temp = task[left];
        task[left] = task[right];
        task[right] = temp;
    }

    // 정렬된 task를 차례로 machine에 집어넣는 과정.
//만약 넣을 수 있는 machine이 없으면 새로운 machine을 만들어낸다.
    public static int greedy(int n){
        int index = 0;
        int machine_num = 0;
        boolean checkMachine;
        while(index<n){
            checkMachine = false;
            for(int i=0; i<machine_num; i++){
                if(machine[i]<=task[index].start){
                    machine[i] = task[index++].end;
                    checkMachine = true;
                    break;
                }
            }
            if(!checkMachine){
                machine[machine_num++] = task[index++].end;
            }
        }
        return machine_num;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        task = new Task[n];
        machine = new int[n];
        for(int i=0; i<n; i++){
            StringTokenizer input = new StringTokenizer(br.readLine(), " ");
            task[i] = new Task(Integer.parseInt(input.nextToken()),Integer.parseInt(input.nextToken()));
        }
        Arrays.sort(task,0,n, comp);
        System.out.println(greedy(n));
    }
}