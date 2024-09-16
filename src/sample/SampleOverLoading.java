package src.sample;

public class SampleOverLoading {

    // Thay đổi số lượng arguments
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Thay đổi kiểu dữ liệu <data-type>
    public float add(float a, float b) {
        return a + b;
    }

    public float add(float a, float b, float c) {
        return a + b + c;
    }
}
