package src;

import java.util.ArrayList;
import java.util.List;

public class TayJava {

    public static void main(String[] args) {

//        int age = 25;
//
//        if (age >= 18) {
//            System.out.println("Đã đủ tuổi cưới vợ rồi");
//        }
//
//        String expression = "874";
//        switch (expression) {
//            case "123":
//                System.out.println("Bạn đã nhận được khoản tiền thưởng 100k");
//                break;
//            case "874":
//                System.out.println("Bạn đã nhận được khoản tiền thưởng 200k");
//                break;
//            case "692":
//                System.out.println("Bạn đã nhận được khoản tiền thưởng 500k");
//                break;
//            default:
//                System.out.println("Chúc bạn lần sau may mắn");
//        }
//
//        // Vòng lặp for
//
//        // duyệt số từ 1~10
//        for (int i = 0; i < 10; i++) {
//            System.out.println("So: " + i);
//        }
//
//        // Lặp chồng lặp (++)
//        for (int i = 1; i <= 10; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//
//        // Lặp chồng lặp (++)
//        for (int i = 1; i <= 10; i++) {
//            for (int j = 10; j >= i; j--) {
//                System.out.print("* ");
//            }
//            System.out.println();//new line
//        }
//
//        List<String> list = new ArrayList<>();
//        list.add("A");
//        list.add("B");
//        list.add("C");
//        list.add("D");
//        list.add("E");
//        list.add("F");
//        list.add("H");
//
//        for (String s: list) {
//            System.out.println(s);
//        }
//
//        // Vòng lặp while
//        int x = 5;
//        while (x <= 10) {
//            System.out.println(x);
//            x++;
//        }
//
//        System.out.println("\n");
//
//        // Vòng lặp do/while
//        int y = 5;
//        do {
//            System.out.println(y);
//            y++;
//        } while (y <= 10);


        System.out.println("------- BREAK ---------");
        for (int i = 0; i < 10; i++) {
            if (i==5) {
                break;
            }
            System.out.println("So: " + i);
        }

        System.out.println("------- CONTINUE ---------");
        // continue
        for (int i = 0; i < 10; i++) {
            if (i==5) {
                continue; // gặp lệnh continue for sẽ dùng ở đây và chạy vòng tiếp theo
            }
            System.out.println("So: " + i);
        }
    }
}
