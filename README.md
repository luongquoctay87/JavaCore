# Java 8 Part 3
## 1. Java Collectors
### 1. Đình nghĩa
Collectors trong Java là một lớp tiện ích trong gói java.util.stream được sử dụng để thực hiện các thao tác giảm (reduction) trên các phần tử của một Stream. Nó được sử dụng chủ yếu với API Stream để thu thập các phần tử của stream thành các dạng kết quả khác nhau như List, Set, Map, hoặc thực hiện các thao tác tổng hợp, thống kê.

Lớp Collectors cung cấp nhiều phương thức tĩnh giúp chúng ta thực hiện các phép biến đổi và thu thập dữ liệu từ stream. Các phương thức này trả về một đối tượng Collector, đại diện cho chiến lược thu thập dữ liệu cụ thể.

### 2. Các phương thức của Collectors

| #  | Method                                                                                                                                                                                                                                | Mô tả                                                                                                                                                                                                                                                                                                                                                                                 |
|----|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1  | public static <T> Collector<T,?,Double> averageDouble(ToDoubleFunction<? super T> mapper)                                                                                                                                             | Nó trả về một Collector tạo ra giá trị trung bình số học của một hàm có giá trị kép được áp dụng cho các phần tử đầu vào. Nếu không có phần tử nào, kết quả là 0.                                                                                                                                                                                                                     |
| 2  | public static <T> Collector<T,?,Double> averageDouble(ToDoubleFunction<? super T> mapper)                                                                                                                                             | Nó trả về một Collector thực hiện việc giảm các phần tử đầu vào của nó theo một BinaryOperator được chỉ định bằng cách sử dụng danh tính được cung cấp.                                                                                                                                                                                                                               |
| 3  | public static <T> Collector<T,?,Optional<T>> reducing(BinaryOperator<T> op)                                                                                                                                                           | Nó trả về một Collector thực hiện việc giảm các phần tử đầu vào của nó theo một BinaryOperator được chỉ định. Kết quả được mô tả là Optional<T>.                                                                                                                                                                                                                                      |
| 4  | public static <T,U> Collector<T,?,U> reducing(U identity, Function<? super T,? extends U> mapper, BinaryOperator<U> op)                                                                                                               | Nó trả về một Collector thực hiện việc giảm các phần tử đầu vào của nó theo một hàm ánh xạ được chỉ định và BinaryOperator. Đây là một tổng quát của reduction(Object, BinaryOperator) cho phép chuyển đổi các phần tử trước khi giảm.                                                                                                                                                |
| 5  | public static <T,K> Collector<T,?,Map<K,List<T>>> groupingBy(Function<? super T,? extends K> classifier)                                                                                                                              | Nó trả về một Collector thực hiện thao tác "nhóm theo" trên các phần tử đầu vào có kiểu T, nhóm các phần tử theo một hàm phân loại và trả về kết quả trong một Map.                                                                                                                                                                                                                   |
| 6  | public static <T,K,A,D> Collector<T,?,Map<K,D>> groupingBy(Function<? super T,? extends K> classifier, Collector<? Super T,A,D> downstream)                                                                                           | Nó trả về một Collector thực hiện thao tác "nhóm theo" theo tầng trên các phần tử đầu vào có kiểu T, nhóm các phần tử theo một hàm phân loại, sau đó thực hiện thao tác rút gọn trên các giá trị được liên kết với một khóa nhất định bằng cách sử dụng Collector hạ lưu đã chỉ định.                                                                                                 |
| 7  | public static <T,K,D,A,M extends Map<K,D>> Collector<T,?,M> groupingBy(Function<? super T,? extends K> classifier, Supplier<M> mapFactory, Collector<? super T,A,D> downstream)                                                       | Nó trả về một Collector thực hiện một hoạt động "nhóm theo" theo tầng trên các phần tử đầu vào thuộc loại T, nhóm các phần tử theo một hàm phân loại, sau đó thực hiện một hoạt động giảm trên các giá trị được liên kết với một khóa nhất định bằng cách sử dụng Collector hạ lưu đã chỉ định. Bản đồ do Collector tạo ra được tạo bằng hàm nhà máy được cung cấp.                   |
| 8  | public static <T,K> Collector<T,?,ConcurrentMap<K,List<T>>> groupingByConcurrent(Function<? super T,? extends K> classifier)                                                                                                          | Nó trả về một Collector đồng thời triển khai hoạt động "nhóm theo" trên các phần tử đầu vào thuộc kiểu T, nhóm các phần tử theo một hàm phân loại.                                                                                                                                                                                                                                    |
| 9  | public static <T,K,A,D> Collector<T,?,ConcurrentMap<K,D>> groupingByConcurrent(Function<? super T,? extends K> classifier, Collector<? super T,A,D> downstream)                                                                       | Nó trả về một Collector đồng thời triển khai hoạt động "nhóm theo" theo tầng trên các phần tử đầu vào thuộc kiểu T, nhóm các phần tử theo một hàm phân loại, sau đó thực hiện hoạt động rút gọn trên các giá trị được liên kết với một khóa nhất định bằng cách sử dụng Collector hạ lưu đã chỉ định.                                                                                 |
| 10 | public static <T,K,A,D,M extends ConcurrentMap<K,D>> Collector<T,?,M> groupingByConcurrent(Function<? super T,? extends K> classifier, Supplier<M> mapFactory, Collector<? super T,A,D> downstream)                                   | Nó trả về một Collector đồng thời triển khai một hoạt động "nhóm theo" theo tầng trên các phần tử đầu vào thuộc loại T, nhóm các phần tử theo một hàm phân loại, sau đó thực hiện một hoạt động giảm trên các giá trị được liên kết với một khóa nhất định bằng cách sử dụng Collector hạ lưu đã chỉ định. ConcurrentMap do Collector tạo ra được tạo bằng hàm nhà máy được cung cấp. |
| 11 | public static <T> Collector<T,?,Map<Boolean,List<T>>> partitioningBy(Predicate<? super T> predicate)                                                                                                                                  | Nó trả về một Collector phân vùng các phần tử đầu vào theo một Predicate và sắp xếp chúng thành một Map<Boolean, List<T>>. Không có đảm bảo nào về kiểu, khả năng thay đổi, khả năng tuần tự hóa hoặc tính an toàn của luồng của Map được trả về.                                                                                                                                     |
| 12 | public static <T,D,A> Collector<T,?,Map<Boolean,D>> partitioningBy(Predicate<? super T> predicate, Collector<? Super T,A,D> downstream)                                                                                               | Nó trả về một Collector phân vùng các phần tử đầu vào theo một Predicate, giảm các giá trị trong mỗi phân vùng theo một Collector khác và sắp xếp chúng thành một Map<Boolean, D> có các giá trị là kết quả của quá trình giảm dần.                                                                                                                                                   |
| 13 | public static <T,K,U> Collector<T,?,Map<K,U>> toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper)                                                                                           | Nó trả về một Collector tích lũy các phần tử vào một Map có khóa và giá trị là kết quả của việc áp dụng các hàm ánh xạ được cung cấp cho các phần tử đầu vào.                                                                                                                                                                                                                         |
| 14 | public static <T,K,U> Collector<T,?,Map<K,U>> toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction)                                                          | Nó trả về một Collector tích lũy các phần tử vào một Map có khóa và giá trị là kết quả của việc áp dụng các hàm ánh xạ được cung cấp cho các phần tử đầu vào.                                                                                                                                                                                                                         |
| 15 | public static <T,K,U,M extends Map<K,U>> Collector<T,?,M> toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction, Supplier<M> mapSupplier)                     | Nó trả về một Collector tích lũy các phần tử vào một Map có khóa và giá trị là kết quả của việc áp dụng các hàm ánh xạ được cung cấp cho các phần tử đầu vào.                                                                                                                                                                                                                         |
| 16 | public static <T,K,U> Collector<T,?,ConcurrentMap<K,U>> toConcurrentMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper)                                                                       | Nó trả về một Collector đồng thời tích lũy các phần tử vào một ConcurrentMap có khóa và giá trị là kết quả của việc áp dụng các hàm ánh xạ được cung cấp cho các phần tử đầu vào.                                                                                                                                                                                                     |
| 17 | public static <T,K,U> Collector<T,?,ConcurrentMap<K,U>> toConcurrentMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction)                                      | Nó trả về một Collector đồng thời tích lũy các phần tử vào một ConcurrentMap có khóa và giá trị là kết quả của việc áp dụng các hàm ánh xạ được cung cấp cho các phần tử đầu vào.                                                                                                                                                                                                     |
| 18 | public static <T,K,U,M extends ConcurrentMap<K,U>> Collector<T,?,M> toConcurrentMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction, Supplier<M> mapSupplier) | Nó trả về một Collector đồng thời tích lũy các phần tử vào một ConcurrentMap có khóa và giá trị là kết quả của việc áp dụng các hàm ánh xạ được cung cấp cho các phần tử đầu vào.                                                                                                                                                                                                     |
| 19 | public static <T> Collector<T,?,IntSummaryStatistics> summarizingInt(ToIntFunction<? super T> mapper)                                                                                                                                 | Nó trả về một Collector áp dụng hàm ánh xạ tạo ra int cho mỗi phần tử đầu vào và trả về số liệu thống kê tóm tắt cho các giá trị kết quả.                                                                                                                                                                                                                                             |
| 20 | public static <T> Collector<T,?,LongSummaryStatistics> summarizingLong(ToLongFunction<? super T> mapper)                                                                                                                              | Nó trả về một Collector áp dụng hàm ánh xạ tạo ra giá trị dài cho mỗi phần tử đầu vào và trả về số liệu thống kê tóm tắt cho các giá trị kết quả.                                                                                                                                                                                                                                     |
| 21 | public static <T> Collector<T,?,DoubleSummaryStatistics> summarizingDouble(ToDoubleFunction<? super T> mapper)                                                                                                                        | Nó trả về một Collector áp dụng hàm ánh xạ tạo ra giá trị kép cho mỗi phần tử đầu vào và trả về số liệu thống kê tóm tắt cho các giá trị kết quả.                                                                                                                                                                                                                                     |

