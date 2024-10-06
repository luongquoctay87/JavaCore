# Java 8 Part 1

Java 8 (được phát hành vào tháng 3 năm 2014) là một phiên bản quan trọng trong lịch sử phát triển của ngôn ngữ Java, mang lại nhiều tính năng mới và cải tiến, giúp tăng cường hiệu suất, khả năng mở rộng và lập trình dễ dàng hơn. Dưới đây là một tổng quan về các tính năng quan trọng của Java 8

### 1. Functional Interfaces
Functional Interfaces là các interface có duy nhất một phương thức trừu tượng. Trong Java 8, các interface này được tăng cường với các phương thức mặc định (default methods) và phương thức tĩnh (static methods). Các biểu thức Lambda có thể được sử dụng với các interface này.

### 2. Lambda Expressions
Biểu thức Lambda là một tính năng quan trọng nhất của Java 8, cho phép viết các hàm ẩn danh (anonymous functions) trong Java. Nó giúp làm cho mã nguồn ngắn gọn, dễ đọc và dễ bảo trì hơn, đặc biệt khi làm việc với các Functional Interface

### 3. Method References
Thay vì sử dụng biểu thức Lambda chúng ta có thể sử dụng tham chiếu phương thức để tham chiếu trực tiếp đến các phương thức.

### 4. Default Methods
Java 8 cho phép các phương thức mặc định trong các interface, có nghĩa là các phương thức này có thể được triển khai ngay trong interface mà không bắt buộc các lớp kế thừa phải implements. Điều này giúp mở rộng các interface mà không làm hỏng tính tương thích ngược.

### 5. Streams API
Streams API giúp thao tác với tập hợp dữ liệu(Collection) theo cách dễ dàng và hiệu quả hơn, đặc biệt trong việc xử lý tập dữ liệu lớn. Nó hỗ trợ các thao tác như lọc (filter), ánh xạ (map), và giảm (reduce) mà không cần phải viết mã vòng lặp phức tạp.

### 6. Optional
Optional là một lớp giúp xử lý các giá trị có thể là null, tránh việc phát sinh lỗi NullPointerException bằng cách cung cấp các phương pháp tiếp cận an toàn hơn với giá trị null.

### 7. New Date and Time API
Java 8 giới thiệu gói java.time, giúp quản lý ngày và giờ một cách đơn giản, rõ ràng và mạnh mẽ hơn so với `java.util.Date` và `java.util.Calendar`
```java
public class App {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate sunday = LocalDate.of(2024, Month.OCTOBER, 6);

        System.out.println(today);
        System.out.println(sunday);
    }
}

-- Kết quả --
2024-10-06
2024-10-06
```
### 8. Nashorn JavaScript Engine
Java 8 giới thiệu Nashorn, một công cụ JavaScript được tích hợp vào JVM, cho phép chúng ta nhúng và chạy mã JavaScript trực tiếp từ Java. Tuy nhiên Nashorn đã bị loại bỏ trong Java 15, GraalVM là một sự thay thế hoàn hảo, với hiệu suất cao hơn và hỗ trợ đa ngôn ngữ tốt hơn. GraalVM có thể chạy JavaScript, Ruby, Python, và nhiều ngôn ngữ khác trên JVM.
### 9. Parallel Array Sorting
Java 8 cung cấp phương pháp sắp xếp mảng song song, giúp tăng tốc độ sắp xếp các mảng lớn bằng cách chia nhỏ và sắp xếp chúng đồng thời.
```java
public class App {
    public static void main(String[] args) {
        int[] numbers = {3, 9, 5, 7, 1};
        Arrays.parallelSort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}

-- Kết quả --
1
3
5
7
9
```

### 10 Improved Concurrency
Java 8 giới thiệu các công cụ mới để làm việc với các ứng dụng đa luồng như `CompletableFuture` và `ForkJoinPool`

---

## Functional Interface trong Java 8
### 1. Định nghĩa
Functional Interface là một khái niệm quan trọng trong Java 8, đóng vai trò nền tảng cho việc triển khai biểu thức lambda và các phương pháp tham chiếu (method references). Định nghĩa của Functional Interface khá đơn giản: đó là một interface trong Java có chính xác một phương thức trừu tượng. Những interface này giúp viết mã ngắn gọn, dễ hiểu và linh hoạt hơn trong các tình huống xử lý logic chức năng.

