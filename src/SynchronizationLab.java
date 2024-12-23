// Lab Task 2: Thread Synchronization

public class SynchronizationLab {
    static class Counter {
        private int count = 0;

        public synchronized void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    static class CounterThread extends Thread {
        private Counter counter;

        public CounterThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                counter.increment();
            }
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        // Creating and starting threads for Task 2
        Thread t1 = new CounterThread(counter);
        Thread t2 = new CounterThread(counter);
        Thread t3 = new CounterThread(counter);

        t1.start();
        t2.start();
        t3.start();

        // Wait for threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Printing final counter value
        System.out.println("Final Counter Value: " + counter.getCount());
    }
}
