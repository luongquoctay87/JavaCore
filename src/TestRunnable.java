package src;

public class TestRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("TestRunnable thread is running: " + i);
        }
    }
}