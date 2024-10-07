# Java 8 Part 2
## 1. Stream API

Stream API trong Java 8 là một tính năng quan trọng trong gói java.util.stream, giúp xử lý các collections một cách tiện lợi và hiệu quả theo kiểu lập trình hàm. Thay vì sử dụng vòng lặp lồng nhau và nhiều dòng code phức tạp chúng ta có thể dùng Stream API. Chúng ta có thể biểu diễn thao tác trên tập dữ liệu qua các phương thức xử lý chuỗi gọn gàng hơn.

### 1.1 Stream là gì?
Stream đại diện cho một chuỗi các phần tử dữ liệu có thể được xử lý (chẳng hạn List, Set, hoặc Array) và các thao tác trên dữ liệu đó. Tuy nhiên, khác với Collection, Stream không lưu trữ dữ liệu mà chỉ xử lý luồng dữ liệu.

### 1.2 Tính chất của Stream API
Không thay đổi Collection ban đầu: Các thao tác trên Stream không làm thay đổi dữ liệu nguồn.
- Lazy execution: Các thao tác chỉ được thực thi khi có kết thúc luồng (terminal operation).
- Không lưu trữ: Stream không lưu trữ dữ liệu mà chỉ xử lý dữ liệu khi cần.
- Có thể xử lý song song: Stream API hỗ trợ xử lý song song với phương thức parallelStream(), giúp tăng tốc độ xử lý.

### 1.3 Các loại thao tác trong Stream API
Stream API có hai loại thao tác chính:
- Intermediate Operations (Các thao tác trung gian): Các thao tác này trả về một Stream khác và có thể xâu chuỗi nhiều thao tác lại với nhau. Ví dụ: filter(), map(), sorted(), distinct(), limit(), v.v.
- Terminal Operations (Các thao tác kết thúc): Các thao tác này kết thúc quá trình xử lý chuỗi và trả về kết quả (có thể là một giá trị hoặc collection). Ví dụ: forEach(), collect(), reduce(), count(), findFirst(), v.v.

### 1.4 Cách sử dụng Stream API
Một chuỗi các thao tác với Stream API bao gồm ba bước chính:
- Bước 1: Tạo Stream: Bạn có thể tạo một Stream từ các collection hoặc mảng với phương thức stream() hoặc parallelStream().
- Bước 2: Áp dụng Intermediate Operations: Các thao tác trung gian được áp dụng để xử lý dữ liệu (lọc, chuyển đổi, sắp xếp, v.v.).
- Bước 3: Áp dụng Terminal Operation: Kết thúc chuỗi thao tác và nhận kết quả cuối cùng.

### 1.5 Parallel Stream
Nếu bạn muốn xử lý dữ liệu song song để tận dụng nhiều luồng CPU hơn, có thể sử dụng `parallelStream()` thay vì `stream()`.

### 1.6 Ưu điểm của Stream API
- Mã nguồn gọn gàng, dễ hiểu: Thay vì viết các vòng lặp phức tạp, bạn có thể sử dụng các phương thức xử lý luồng mạch lạc và ngắn gọn.
- Dễ mở rộng: Có thể dễ dàng thêm các thao tác vào chuỗi xử lý dữ liệu mà không cần thay đổi quá nhiều mã nguồn.
- Hiệu suất cao: Stream API có thể tận dụng được việc xử lý song song để tăng hiệu năng với các tập dữ liệu lớn.

