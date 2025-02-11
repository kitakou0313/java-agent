package com.example.threadLocalVal;

public class Main {
    // 0で初期化
    private static ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);

    private static Integer notThreadLocalValue = 0;

    public static void main(String[] args) {
        Runnable task = () -> {
            // threadLocalValからRead -> 加算 -> 変数にwrite
            int value = threadLocalValue.get();
            value += 1;
            threadLocalValue.set(value);
            
            // スレッド間で同じ変数からgetしているので，2になるケースがあるはず
            // 実際はスレッドごとに値が分離されているので両スレッドで値が1になる
            System.out.println(
                Thread.currentThread().getName() + ": Value of threadLocalValue :" + threadLocalValue.get()
            );

            threadLocalValue.remove();
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();

        // ThreadLocalValueを使わない場合
        Runnable taskWithoutThreadLocalValue = () -> {
            Integer value = notThreadLocalValue;
            value += 1;
            notThreadLocalValue = value;

            System.out.println(
                Thread.currentThread().getName() + ": Value of threadLocalValue :" + notThreadLocalValue
            );
        };

        Thread thread3 = new Thread(taskWithoutThreadLocalValue, "Thread-3");
        Thread thread4 = new Thread(taskWithoutThreadLocalValue, "Thread-4");

        thread3.start();
        thread4.start();

    }
}
