package injectClass;

public class TestClass {
    private int param;
    
    public TestClass(int param) {
        this.param = param;
    }

    public int getParam() {
        return param;
    }
    public void setParam(int param) {
        this.param = param;
    }
    public void printParam(){
        System.out.println(this.getParam());
    }
}
