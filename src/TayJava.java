package src;

public class TayJava {

    static String name = "Tây Java";


    public static void main(String[] args) {

        String sayHello = "Welcome to"; // instance variable

        System.out.println(sayHello + " " + name);

        this.greating();
    }

    void greating() {
        String hello = "Hi, This is my first application"; // local variable
    }
}