### 1.7 Java Stream Interface Methods
| #  | Method                                                                                             | Mô tả                                                                                                                                                                                                                                                                                                                                                                    |
|----|----------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1  | boolean allMatch(Predicate<? super T> predicate)                                                   | Nó trả về tất cả các phần tử của luồng này khớp với vị từ được cung cấp. Nếu luồng trống thì trả về true và vị từ không được đánh giá.                                                                                                                                                                                                                                   |
| 2  | boolean anyMatch(Predicate<? super T> predicate)                                                   | Nó trả về bất kỳ phần tử nào của luồng này khớp với vị từ được cung cấp. Nếu luồng trống thì trả về false và vị từ không được đánh giá.                                                                                                                                                                                                                                  |
| 3  | static <T> Stream.Builder<T> builder()                                                             | Nó trả về một trình xây dựng cho một Stream.                                                                                                                                                                                                                                                                                                                             |
| 4  | <R,A> R collect(Collector<? super T,A,R> collector)                                                | Nó thực hiện một hoạt động giảm có thể thay đổi trên các phần tử của luồng này bằng cách sử dụng Collector. Collector đóng gói các hàm được sử dụng làm đối số cho collect(Supplier, BiConsumer, BiConsumer), cho phép tái sử dụng các chiến lược thu thập và thành phần của các hoạt động thu thập như nhóm nhiều cấp hoặc phân vùng.                                   |
| 5  | <R> R collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner) | Nó thực hiện một hoạt động giảm có thể thay đổi trên các phần tử của luồng này. Giảm có thể thay đổi là hoạt động trong đó giá trị giảm là một bộ chứa kết quả có thể thay đổi, chẳng hạn như ArrayList và các phần tử được kết hợp bằng cách cập nhật trạng thái của kết quả thay vì thay thế kết quả.                                                                  |
| 6  | static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)                          | Nó tạo ra một luồng được nối lười biếng có các phần tử là tất cả các phần tử của luồng đầu tiên theo sau là tất cả các phần tử của luồng thứ hai. Luồng kết quả được sắp xếp nếu cả hai luồng đầu vào đều được sắp xếp và song song nếu một trong hai luồng đầu vào song song. Khi luồng kết quả được đóng, trình xử lý đóng cho cả hai luồng đầu vào sẽ được gọi.       |
| 7  | long count()                                                                                       | Nó trả về số lượng phần tử trong luồng này. Đây là trường hợp đặc biệt của phép giảm.                                                                                                                                                                                                                                                                                    |
| 8  | Stream<T> distinct()                                                                               | Nó trả về một luồng bao gồm các phần tử riêng biệt (theo Object.equals(Object)) của luồng này.                                                                                                                                                                                                                                                                           |
| 9  | static <T> Stream<T> empty()                                                                       | Nó trả về một Stream tuần tự rỗng.                                                                                                                                                                                                                                                                                                                                       |
| 10 | Stream<T> filter(Predicate<? super T> predicate)                                                   | Nó trả về một luồng bao gồm các phần tử của luồng này khớp với thuật ngữ đã cho.                                                                                                                                                                                                                                                                                         |
| 11 | Optional<T> findAny()                                                                              | Nó trả về một Optional mô tả một số phần tử của luồng hoặc một Optional trống nếu luồng trống.                                                                                                                                                                                                                                                                           |
| 12 | Optional<T> findFirst()                                                                            | Nó trả về Optional mô tả phần tử đầu tiên của luồng này hoặc Optional rỗng nếu luồng rỗng. Nếu luồng không có thứ tự gặp gỡ, thì bất kỳ phần tử nào cũng có thể được trả về.                                                                                                                                                                                             |
| 13 | <R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)                    | Nó trả về một luồng bao gồm các kết quả của việc thay thế từng phần tử của luồng này bằng nội dung của luồng được ánh xạ được tạo ra bằng cách áp dụng hàm ánh xạ được cung cấp cho từng phần tử. Mỗi luồng được ánh xạ sẽ được đóng lại sau khi nội dung của nó được đặt vào luồng này. (Nếu luồng được ánh xạ là null thì luồng rỗng sẽ được sử dụng thay thế.)        |
| 14 | DoubleStream flatMapToDouble(Function<? super T,? extends DoubleStream> mapper)                    | Nó trả về một DoubleStream bao gồm các kết quả của việc thay thế từng phần tử của luồng này bằng nội dung của luồng được ánh xạ được tạo ra bằng cách áp dụng hàm ánh xạ được cung cấp cho từng phần tử. Mỗi luồng được ánh xạ sẽ được đóng lại sau khi nội dung của nó được đặt vào luồng này. (Nếu luồng được ánh xạ là null thì luồng rỗng sẽ được sử dụng thay thế.) |
| 15 | IntStream flatMapToInt(Function<? super T,? extends IntStream> mapper)                             | Nó trả về một IntStream bao gồm các kết quả của việc thay thế từng phần tử của luồng này bằng nội dung của luồng được ánh xạ được tạo ra bằng cách áp dụng hàm ánh xạ được cung cấp cho từng phần tử. Mỗi luồng được ánh xạ sẽ được đóng lại sau khi nội dung của nó được đặt vào luồng này. (Nếu luồng được ánh xạ là null thì luồng rỗng sẽ được sử dụng thay thế.)    |
| 16 | LongStream flatMapToLong(Function<? super T,? extends LongStream> mapper)                          | Nó trả về một LongStream bao gồm các kết quả của việc thay thế từng phần tử của luồng này bằng nội dung của luồng được ánh xạ được tạo ra bằng cách áp dụng hàm ánh xạ được cung cấp cho từng phần tử. Mỗi luồng được ánh xạ sẽ được đóng lại sau khi nội dung của nó được đặt vào luồng này. (Nếu luồng được ánh xạ là null thì luồng rỗng sẽ được sử dụng thay thế.)   |
| 17 | void forEach(Consumer<? super T> action)                                                           | Nó thực hiện một hành động cho từng phần tử của luồng này.                                                                                                                                                                                                                                                                                                               |
| 18 | void forEachOrdered(Consumer<? super T> action)                                                    | Nó thực hiện một hành động cho từng phần tử của luồng này, theo thứ tự gặp phải của luồng nếu luồng có thứ tự gặp phải được xác định.                                                                                                                                                                                                                                    |
| 19 | static <T> Stream<T> generate(Supplier<T> s)                                                       | Nó trả về một luồng tuần tự vô hạn không theo thứ tự, trong đó mỗi phần tử được tạo ra bởi Nhà cung cấp được cung cấp. Điều này phù hợp để tạo luồng hằng số, luồng các phần tử ngẫu nhiên, v.v.                                                                                                                                                                         |
| 20 | static <T> Stream<T> iterate(T seed,UnaryOperator<T> f)                                            | Nó trả về một Stream tuần tự vô hạn được tạo ra bằng cách áp dụng lặp lại một hàm f vào phần tử hạt giống ban đầu, tạo ra một Stream bao gồm hạt giống, f(hạt giống), f(f(hạt giống)), v.v.                                                                                                                                                                              |
| 21 | Stream<T> limit(long maxSize)                                                                      | Nó trả về một luồng bao gồm các phần tử của luồng này, được cắt bớt để có độ dài không quá maxSize.                                                                                                                                                                                                                                                                      |
| 22 | <R> Stream<R> map(Function<? super T,? extends R> mapper)                                          | Nó trả về một luồng bao gồm các kết quả của việc áp dụng hàm đã cho vào các phần tử của luồng này.                                                                                                                                                                                                                                                                       |
| 23 | DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper)                                       | Nó trả về một DoubleStream bao gồm kết quả của việc áp dụng hàm đã cho vào các phần tử của luồng này.                                                                                                                                                                                                                                                                    |
| 24 | IntStream mapToInt(ToIntFunction<? super T> mapper)                                                | Nó trả về một IntStream bao gồm kết quả của việc áp dụng hàm đã cho vào các phần tử của luồng này.                                                                                                                                                                                                                                                                       |
| 25 | LongStream mapToLong(ToLongFunction<? super T> mapper)                                             | Nó trả về một LongStream bao gồm các kết quả của việc áp dụng hàm đã cho vào các phần tử của luồng này.                                                                                                                                                                                                                                                                  |
| 26 | Optional<T> max(Comparator<? super T> comparator)                                                  | Nó trả về phần tử lớn nhất của luồng này theo Comparator được cung cấp. Đây là trường hợp đặc biệt của phép giảm.                                                                                                                                                                                                                                                        |
| 27 | Optional<T> min(Comparator<? super T> comparator)                                                  | Nó trả về phần tử nhỏ nhất của luồng này theo Comparator được cung cấp. Đây là trường hợp đặc biệt của phép giảm.                                                                                                                                                                                                                                                        |
| 28 | boolean noneMatch(Predicate<? super T> predicate)                                                  | Nó trả về các phần tử của luồng này khớp với vị từ được cung cấp. Nếu luồng trống thì trả về true và vị từ không được đánh giá.                                                                                                                                                                                                                                          |
| 29 | @SafeVarargs static <T> Stream<T> of(T... values)                                                  | Nó trả về một luồng được sắp xếp tuần tự có các phần tử là các giá trị được chỉ định.                                                                                                                                                                                                                                                                                    |
| 30 | static <T> Stream<T> of(T t)                                                                       | Nó trả về một Stream tuần tự chứa một phần tử duy nhất.                                                                                                                                                                                                                                                                                                                  |
| 31 | Stream<T> peek(Consumer<? super T> action)                                                         | Nó trả về một luồng bao gồm các phần tử của luồng này, đồng thời thực hiện hành động được cung cấp trên mỗi phần tử khi các phần tử được sử dụng từ luồng kết quả.                                                                                                                                                                                                       |
| 32 | Optional<T> reduce(BinaryOperator<T> accumulator)                                                  | Nó thực hiện việc giảm các phần tử của luồng này bằng cách sử dụng hàm tích lũy liên kết và trả về một Optional mô tả giá trị đã giảm, nếu có.                                                                                                                                                                                                                           |
| 33 | T reduce(T identity, BinaryOperator<T> accumulator)                                                | Nó thực hiện việc giảm các phần tử của luồng này bằng cách sử dụng giá trị danh tính được cung cấp và một hàm tích lũy liên kết, rồi trả về giá trị đã giảm.                                                                                                                                                                                                             |
| 34 | <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)        | Nó thực hiện việc giảm các phần tử của luồng này bằng cách sử dụng các hàm nhận dạng, tích lũy và kết hợp được cung cấp.                                                                                                                                                                                                                                                 |
| 35 | Stream<T> skip(long n)                                                                             | Nó trả về một luồng bao gồm các phần tử còn lại của luồng này sau khi loại bỏ n phần tử đầu tiên của luồng. Nếu luồng này chứa ít hơn n phần tử thì một luồng rỗng sẽ được trả về.                                                                                                                                                                                       |
| 36 | Stream<T> sorted()                                                                                 | Nó trả về một luồng bao gồm các phần tử của luồng này, được sắp xếp theo thứ tự tự nhiên. Nếu các phần tử của luồng này không phải là Comparable, java.lang.ClassCastException có thể được ném ra khi thực hiện thao tác đầu cuối.                                                                                                                                       |
| 37 | Stream<T> sorted(Comparator<? super T> comparator)                                                 | Nó trả về một luồng bao gồm các phần tử của luồng này, được sắp xếp theo Bộ so sánh được cung cấp.                                                                                                                                                                                                                                                                       |
| 38 | Object[] toArray()                                                                                 | Nó trả về một mảng chứa các phần tử của luồng này.                                                                                                                                                                                                                                                                                                                       |
| 39 | <A> A[] toArray(IntFunction<A[]> generator)                                                        | Nó trả về một mảng chứa các phần tử của luồng này, sử dụng hàm tạo được cung cấp để phân bổ mảng được trả về, cũng như bất kỳ mảng bổ sung nào có thể cần thiết cho việc thực thi phân vùng hoặc để thay đổi kích thước.                                                                                                                                                 |

