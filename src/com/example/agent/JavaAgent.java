package com.example.agent;

import java.lang.instrument.Instrumentation;
import java.util.logging.Logger;

public class JavaAgent {
    private static Logger logger = Logger.getLogger("Java agent");

    // javagent引数を用いて実行する場合，premainメソッドを定義する
    public static void premain(String agentArgs, Instrumentation instrumentation) {
        logger.info("[AGENT] In premain");

        Class[] loadedClasses = instrumentation.getAllLoadedClasses();
        for (int i = 0; i < loadedClasses.length; i++) {
            logger.info("[AGENT] This is loaded Class list:"+loadedClasses[i]);
        }
    }
}
