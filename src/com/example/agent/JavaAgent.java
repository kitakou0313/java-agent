package com.example.agent;

import java.lang.instrument.Instrumentation;

public class JavaAgent {
    // javagent引数を用いて実行する場合，premainメソッドを定義する
    public static void premain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("[AGENT] In premain");

        Class[] loadedClasses = instrumentation.getAllLoadedClasses();
        for (int i = 0; i < loadedClasses.length; i++) {
            System.out.println("[AGENT] This is loaded Class list:"+loadedClasses[i]);
        }
    }
}
