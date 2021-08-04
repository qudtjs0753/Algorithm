import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;

public class Algo10814 {
    public static class User {
        int age;
        String name;

        public User(int age, String name){
            this.age = age;
            this.name = name;
        }

        public String toString(){
            return age + " " + name;
        }
    }


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        User[] user = new User[N];

        for(int i=0; i< N; i++){
            user[i] = new User(input.nextInt(), input.next());
        }
        Arrays.sort(user, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.age - o2.age;
            }
        });
        for(int i=0; i<N; i++){
            System.out.println(user[i]);
        }

    }
}
