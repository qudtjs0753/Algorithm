package Baekjoon;

import java.io.*;
import java.util.*;


public class Algo2533 {
	
	static int result;
	static int N;
	static ArrayList<Integer>[] tree;
	static boolean[] visit;
	static boolean[] isEarly;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		visit = new boolean[N+1];
		isEarly = new boolean[N+1];
		
		for(int i=0; i<=N; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			tree[v1].add(v2);
			tree[v2].add(v1);
		}
		
		visit[1] = true;
		
		goVisit(1, 0);
		
		System.out.println(result);
	}

	private static boolean goVisit(int currentNode, int rootNode) {
        
		//자식 노드 체크
		for(Integer child : tree[currentNode]) {
			if(child==rootNode && visit[child]) {
				continue;
			}
			visit[child] = true;
			if(!goVisit(child, currentNode)) {
                isEarly[currentNode] = true;
            }
		}
		
        if(isEarly[currentNode]) {
            result++;
        }
        
        return isEarly[currentNode];	
	}
}

