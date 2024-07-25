package agent;
import java.lang.instrument.Instrumentation;

public class JavaAgent {
    // javagent引数を用いて実行する場合，premainメソッドを定義する
    public static void premain(String agentArgs, Instrumentation instrumentation) {
    }
}
