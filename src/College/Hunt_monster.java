package College;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Hunt_monster {
    public static class Weapon {
        public int deal;
        public int durability;
    }

    static int hp;
    static int weapon_num;


    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            hp = Integer.parseInt(br.readLine());
            weapon_num = Integer.parseInt(br.readLine());
            String[] st = new String[2];
            Weapon[] weapon = new Weapon[weapon_num];


            for(int i=0; i<weapon_num; i++){
                st = br.readLine().split(" ");
                weapon[i] = new Weapon();
                weapon[i].deal = Integer.parseInt(st[0]);
                weapon[i].durability = Integer.parseInt(st[1]);
            }
            mergeSort(weapon, 0, weapon.length-1);
            System.out.println(killMonster(weapon, hp));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void mergeSort(Weapon[] arr,int left, int right){
        if(left<right){
            int mid = (left + right) /2;
            mergeSort(arr, left, mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }
    public static void merge(Weapon[] arr, int left, int mid, int right){
        int i=left;
        int j= mid+1;
        int temp_index=left;

        Weapon[] temp = new Weapon[arr.length];

        //분할한 배열간 크기 비교하고 임시 배열에 저장.

        while(i<=mid&&j<=right){
            if(arr[i].deal<arr[j].deal){
                temp[temp_index++] = arr[i++];
            }else{
                temp[temp_index++] = arr[j++];
            }
        }

        //오른쪽 남아있는 값들 다 집어 넣어 준다.
        while(i<=mid)temp[temp_index++] = arr[i++];
        while(j<=right)temp[temp_index++] = arr[j++];
        for(int index = left; index<temp_index; index++)arr[index] = temp[index];

    }

    public static int killMonster(Weapon[] weapon, int hp){

        int i= weapon.length-1;
        int count = 0;
        while(hp>0){
            if(weapon[i].durability==0)i--;
            else{
                hp -= weapon[i].deal;
                count++;
                weapon[i].durability--;
            }
            if(i<0){
                count=0;
                break;
            }
        }
        return count;
    }
}