### 1.8 Ví dụ
- Tạo mockup data

class Order
```java
public class Order {
    private int id;
    private String productName;
    private String productType;

    private String vendor;
    private int quantity;
    private double price;

    public Order() {
    }

    public Order(int id, String productName, String productType, String vendor, int quantity, double price) {
        this.id = id;
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
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", vendor='" + vendor + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
```

class MockUp
```java
public class MockUp {

    public static List<Order> orderList() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Iphone 14", "Mobile", "Apple", 3, 580.25));
        orders.add(new Order(2, "Iphone 14 Pro", "Mobile", "Apple", 5, 699.99));
        orders.add(new Order(3, "Samsung Galaxy", "Mobile", "Samsung", 7, 32.45));
        orders.add(new Order(4, "Samsung Watch5", "Watch", "Samsung", 2, 230.21));
        orders.add(new Order(5, "MacBook pro", "Laptop", "Apple", 4, 233.25));
        orders.add(new Order(6, "Nokia 2630", "Mobile", "", 6, 100));
        return orders;
    }
}
```

- Thực hiện test các method của Stream API
```java
public class App {
    public static void main(String[] args) {
//        allMatch();
//        anyMatch();
//        noneMatch();
//        streamBuilder();
//        collect();
//        streamConcat();
//        distinct();
//        findAny();
//        findFirst();
//        flatMap();
//        generate();
//        common();
//        sort();
//        skip();
//        peek();
    }

    /**
     * boolean anyMatch(Predicate<? super T> predicate)
     * It returns all elements of this stream which match the provided predicate.
     * If the stream is empty then true is returned and the predicate is not evaluated.
     */
    private static void allMatch() {
        // get all product by type=Mobile
        List<Order> mobile = MockUp.orderList().stream().filter(order -> Objects.equals(order.getProductType(), "Mobile")).collect(Collectors.toList());

        System.out.println("Check Mobile");
        boolean isMobile = mobile.stream().allMatch(order -> Objects.equals(order.getProductType(), "Mobile"));
        if (isMobile) {
            System.out.println("All products are Mobile");
        }

    }

    /**
     * boolean allMatch(Predicate<? super T> predicate)
     * It returns any element of this stream that matches the provided predicate.
     * If the stream is empty then false is returned and the predicate is not evaluated.
     */
    private static void anyMatch() {
        boolean flag = MockUp.orderList().stream().anyMatch(product -> product.getProductName().equals("MacBook pro"));
        System.out.println(flag);
    }

    private static void noneMatch() {
        boolean check = MockUp.orderList().stream().noneMatch(order -> order.getPrice() > 800);
        if (check) {
            System.out.println("There is no order with price greater than 800");
        } else {
            System.out.println("There is order with price greater than 800");
        }
    }

    /**
     * static <T> Stream.Builder<T> builder()
     * It returns a builder for a Stream.
     */
    private static void streamBuilder() {
        Stream.Builder<String> builder = Stream.builder();
        Stream<String> stream = builder.add("Java").add("PHP").add("Python").build();
        stream.forEach(System.out::println);
    }

    private static void collect() {
        System.out.println("Collectors.toList(): All Samsung");
        List<Order> samsung = MockUp.orderList().stream().filter(order -> Objects.equals(order.getVendor(), "Samsung")).collect(Collectors.toList());
        System.out.println(samsung);

        System.out.println("\nCollectors.toSet(): All Vendors");
        Set<String> vendors = MockUp.orderList().stream().map(Order::getVendor).collect(Collectors.toSet());
        System.out.println(vendors);
    }

    /**
     * static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
     * It creates a lazily concatenated stream whose elements are all the elements of the first stream followed by all the elements of the second stream.
     * The resulting stream is ordered if both of the input streams are ordered, and parallel if either of the input streams is parallel.
     * When the resulting stream is closed, the close handlers for both input streams are invoked.
     */
    private static void streamConcat() {
        Stream<String> stream1 = Stream.of("Geeks");
        Stream<String> stream2 = Stream.of("GeeksQuiz");
        Stream<String> stream3 = Stream.of("GeeksforGeeks");
        Stream<String> stream4 = Stream.of("GFG");

        // concatenating all the Streams
        // with Stream.concat() function
        // and displaying the result
        Stream.concat(Stream.concat(Stream.concat(stream1, stream2), stream3), stream4)
                .forEach(System.out::println);
    }

    /**
     * Stream<T> distinct()
     * It returns a stream consisting of the distinct elements (according to Object.equals(Object)) of this stream.
     */
    private static void distinct() {
        List<String> productType = MockUp.orderList().stream().map(Order::getProductType).distinct().collect(Collectors.toList());
        System.out.println(productType);
    }

    /**
     * Optional<T> findAny()
     * It returns an Optional describing some element of the stream, or an empty Optional if the stream is empty.
     */
    private static void findAny() {
        // instance new stream empty
        List<String> productType = MockUp.orderList().stream().map(Order::getProductType).distinct().collect(Collectors.toList());

        Optional<String> check = productType.stream().findAny();

        if (check.isPresent()) {
            productType.forEach(System.out::println);
        } else {
            System.out.println("ProductType not exist");
        }
    }

    /**
     * Optional<T> findFirst()
     * It returns an Optional describing the first element of this stream, or an empty Optional if the stream is empty.
     * If the stream has no encounter order, then any element may be returned.
     */
    private static void findFirst() {
        Optional<Order> first = MockUp.orderList().stream().findFirst();
        first.ifPresent(System.out::println);
    }

    /**
     * <R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)
     * It returns a stream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying
     * the provided mapping function to each element. Each mapped stream is closed after its contents have been placed into this stream.
     * (If a mapped stream is null an empty stream is used, instead.)
     */
    private static void flatMap() {
        List<Order> orders = MockUp.orderList();
        List<String> productName = orders.stream().map(Order::getProductName).collect(Collectors.toList());
        List<String> productType = orders.stream().map(Order::getProductType).collect(Collectors.toList());

        List<List<String>> product = new ArrayList<>();
        product.add(productName);
        product.add(productType);

        System.out.println("Distinct all product type");
        product.stream().flatMap(list -> list.stream().distinct()).forEach(System.out::println);

        System.out.println("\nTotal price");
        double total = MockUp.orderList().stream()
                .map(Order::getPrice)
                .flatMapToDouble(DoubleStream::of).sum();
        System.out.println(total);

        System.out.println("Print first character");
        productName.stream().flatMap(s -> Stream.of(s.toUpperCase().charAt(0))).forEach(System.out::println);
    }

    /**
     * static <T> Stream<T> generate(Supplier<T> s)
     * It returns an infinite sequential unordered stream where each element is generated by the provided Supplier.
     * This is suitable for generating constant streams, streams of random elements, etc.
     */
    private static void generate() {
        Stream.generate(new Random()::nextInt).limit(10).forEach(System.out::println);
        Stream.generate(new Random()::nextDouble).limit(3).forEach(System.out::println);
    }

    private static void common() {
        List<Order> personList = MockUp.orderList();
        //        System.out.println("\n-- Sum salary --");
        double totalSalary1 = personList.stream().mapToDouble(Order::getPrice).sum();
        System.out.println("Sum by Lambda: " + totalSalary1);
        Double totalSalary2 = personList.stream().map(Order::getPrice)
                .reduce(0.0d, Double::sum);
        System.out.println("Sum by reduce, Double::sum: " + totalSalary2);

        Double totalSalary3 = personList.stream().map(Order::getPrice).reduce(0.0d, (sum, salary) -> sum + salary);
        System.out.println("Sum by reduce, Lambda " + totalSalary3);

        Double totalSalary4 = personList.stream().collect(Collectors.summingDouble(Order::getPrice));
        System.out.println("Sum by Collectors.summingDouble: " + totalSalary4);


        System.out.println("\n-- Max salary --");
        System.out.println(personList.stream().mapToDouble(Order::getPrice).max().getAsDouble());

        System.out.println("\n-- Min salary --");
        System.out.println(personList.stream().mapToDouble(Order::getPrice).min().getAsDouble());

        System.out.println("\n-- Average salary --");
        System.out.println(personList.stream().mapToDouble(Order::getPrice).average().getAsDouble());

    }

    /**
     * Sort all element follow alphabet
     */
    private static void sort() {
        MockUp.orderList().stream().map(Order::getProductName).sorted().forEach(System.out::println);
    }

    /**
     * Stream<T> skip(long n)
     * It returns a stream consisting of the remaining elements of this stream after discarding the first n elements of the stream.
     * If this stream contains fewer than n elements then an empty stream will be returned.
     */
    private static void skip() {
        MockUp.orderList().stream().skip(1).forEach(System.out::println);
    }

    private static void peek() {
        MockUp.orderList().stream()
                .peek(order -> order.setProductName(order.getProductName().toUpperCase())).forEach(System.out::println);
    }
}
```

























