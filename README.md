# java-agent
javaagentの学習


# 開発用コマンド

## Classファイルの生成時

### Build時

```
javac -sourcepath src/:src/com/example/ src/com/example/Main.java 
```
`./class`配下に`.class`ファイルが生成される

### 実行時

```
java -cp ./class:./class/com/example:./class/com/example/injectClass com/example/Main
```
