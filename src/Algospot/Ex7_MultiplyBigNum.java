package Algospot;
import java.util.List;
import java.util.ArrayList;
public class Ex7_MultiplyBigNum {
    public static void normalize(ArrayList<Integer> num){
        num.add(0);
        //자릿수 올림 처리
        for(int i=0; i+1 < num.size(); i++){
            if(num.get(i) < 0){
                int borrow = (Math.abs(num.get(i))+9)/10;
                num.set(i+1, num.get(i+1)-borrow);
                num.set(i, num.get(i)+borrow*10);
            }else{
                num.set(i+1, num.get(i)/10);
                num.set(i, num.get(i)%10);
            }
        }
        while(num.size()> 1 && num.get(num.size()-1) == 0) num.remove(num.size()-1);
    }

    public static ArrayList<Integer> multiply(final ArrayList<Integer> a,final ArrayList<Integer> b){
        ArrayList<Integer> c = new ArrayList<Integer>( a.size()+b.size()+1);
        for(int i=0; i<a.size()+b.size()+1; i++){
            c.set(i, 0);
        }
        for(int i=0; i < a.size(); i++){
            for(int j=0; j< b.size(); j++){
                c.set(i+j, c.get(i+j) + a.get(i) * b.get(j));
            }
        }
        normalize(c);
        return c;
    }

    public static void addTo(ArrayList<Integer> a, ArrayList<Integer> b, int k){};

    public static void subFrom(ArrayList<Integer> a, ArrayList<Integer> b) {};

    public static ArrayList<Integer> karatsuba(final ArrayList<Integer> a, final ArrayList<Integer> b){
        int an = a.size(), bn= b.size();
        //a가 b보다 짧을 경우 둘을 바꾼다.
        if(an < bn) return karatsuba(b, a);
        //a나 b가 비어있는 경우
        if(an== 0 || bn==0) return new ArrayList<Integer>();
        //기저사례: a가 비교적 짤은 경우 O(n^2) 곱셈으로 변경한다.
        if(an <= 50) return multiply(a, b);
        int half = an/2;
        //a와 b를 밑에서 half 자리와 나머지로 분리한다.
        ArrayList<Integer> a0 = new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> b0 = new ArrayList<>();
        ArrayList<Integer> b1 = new ArrayList<>();
        //z2 = a1 * b1
        ArrayList<Integer> z2 = karatsuba(a1, b1);
        //z0 = a0 * b0
        ArrayList<Integer> z0 = karatsuba(a0, b0);
        //a0=a0+a1; b0 = b0 + a1
        addTo(a0, a1, 0); addTo(b0, b1, 0);
        //z1 = (a0*b0)- z0 - z2;
        ArrayList<Integer> z1 = karatsuba(a0, b0);
        subFrom(z1, z0);
        subFrom(z1, z2);
        //ret = z0 + z1 * 10^half + z2 * 10^(half*2)
        ArrayList<Integer> ret = new ArrayList<>();
        addTo(ret, z0, 0);
        addTo(ret, z1, half);
        addTo(ret, z2, half + half);
        return ret;
    }
}
