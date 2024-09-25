package src;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        TestThread thread1 = new TestThread();
//        TestThread thread2 = new TestThread();
//
//        thread1.start();
//        thread2.start();

//        TestRunnable testRunnable = new TestRunnable();
//        Thread thread3 = new Thread(testRunnable);
//
//        thread3.start();

//        Counter counter = new Counter();
//
//        // Tạo hai thread cùng tăng giá trị của counter
//        Thread thread5 = new Thread(() -> {
//            for (int i = 0; i < 1000; i++) {
//                counter.increment();
//                System.out.println("thread5: " + counter.getCount());
//            }
//        });
//
//        Thread thread6 = new Thread(() -> {
//            for (int i = 0; i < 1000; i++) {
//                counter.increment();
//                System.out.println("thread6: " + counter.getCount());
//            }
//        });
//
//        thread5.start();
//        thread6.start();
//
//        // Đợi cả hai thread hoàn thành
//         thread5.join();
//         thread6.join();
//
//        // Kết quả chính xác do có đồng bộ hóa
//        System.out.println("Final count: " + counter.getCount());


        // Tạo một Thread Pool với 3 thread
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Thực thi các tác vụ
        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                System.out.println("Thread " + Thread.currentThread().getName() + " is running.");
            });
        }

        // Đóng ExecutorService
        executor.shutdown();
    }
}
