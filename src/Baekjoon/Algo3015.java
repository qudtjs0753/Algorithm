package Baekjoon;


import java.io.*;
import java.util.*;
public class Algo3015 {

    static int N;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = new int[N];

        Deque<int[]> st = new ArrayDeque<>(500000);
        long result = 0;
        st.add(new int[]{Integer.parseInt(br.readLine()), 1});

        for(int i=0; i<N-1; i++) {
            int current = Integer.parseInt(br.readLine());
            int cnt = 1;

            //오른쪽에 새로 들어올 사람에 대해서 상대적인 키를 체크한다.
            while(!st.isEmpty() && current>=st.peek()[0]){
                int[] temp = st.pop(); //더 작거나 같으면 뽑고
                result += temp[1]; //그 인원수만큼 더해준다
                if(temp[0]==current) cnt+=temp[1]; //만약 키가 같다면, 다음 새로 들어올 사람도 이에 대한 카운트를 해줘야하므로 더한다.
            }

            //바로 왼쪽에 대해서
            if(!st.isEmpty()) {
                result++;
            }

            st.push(new int[]{current, cnt});
        }


        System.out.println(result);
    }
}
