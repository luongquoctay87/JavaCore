package src;

import java.time.LocalDate;

public interface SampleInterface {

    // constant fields
    String name = "Tây Java";

    // abstract methods
    void method1();

    int method2();

    String methodN();

    // default method
    default void sayHello() {
        System.out.println("Đây là sample interface");
    }

    // static method
    static String getCurrentTime(){
        return String.valueOf(LocalDate.now());
    }

}
