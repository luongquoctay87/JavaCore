package src.service;

// Super interface
public interface BaseService {

    default void printMessage() {
        System.out.println("Default message from BaseService");
    }
}
