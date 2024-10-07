package src.main.java;

import src.main.java.model.Order;
import src.main.java.service.MockUp;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

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
