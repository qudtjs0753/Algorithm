package College;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.ArrayList;

public class TaskScheduling {
    public static class FastReader {
        BufferedReader br;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
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

    static Task[] task = new Task[10000000];
    static ArrayList<Integer> machines = new ArrayList<>();

    public static int greedy(int n){
        int index = 0;

        boolean checkMachine;
        while(index<n){
            checkMachine = false;
            //for문 무조건 돌아가지 않게 앞에서 처리할 방법?
            for(int i=0; i<machines.size(); i++){
                if(machines.get(i)<=task[index].start){
                    machines.set(i, task[index++].end);
                    checkMachine = true;
                    break;
                }
            }
            if(!checkMachine){
               machines.add(task[index++].end);
            }
        }
        return machines.size();
    }


    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        FastReader s = new FastReader();
        int n = Integer.parseInt(s.nextLine());

        //입력받는데 문제가 있는듯.
        for(int i=0; i<n; i++){
            StringTokenizer input = new StringTokenizer(s.nextLine(), " ");
            task[i] = new Task(Integer.parseInt(input.nextToken()),Integer.parseInt(input.nextToken()));
        }

        Arrays.sort(task,0,n, comp);

        System.out.println(greedy(n));
    }
}
