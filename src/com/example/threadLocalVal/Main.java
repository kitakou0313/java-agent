package com.example.threadLocalVal;

public class Main {
    private static ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        Runnable task = () -> {
            int value = threadLocalValue.get();
            value += 1;
            threadLocalValue.set(value);
            
            System.out.println(
                Thread.currentThread().getName() + ": Value of threadLocalValue :" + threadLocalValue.get()
            );

            threadLocalValue.remove();
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