### 3. Sample code

#### 1. Tạo data test

- class Order
```java
public class Order {
    private int id;
    private int productId;
    private String productName;
    private String productType;

    private String vendor;
    private int quantity;
    private double price;

    public Order() {
    }

    public Order(int id, int productId, String productName, String productType, String vendor, int quantity, double price) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.vendor = vendor;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isVendor() {
        return vendor.isBlank();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", vendor='" + vendor + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
```
- class MockUp
```java
public class MockUp {

    public static List<Order> orderList() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, 101, "Iphone 14", "Mobile", "Apple", 3, 580.25));
        orders.add(new Order(2, 102, "Iphone 14 Pro", "Mobile", "Apple", 5, 699.99));
        orders.add(new Order(3, 103, "Samsung Galaxy", "Mobile", "Samsung", 7, 32.45));
        orders.add(new Order(4, 104, "Samsung Watch5", "Watch", "Samsung", 2, 230.21));
        orders.add(new Order(5, 105, "MacBook pro", "Laptop", "Apple", 4, 233.25));
        orders.add(new Order(6, 106, "Nokia 2630", "Mobile", "", 6, 100));
        return orders;
    }
}
```

#### 2. Ví dụ

- Fetching data to list
```java
public class App {
    public static void main(String[] args) {
        List<Order> orderList = MockUp.orderList();
        List<Double> productPrices =
                orderList.stream()
                        .map(order -> order.getPrice())         // fetching price
                        .collect(Collectors.toList());  // collecting as list
        System.out.println(productPrices);
    }
}
```

