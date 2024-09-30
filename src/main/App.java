package main;

public class App {
    public static void main(String[] args) {
//        try {
//            int result = 10 / 0;  // Sẽ phát sinh ArithmeticException
//        } catch (ArithmeticException e) {
//            System.out.println("Không thể chia cho 0");
//        } finally {
//            System.out.println("Đoạn code ở finally luôn đuóc thực hiện");
//        }

        // handle exception by try/catch
        try {
            validateAge(16);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    // throws được sử dụng để khai báo loại ngoại lệ có thể phát sinh
    static void validateAge(int age) throws ArithmeticException {
        if (age < 18) {
            // throw để ném ngoại lệ khi điều kiện không thỏa mãn
            throw new ArithmeticException("Không đủ tuổi cưới vợ");
        } else {
            System.out.println("Bác sỹ bảo cưới thì cưới");
        }
    }
}
