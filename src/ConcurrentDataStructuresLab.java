// Lab Task 3: Concurrent Data Structures

import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentDataStructuresLab {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> sharedList = new CopyOnWriteArrayList<>();

        Runnable writer = () -> {
            for (int i = 0; i < 10; i++) {
                sharedList.add(i);
                System.out.println(Thread.currentThread().getName() + " added: " + i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable reader = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " read: " + sharedList);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread writerThread1 = new Thread(writer, "Writer-1");
        Thread writerThread2 = new Thread(writer, "Writer-2");
        Thread readerThread = new Thread(reader, "Reader");

        writerThread1.start();
        writerThread2.start();
        readerThread.start();

        try {
            writerThread1.join();
            writerThread2.join();
            readerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}