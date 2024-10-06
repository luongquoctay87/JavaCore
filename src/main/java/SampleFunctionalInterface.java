package src.main.java;

@FunctionalInterface
public interface SampleFunctionalInterface {
    void doSomething();

    static void doSomethingElse() {
        System.out.println("Do something else");
    }

    default void printMessage() {
        System.out.println("Sample Functional Interface");
    }

    default void welcome() {
        System.out.println("Welcome to Tây Java");
    }
}
