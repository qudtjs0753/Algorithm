package swexpert.memoization;

import java.io.*;
import java.util.*;
public class SWEA3307_최장증가부분수열 {

	private static int N, T; 
	private static int[] arr,C;
	private static int result = 1;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException { // main start
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader로 빠른 입력.
		
		T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N+10];
			C = new int[N+10];
			result = 1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append("#").append(testCase).append(" ").append(binarySearch()).append("\n");
		}

		System.out.println(sb); // 최종결과 출력
	}

	
	private static int binarySearch() {
		int size = 0,temp;
		
        for (int i=0; i < N; i++) {
            temp = Math.abs(Arrays.binarySearch(C, 0, size, arr[i])) -1; // 리턴값 : -insertPoint -1
            C[temp] = arr[i];// temp 자리에 값을 update 하면 그 의미는 

            if (size == temp) {// 삽입위치의 인덱스와 크기가 같으면(결국,마지막이 삽입위치라는 얘기임) 크기 1늘림.
                size++;
            }
        }
        return size;
	}
}