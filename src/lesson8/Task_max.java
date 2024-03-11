package lesson8;

import java.util.Scanner;

public class Task_max {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        String max ;
        if (x > y && x > z){
            max = "Икс больше игрика и зет";
        }else {
            max = y > x && y > z ? "Игрик больше икса и зет" : "Зет больше игрика и икса";
        }
        System.out.println(max);


    }
}
