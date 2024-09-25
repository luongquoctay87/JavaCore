package src;

public class Counter {
    private int count = 0;

    // Đồng bộ hóa phương thức
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}