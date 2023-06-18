package Baekjoon;


import java.io.*;
import java.util.*;
public class Algo20210 {
    private static Map<Character, Integer> characterValue = new HashMap<>();
    private static int N;
    private static ArrayList<WithNatural> arr;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        init();
        solve();
        for(int i=0; i<N; i++) {
            sb.append(arr.get(i).string).append("\n");
        }

        System.out.println(sb);
    }

    private static void solve() {
        Collections.sort(arr, (o1, o2) -> {
            int idx1 = 0, idx2 = 0;
            while(true) {
                if(idx2>=o2.arrayList.size()) return 1;
                if(idx1>=o1.arrayList.size()) return -1;

                Comp value1 = o1.arrayList.get(idx1);
                Comp value2 = o2.arrayList.get(idx2);

                if(value1 instanceof Number && value2 instanceof Alphabet) {
                    return -1;
                }

                if(value1 instanceof Alphabet && value2 instanceof Number) {
                    return 1;
                }


                //둘 다 영어인 경우
                if(value1 instanceof Alphabet && value2 instanceof Alphabet) {
                    char ch1 = value1.getValue().charAt(0);
                    char ch2 = value2.getValue().charAt(0);

                    if(ch1==ch2) {
                        idx1++;
                        idx2++;
                        continue;
                    }
                    return characterValue.get(ch1) - characterValue.get(ch2);
                }


                //둘 다 숫자인 경우
                String number1 = value1.getValue();
                String number2 = value2.getValue();

                if(number1.length()==number2.length()) {
                    int result = number1.compareTo(number2);
                    if(result==0) {
                        Number toConvert1 = (Number)value1;
                        Number toConvert2 = (Number)value2;
                        int zero1 = toConvert1.countOfFirstZeros;
                        int zero2 = toConvert2.countOfFirstZeros;
                        if(zero1==zero2) {
                            idx1++;
                            idx2++;
                            continue;
                        }
                        return zero1-zero2;
                    }
                    return result;
                }
                return number1.length()- number2.length();
            }
        });
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>(N);

        for(int i=0; i<10; i++) {
            characterValue.put((char)('0'+i), i);
        }

        for(int i=0; i<26; i++) {
            characterValue.put((char)('a' + i), 2*i + 11);
            characterValue.put((char)('A' + i), 2*i + 10);
        }

        for(int i=0; i<N; i++) {
            String input = br.readLine();
            WithNatural natural = new WithNatural();
            natural.string = input;

            int idx = 0;
            while(true) {
                if(idx==input.length()) break;
                if(characterValue.get(input.charAt(idx))<10) {
                    Number number = new Number();
                    number.createNumber(input, idx);
                    natural.arrayList.add(number);
                    idx += number.value.length() + number.countOfFirstZeros;
                }else {
                    Alphabet alphabet = new Alphabet();
                    alphabet.value = Character.toString(input.charAt(idx));
                    natural.arrayList.add(alphabet);
                    idx++;
                }
            }
            arr.add(natural);
        }
    }

    static class WithNatural {
        ArrayList<Comp> arrayList = new ArrayList<>();
        String string;

    }
    static class Number implements Comp {
        int countOfFirstZeros;
        String value;

        @Override
        public String getValue() {
            return value;
        }

        public void createNumber(String string, int idx) {
            StringBuilder numberBuilder = new StringBuilder();
            boolean isStart = false;
            while(idx<string.length() && characterValue.get(string.charAt(idx))<10) {
                if(!isStart) {
                    if(string.charAt(idx)=='0') countOfFirstZeros++;
                    else {
                        isStart = true;
                        numberBuilder.append(string.charAt(idx));
                    }
                }else {
                    numberBuilder.append(string.charAt(idx));
                }
            }
            value = numberBuilder.toString();
        }
    }

    static class Alphabet implements Comp {
        String value;

        @Override
        public String getValue() {
            return value;
        }
    }
}
interface Comp {
    String getValue();
}


