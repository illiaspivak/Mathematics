package sk.kosickaakademia.spivak.test;

import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(67);
        list.add(49);
        list.add(87);
        list.add(56);
        list.add(22);


        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                int a = digitSum(o1);
                int b = digitSum(o2);
                if(a == b){
                    return 0;
                }else
                if (a>b) {
                    return +1;
                }else{
                    return -1;
                }
            }
        });

        for(int temp:list){
            System.out.print(temp + " ");
        }

        System.out.println();
        System.out.println(digitSum(65));


        //Collections.sort(list, Comparator.comparingInt(Main::digitSum));

        list.forEach( Main::print );
        System.out.println();
    }

    private static int digitSum(int n){
        int m = 0;
        while (n > 0){
            m = m + n%10;
            n = n/10;
        }
        return m;
    }

    private static void print(int n){
        System.out.print(n + " ");
    }

}
