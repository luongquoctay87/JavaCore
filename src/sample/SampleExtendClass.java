package src.sample;

public class SampleExtendClass extends SampleAbstractClass {
    @Override
    public void sayHello() {
        System.out.println("Hello, Tay Java");
    }

    @Override
    public int calculate(int a, int b) {
        return a * b;
    }
}
