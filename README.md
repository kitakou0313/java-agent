# java-agent
javaagentの学習


# 開発用コマンド

## executable jar fileの生成

### Build 
```
jar --create --verbose --file build/injectedApp.jar --main-class com/example/Main -C class/ .
jar --create --verbose --file build/javaAgent.jar --main-class com/example/agent/JavaAgent -C class/ .
```

### 実行
```
java -jar  build/injectedApp.jar 
java -jar  build/javaAgent.jar 
```


## Classファイルの生成時

### Build時

```
javac -sourcepath ./src -d ./class src/com/example/Main.java 
javac -sourcepath ./src -d ./class src/com/example/agent/JavaAgent.java
```
`./class`配下に`.class`ファイルが生成される

### 実行時

```
java -cp ./class:./class/com/example:./class/com/example/injectClass com/example/Main
```