- Convert data to Set
```java
public class App {
    public static void main(String[] args) {
        List<Order> orderList = MockUp.orderList();
        Set<String> venders = orderList.stream().map(order -> order.getVendor()).collect(Collectors.toSet());
        System.out.println(venders);
    }
}
```

- Convert data to Map
```java
public class App {
    public static void main(String[] args) {
        List<Order> orderList = MockUp.orderList();
        Map<Integer, String> product = orderList.stream().collect(Collectors.toMap(order -> order.getProductId(), order -> order.getProductName()));
        product.forEach((integer, s) -> System.out.println(integer + "=" + s));
    }
}
```

- Using sum
```java
public class App {
    public static void main(String[] args) {
        List<Order> orderList = MockUp.orderList();
        int totalQuantity = orderList.stream().collect(Collectors.summingInt(x -> x.getQuantity()));
        System.out.println("Total quantity: " + totalQuantity);

        double totalPrice = orderList.stream().collect(Collectors.summingDouble(x -> x.getPrice()));  // collecting as list
        System.out.println("Total price: " + totalPrice);
    }
}
```

- Getting Order Average Price
```java
public class App {
    public static void main(String[] args) {
        List<Order> orderList = MockUp.orderList();
        Double average = orderList.stream()
                .collect(Collectors.averagingDouble(p -> p.getPrice()));
        System.out.println("Average price is: " + average);
    }
}
```

- Counting Elements
```java
public class App {
    public static void main(String[] args) {
        List<Order> orderList = MockUp.orderList();
        Long noOfElements = orderList.stream()
                .collect(Collectors.counting());
        System.out.println("Total elements : " + noOfElements);
    }
}
```

- Join character
```java
public class App {
    public static void main(String[] args) {
        List<Order> orderList = MockUp.orderList();
        List<String> productName = orderList.stream().map(Order::getProductName).collect(Collectors.toList());
        System.out.println("Product list: " + productName);

        String productNameString = orderList.stream().map(Order::getProductName).collect(Collectors.joining(", "));
        System.out.println("Product name: " + productNameString);
    }
}
```

