package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @Author: kbs
 */
public class Algo2042 {
    static int N,M,K;
    static long[] indexTree;

    public static void main(String[] args) throws IOException {
        int a,b,size;
        long c;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        size = getSizeOfLeaf();
        indexTree = new long[size * 2];
        for(int i=0; i<N; i++){
            indexTree[i + size] = Long.parseLong(br.readLine());
        }
        init();
        for(int i=0; i<K+M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Long.parseLong(st.nextToken());
            if(a==1){
                update(size, b, c);
            }else if(a==2){
                System.out.println(prefixSum(1, size, 1,b,(int)c));
            }
        }
    }
    public static int getSizeOfLeaf(){
        int size = 1;
        while(N>size)size*=2;
        return size;
    }
    public static void init(){
        int length = indexTree.length;
        for(int i=length-1; i>=1; i--){
           int parent = i/2;
           indexTree[parent] += indexTree[i];
        }
    }

    public static void update(int size,int order, long newVal){
        //n번째 수를 바꾸게 되면 그의 부모로 타고타고 올라가면서 수정.
        int tmpIdx = order + size-1;
        long tmpVal = indexTree[tmpIdx];
        indexTree[tmpIdx] = newVal;
        while(true){
            //부모의 이전 값 저장해놓고 조상 수정할 때 사용해야함.
            if(tmpIdx==1)return;

            int parent = tmpIdx/2;
            long parentTmp = indexTree[parent];

            //이전에 저장되어 있던 값을 빼주고
            //새로운 값을 더해주면서 업데이트 시켜준다.
            indexTree[parent] -= tmpVal;
            indexTree[parent] += indexTree[tmpIdx];
            tmpIdx = parent;
            tmpVal = parentTmp;
        }
    }

    public static long prefixSum(int left, int right, int node, int start, int end){
        //leaf 노드 도달 시 종료
        //1. 상관 없을 때.
        if(right < start || end<left) return 0;
        //2. 완전 포함될 때
        else if(left>=start && right<=end)
            return indexTree[node];
        //3. 결정할 수 없을 때
        else{
            long retL = 0;
            long retR = 0;
            int mid = (left + right) /2;
            retL = prefixSum(left, mid, node*2, start, end);
            retR = prefixSum(mid+1, right, node*2 +1, start, end);

            return retL + retR;
        }

    }
}
