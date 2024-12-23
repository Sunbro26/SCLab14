// Lab Task 1: Introduction to Multithreading

public class MultithreadingLab {
    // Thread to print numbers from 1 to 10
    static class NumberThread extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Number: " + i);
                try {
                    Thread.sleep(100); // Adding delay to observe concurrency
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Thread to print squares of numbers from 1 to 10
    static class SquareThread extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Square: " + (i * i));
                try {
                    Thread.sleep(100); // Adding delay to observe concurrency
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // Creating and starting threads for Task 1
        Thread numberThread = new NumberThread();
        Thread squareThread = new SquareThread();

        numberThread.start();
        squareThread.start();
    }
}