## 2. StringJoiner class
### 2.1 StringJoiner là gì ?
StringJoiner trong Java là một lớp tiện ích được giới thiệu từ Java 8 để hỗ trợ nối các chuỗi với một ký tự phân cách tùy chọn giữa chúng, cùng với tùy chọn thêm tiền tố và hậu tố vào kết quả.

StringJoiner là một công cụ hữu ích giúp đơn giản hóa và tối ưu hóa việc nối chuỗi với ký tự phân cách, tiền tố và hậu tố, Nó mang lại sự linh hoạt và dễ sử dụng khi làm việc với các chuỗi trong Java.

### 2.2 Lợi ích của StringJoiner
- **Đơn giản hóa việc nối chuỗi:** Thay vì phải dùng các phép nối thủ công với điều kiện kiểm tra có nên thêm dấu phân cách hay không, StringJoiner giúp chúng ta tự động hóa quá trình này.
- **Tùy chọn thêm tiền tố và hậu tố:** Dễ dàng thêm các ký tự như dấu ngoặc vuông, dấu ngoặc đơn vào chuỗi đã nối.
- **Hiệu suất:** Trong một số trường hợp StringJoiner có thể hiệu quả hơn so với việc sử dụng chuỗi thông thường khi xử lý nối nhiều chuỗi với ký tự phân cách.

### StringJoiner Methods

| # | Method                                                     | Mô tả                                                                                                                                                                 |
|---|------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1 | Public StringJoiner add(CharSequence newElement)           | Thêm một bản sao của giá trị CharSequence đã cho làm phần tử tiếp theo của giá trị StringJoiner. Nếu newElement là null thì "null" sẽ được thêm vào.                  |
| 2 | Public StringJoiner merge(StringJoiner other)              | Thêm nội dung của StringJoiner đã cho mà không có tiền tố và hậu tố làm phần tử tiếp theo nếu nó không rỗng. Nếu StringJoiner đã cho rỗng lệnh gọi không có hiệu lực. |
| 3 | Public int length()                                        | Trả về độ dài của chuỗi biểu diễn của StringJoiner này.                                                                                                               |
| 4 | Public StringJoiner setEmptyValue(CharSequence emptyValue) | Thiết lập trình tự các ký tự được sử dụng khi xác định biểu diễn chuỗi của StringJoiner này và chưa có phần tử nào được thêm vào, tức là khi nó trống.                |

### 2.3 Cú pháp StringJoiner
- Cú pháp tạo một StringJoiner
```java
StringJoiner joiner1 = new StringJoiner(", ");
```

- Cú pháp có phân cách giữ tiền tố và hậu tố
```java
StringJoiner joiner2 = new StringJoiner(", ", "[", "]");
```

### 2.4 Ví dụ
- Nối các chuỗi với phân cách ,
```java
public class App {
    public static void main(String[] args) {
        StringJoiner joiner1 = new StringJoiner(", ");
        joiner1.add("Iphone 14");
        joiner1.add("Iphone 14 Pro");
        joiner1.add("Samsung Galaxy");
        joiner1.add("Samsung Watch5");
        joiner1.add("MacBook pro");
        joiner1.add("Nokia 2630");

        System.out.println(joiner1);
    }
}
```

- Nối chuỗi với phân cách tiền tố và hậu tố:
```java
public class App {
    public static void main(String[] args) {
        StringJoiner joiner2 = new StringJoiner(", ", "[", "]");
        joiner2.add("Apple");
        joiner2.add("Samsung");
        joiner2.add("Oppo");
        joiner2.add("Xiaomi");

        System.out.println(joiner2);
    }
}
```

- Sử dụng setEmptyValue()
Nếu không có bất kỳ chuỗi nào được thêm vào StringJoiner chúng ta có thể chỉ định một giá trị rỗng tùy chỉnh để hiển thị thay vì một chuỗi trống.
```java
public class App {
    public static void main(String[] args) {
        StringJoiner joiner3 = new StringJoiner(", ");
        joiner3.setEmptyValue("No items");
        System.out.println(joiner3);
    }
}
```

- Kết hợp hai StringJoiner
```java
public class App {
    public static void main(String[] args) {
        StringJoiner joiner1 = new StringJoiner(", ");
        joiner1.add("A");
        joiner1.add("B");
        joiner1.add("C");
        joiner1.add("D");
        joiner1.add("E");
        joiner1.add("F");

        StringJoiner joiner2 = new StringJoiner(", ", "[", "]");
        joiner2.add("1");
        joiner2.add("2");
        joiner2.add("3");
        joiner2.add("4");

        joiner1.merge(joiner2);
        System.out.println(joiner1);
    }
}
```

