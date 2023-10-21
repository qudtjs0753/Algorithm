import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] result;

    public static void main(String[] args) throws IOException {
        init();
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        int toUpper = 0;

        int size = Math.min(a.length(),b.length());
        result = new int[size+1];

        for (int i=size-1; i>=0; i--) {
            result[size-1-i] = toUpper + ((a.charAt(i) - '0') + (b.charAt(i)-'0')) % 10;
            toUpper = (toUpper + (a.charAt(i) - '0') + (b.charAt(i)-'0')) / 10;
        }

        if(a.length()>b.length()) {
            getResult(a,size, toUpper);
        }else {
            getResult(b,size, toUpper);
        }

        int start = result.length-1;

        while(result[start]==0) {
            start--;
        }

        StringBuilder sb = new StringBuilder();
        while(start>=0) {
            sb.append(result[start]);
        }

        System.out.println(sb);
    }

    private static void getResult(String str, int size, int toUpper) {
        for(int i=size; i<str.length(); i++) {
            result[i] = (toUpper +  str.charAt(i))%10;
            toUpper = (toUpper +  str.charAt(i))/10;
        }

        if(toUpper==1) {
            result[str.length()]=1;
        }
    }
}
