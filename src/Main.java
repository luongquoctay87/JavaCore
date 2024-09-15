package src;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        // Tạo đối tượng SampleClass với từ khóa new
        SampleClass sampleClass = new SampleClass();

        // Khởi tạo đối tượng thông qua biến tham chiếu (reference variable)
        sampleClass.message = "Xin chào";
        System.out.println(sampleClass.message);

        // Tạo đối tượng
        SampleClass other = new SampleClass();

        // Khởi tạo đối tượng qua method
        other.setId(1);
        other.setFirstName("Tây");
        other.setLastName("Java");
        System.out.println(other);

        // Khởi tạo đối tượng thông qua constructors
        SampleClass someone = new SampleClass(2, "John", "Doe", new Date());
        System.out.println(someone);
    }
}