```java
@FunctionalInterface
public interface SampleFunctionalInterface {
    void doSomething(); // Single Abstract Method
}
```
- `@FunctionalInterface`: để đảm bảo một interface đáp ứng yêu cầu của một functional interface. Nếu interface được chú thích với @FunctionalInterface mà có nhiều hơn một phương thức trừu tượng, trình biên dịch sẽ báo lỗi. Tuy nhiên, việc thêm chú thích này là tùy chọn và chỉ mang tính chất kiểm tra.
- `void doSomething()`: SampleFunctionalInterface được coi là một functional interface vì nó chỉ chứa một phương thức abstract method duy nhất là `void doSomething()`

#### 2. Các Functional interface phổ biến trong Java 8
- Predicate<T>: Dùng để đánh giá một điều kiện trên đối tượng kiểu T và trả về giá trị boolean.
```java
Predicate<String> isLonger = str -> str.length() > 8;
System.out.println(isLonger.test("Tây Java"));  // false
```

- Function<T, R>: Ánh xạ một đối tượng kiểu T sang kiểu R
```java
Function<String, Integer> stringToLength = str -> str.length();
System.out.println(stringToLength.apply("Tây Java"));  // 8
```

- Consumer<T>: Thực hiện một hành động nào đó trên đối tượng kiểu T mà không trả về kết quả.
```java
Consumer<String> printString = str -> System.out.println(str);
printString.accept("Tây Java");  // In ra "Tây Java"
```

- Supplier<T>: Cung cấp một giá trị kiểu T mà không cần tham số đầu vào.
```java
Supplier<String> supplier = () -> "Tây Java";
System.out.println(supplier.get());  // Tây Java
```

- BiFunction<T, U, R>: Nhận hai tham số kiểu T và U, trả về giá trị kiểu R.
```java
BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
System.out.println(sum.apply(3, 5));  // 8
```

- UnaryOperator<T>: Nhận một tham số kiểu T và trả về cùng kiểu T. Nó là một trường hợp đặc biệt của Function<T, R>, khi T và R có cùng kiểu.
```java
UnaryOperator<Integer> square = x -> x * x;
System.out.println(square.apply(13));  // 169
```

- BinaryOperator<T>: Nhận hai tham số cùng kiểu T và trả về giá trị kiểu T. Đây là trường hợp đặc biệt của BiFunction<T, U, R>.
```java
BinaryOperator<Integer> multiply = (a, b) -> a * b;
System.out.println(multiply.apply(5, 4));  // 20
```

#### 3. Biểu thức Lambda với Functional Interface
Biểu thức lambda giúp khởi tạo các functional interface một cách đơn giản và ngắn gọn. Thay vì tạo một lớp ẩn danh để implement các phương thức của functional interface chúng ta có thể sử dụng biểu thức lambda để viết các hàm ngắn gọn hơn.
```java
@FunctionalInterface
interface SampleFunctionalInterface {
    void doSomething();
}

public class Main {
    public static void main(String[] args) {
        // Cách cũ: Sử dụng lớp ẩn danh
        SampleFunctionalInterface sampleInf = new SampleFunctionalInterface() {
            @Override
            public void doSomething() {
                System.out.println("Cách viết cũ");
            }
        };
        sampleInf.doSomething();

        // Cách mới: Sử dụng biểu thức lambda
        MyFunctionalInterface newWay = () -> System.out.println("Cách viết mới");
        newWay.doSomething();
    }
}
```

### 4. Method References với Functional Interface
Thay vì sử dụng biểu thức lambda, chúng ta có thể sử dụng method reference để tham chiếu trực tiếp tới các phương thức hoặc constructor. Đây là một cách khác để khởi tạo functional interface mà không cần viết biểu thức lambda.

```java
import java.util.function.Consumer;

public class App {
    public static void main(String[] args) {
        // Sử dụng biểu thức lambda
        Consumer<String> print = str -> System.out.println(str);
        print.accept("Hello Tây Java");

        // Sử dụng tham chiếu phương thức
        Consumer<String> printMethodReference = System.out::println;
        printMethodReference.accept("Welcome Tây Java");
    }
}

```

### 5. Functional Interface và Default Methods
Mặc dù functional interface chỉ có một phương thức trừu tượng, nhưng chúng có thể chứa default methods và static methods. Những phương thức này không vi phạm tính chất của functional interface, vì chúng đã được cung cấp sẵn định nghĩa.

Một Functional Interface có thể chứa các `default method` và `static method`
```java
@FunctionalInterface
public interface SampleFunctionalInterface {
    void doSomething();

    static void doSomethingElse() {
        System.out.println("Do something else");
    }

    default void printMessage() {
        System.out.println("Sample Functional Interface");
    }

    default void welcome() {
        System.out.println("Welcome to Tây Java");
    }
}
```

---
## Câu hỏi phỏng vấn

