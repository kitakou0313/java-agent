package com.example;

import com.example.injectClass.TestClass;

/**
 * Main
 */

public class Main {
    public static void main(String[] args) {
        TestClass testClass = new TestClass(1000);
        testClass.printParam();
    }
}