---
## Câu hỏi phỏng vấn

#### 1. Stream API trong Java là gì?
**Trả lời:** Stream API là một tính năng được giới thiệu trong Java 8, cung cấp cách thức để xử lý các tập hợp dữ liệu theo phong cách lập trình hàm. Stream cho phép xử lý dữ liệu dạng tuần tự và song song.
#### 2. Sự khác biệt giữa Collection và Stream là gì?
**Trả lời:**
- Collection: Lưu trữ các phần tử dữ liệu và có thể thực hiện các thao tác trên toàn bộ hoặc một phần của tập dữ liệu đó.
- Stream: Không lưu trữ dữ liệu mà chỉ đại diện cho các phần tử tính toán và cung cấp cách để xử lý chúng một cách tuần tự hoặc song song. Stream có thể là vô hạn và chỉ xử lý dữ liệu khi cần.
#### 3. Các loại thao tác có trong Stream là gì?
**Trả lời:** Stream có hai loại thao tác:
- Intermediate Operations (Thao tác trung gian): Trả về một Stream khác sau khi xử lý (ví dụ: map(), filter(), sorted()).
- Terminal Operations (Thao tác kết thúc): Trả về một giá trị hoặc một collection và kết thúc quá trình xử lý Stream (ví dụ: collect(), forEach(), reduce()).
#### 4. Sự khác nhau giữa map() và flatMap() là gì?
**Trả lời:**
- map(): Dùng để biến đổi từng phần tử trong Stream thành một đối tượng khác. Nó trả về một Stream chứa các đối tượng mới.
- flatMap(): Dùng để biến đổi từng phần tử thành một Stream mới, sau đó gộp tất cả các Stream con thành một Stream duy nhất.
#### 5. Bạn có thể giải thích sự khác biệt giữa findFirst() và findAny()?
**Trả lời:**
- findFirst(): Trả về phần tử đầu tiên trong Stream, nếu có.
- findAny(): Trả về bất kỳ phần tử nào trong Stream (dùng đặc biệt trong xử lý song song để cải thiện hiệu năng).
#### 6. Stream API hỗ trợ xử lý song song như thế nào?
**Trả lời:** Stream API hỗ trợ xử lý song song qua phương thức parallelStream(). Khi sử dụng parallelStream(), các phần tử được xử lý đồng thời trên nhiều luồng CPU, giúp tăng tốc độ xử lý dữ liệu với các tập hợp lớn.
#### 7. filter() hoạt động như thế nào trong Stream?
**Trả lời:** filter() là một thao tác trung gian dùng để lọc các phần tử trong Stream dựa trên điều kiện (predicate). Nó trả về một Stream mới chứa các phần tử thỏa mãn điều kiện.
#### 8. Sự khác nhau giữa forEach() và forEachOrdered() là gì?
**Trả lời:**
- forEach(): Duyệt qua tất cả các phần tử của Stream và thực thi hành động, không đảm bảo thứ tự khi chạy song song.
- forEachOrdered(): Duyệt qua các phần tử của Stream và thực hiện hành động theo đúng thứ tự của Stream, ngay cả khi chạy song song.
#### 9. Bạn có thể giải thích về reduce() trong Stream không?
**Trả lời:** reduce() là một thao tác kết thúc trong Stream, dùng để kết hợp các phần tử lại với nhau theo một quy tắc nào đó (ví dụ: tính tổng, tính tích, tìm giá trị lớn nhất, v.v.). Nó trả về một giá trị duy nhất sau khi đã gộp toàn bộ các phần tử.
#### 10. Làm thế nào để thu thập các phần tử của Stream vào một List, Set hoặc Map?
**Trả lời:** Bạn có thể sử dụng collect() với bộ thu (Collector) tương ứng:
- Collectors.toList() thu thập các phần tử thành List.
- Collectors.toSet() thu thập các phần tử thành Set.
- Collectors.toMap() thu thập các phần tử thành Map.
#### 11. Stream có thể lặp qua nhiều lần không?
**Trả lời:** Không, một Stream chỉ có thể được sử dụng một lần. Sau khi thực hiện thao tác kết thúc (terminal operation), Stream sẽ bị "đóng" và không thể được sử dụng lại. Nếu muốn xử lý lại, bạn cần tạo Stream mới từ nguồn dữ liệu.
#### 12. Điều gì sẽ xảy ra nếu bạn gọi thao tác kết thúc nhiều lần trên một Stream?
**Trả lời:** Bạn sẽ gặp IllegalStateException. Một Stream chỉ có thể có một thao tác kết thúc. Khi gọi thao tác kết thúc lần thứ hai, exception này sẽ được ném ra.
#### 13. Bạn có thể giải thích về peek() trong Stream không?
**Trả lời:** peek() là một thao tác trung gian chủ yếu được sử dụng cho mục đích gỡ lỗi. Nó cho phép bạn kiểm tra hoặc làm điều gì đó với từng phần tử trong Stream mà không thay đổi dữ liệu hoặc kết quả của Stream.
#### 14. Stream có xử lý các phần tử trùng lặp không?
**Trả lời:** Stream có thể xử lý các phần tử trùng lặp, nhưng nếu bạn muốn loại bỏ các phần tử trùng lặp, bạn có thể sử dụng phương thức distinct().
#### 15. Bạn có thể sử dụng Stream với I/O (Input/Output) không?
**Trả lời:** Có, bạn có thể sử dụng Stream để xử lý các tệp tin hoặc luồng dữ liệu. Ví dụ, bạn có thể sử dụng Files.lines() để đọc từng dòng của một tệp và xử lý chúng với Stream API.
#### 16. Lợi ích chính của Stream API là gì?
**Trả lời:** Stream API giúp mã nguồn ngắn gọn, dễ đọc, hỗ trợ xử lý tuần tự và song song, tận dụng sức mạnh của lập trình hàm, giảm thiểu lỗi do vòng lặp phức tạp và tăng hiệu năng khi xử lý tập dữ liệu lớn.
#### 17. Stream API có ảnh hưởng đến hiệu suất không?
**Trả lời:** Stream API được tối ưu hóa để hiệu suất tốt hơn so với các vòng lặp thông thường trong nhiều trường hợp, đặc biệt khi xử lý song song với parallelStream(). Tuy nhiên, với các tập dữ liệu nhỏ, đôi khi việc sử dụng vòng lặp thông thường lại nhanh hơn do chi phí của việc tạo Stream.
#### 18. Khi nào nên sử dụng parallelStream() thay vì stream()?
**Trả lời:** Bạn nên sử dụng parallelStream() khi làm việc với tập dữ liệu lớn và khi có các tác vụ tính toán nặng mà có thể chia nhỏ và xử lý song song một cách độc lập. Tuy nhiên, không phải mọi trường hợp đều phù hợp với việc xử lý song song do chi phí tạo các luồng (threads) và đồng bộ dữ liệu.