--
## 3. Câu hỏi phỏng vấn
### 1. StringJoiner
#### 1. StringJoiner trong Java là gì?
**Trả lời:** 
StringJoiner là một lớp trong Java được giới thiệu từ Java 8, giúp nối các chuỗi với một ký tự phân cách tùy chọn, cùng với khả năng thêm tiền tố và hậu tố vào chuỗi kết quả.

#### 2. Cách tạo đối tượng StringJoiner như thế nào?
**Trả lời:**  Có hai cách để tạo một đối tượng StringJoiner:
- Cung cấp ký tự phân cách: StringJoiner sj = new StringJoiner(", ");
- Cung cấp ký tự phân cách, tiền tố và hậu tố: StringJoiner sj = new StringJoiner(", ", "[", "]");

#### 3. Phân biệt StringJoiner và StringBuilder khi nối chuỗi?
**Trả lời:**
- StringJoiner: Tự động thêm phân cách giữa các chuỗi, có thể có tiền tố và hậu tố, chủ yếu để nối nhiều chuỗi với ký tự phân cách.
- StringBuilder: Được sử dụng để xây dựng chuỗi mà không thêm phân cách tự động, đòi hỏi thao tác thủ công nếu muốn thêm phân cách giữa các phần tử.

#### 4. Làm thế nào để thêm chuỗi vào StringJoiner?
**Trả lời:** Chúng ta có thể thêm chuỗi vào StringJoiner bằng phương thức add():
```java
StringJoiner s1 = new StringJoiner(", ");
s1.add("A");
s1.add("B");
```

#### 5. Nếu StringJoiner không chứa bất kỳ chuỗi nào, nó sẽ trả về kết quả gì?
**Trả lời:** Nếu StringJoiner không chứa chuỗi nào, phương thức toString() sẽ trả về một chuỗi rỗng hoặc có thể được tùy chỉnh bằng cách sử dụng phương thức setEmptyValue().
- Ví dụ:
```java
StringJoiner s2 = new StringJoiner(", ");
s2.setEmptyValue("No items");
System.out.println(s2.toString());  // Output: "No items"
```

#### 6. StringJoiner có thể kết hợp với nhau không? Nếu có, bằng cách nào?
**Trả lời:** Có, StringJoiner có thể kết hợp với nhau bằng phương thức merge(). Phương thức này kết hợp chuỗi từ hai StringJoiner khác nhau.
```java
StringJoiner s3 = new StringJoiner(", ");
s3.add("C");

StringJoiner s4 = new StringJoiner(", ");
s4.add("D");

s3.merge(s4);
```

#### 7. Lợi ích của việc sử dụng StringJoiner là gì?
**Trả lời:**
- Tự động thêm ký tự phân cách giữa các chuỗi mà không cần kiểm tra thủ công.
- Cho phép thêm tiền tố và hậu tố vào chuỗi cuối cùng.
- Cung cấp tùy chọn cho chuỗi rỗng nếu không có chuỗi nào được thêm vào.
- Hiệu quả khi xử lý việc nối nhiều chuỗi với phân cách.

#### 8. Cách sử dụng setEmptyValue() trong StringJoiner để làm gì?
**Trả lời:** Phương thức setEmptyValue() được sử dụng để thiết lập giá trị tùy chỉnh nếu không có chuỗi nào được thêm vào StringJoiner. Điều này giúp tránh việc trả về chuỗi rỗng.

#### 9. Điều gì xảy ra nếu chúng ta truyền một null vào phương thức add() của StringJoiner?
**Trả lời:** StringJoiner không cho phép thêm giá trị null. Nếu chúng ta cố gắng thêm null bằng phương thức add(), nó sẽ gây ra ngoại lệ NullPointerException.

#### 10. Chúng ta có thể sử dụng StringJoiner với các luồng (Stream) không?
**Trả lời:** Có, Chúng ta có thể sử dụng Collectors.joining() với Stream để thực hiện việc nối chuỗi tương tự như StringJoiner. 
- Ví dụ:
```java
List<String> names = Arrays.asList("A", "B", "C");
String result = names.stream().collect(Collectors.joining(", ", "[", "]"));
```

#### 11. StringJoiner có là immutable không?
**Trả lời:** Không, StringJoiner không phải là immutable. Chúng ta có thể tiếp tục thêm chuỗi vào StringJoiner sau khi tạo và thay đổi kết quả cuối cùng.






