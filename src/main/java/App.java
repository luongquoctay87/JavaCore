package src.main.java;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate sunday = LocalDate.of(2024, Month.OCTOBER, 6);

        System.out.println(today);
        System.out.println(sunday);

//        int[] numbers = {3, 9, 5, 7, 1};
//        Arrays.parallelSort(numbers);
//
//        for (int i = 0; i < numbers.length; i++) {
//            System.out.println(numbers[i]);
//        }
    }
}
