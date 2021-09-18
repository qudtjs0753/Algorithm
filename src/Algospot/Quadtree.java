package Algospot;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Quadtree {
    static int C;

    //x가 나오면 4분할.
    //x가 나왔으면 4번계산하고 그 다음 index로 넘어갈 수 있도록 +4해서 리턴해준다.
    public static String sliceTree(String str,int index){
        String[] sliced = new String[4];
        int nextIndex=index;
        if(str.charAt(index)=='x'){
            nextIndex+=1;
            for(int i=0; i<4; i++){
                sliced[i] = sliceTree(str, nextIndex);
                nextIndex += sliced[i].length();
            }
            return "x" + sliced[2] + sliced[3] + sliced[0] + sliced[1];
        }else{
            return Character.toString(str.charAt(index));
        }
    }

    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            C = Integer.parseInt(br.readLine());
            String str;
            for(int i=0; i<C; i++){
                str=br.readLine();
                System.out.println(sliceTree( str, 0));
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }


    }
}
