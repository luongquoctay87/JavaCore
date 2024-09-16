package src.sample;

public class SampleMethodOverriding implements SampleInterface {
    @Override
    public void method1() {
        // code here
    }

    @Override
    public int method2() {
        return 0;
    }

    @Override
    public String methodN() {
        return "";
    }

    @Override
    public void sayHello() {
        SampleInterface.super.sayHello();
    }
}
