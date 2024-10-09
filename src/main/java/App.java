package src.main.java;

import src.main.java.model.Order;
import src.main.java.service.MockUp;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
//        fetchDataToList();
//        convertingDataAsASet();
//        usingSum();
//        getAveragePrice();
//        countingOrderItems();
//        convertListToMap();
//        joinCharacter();

        stringJoiner();
    }

    private static void stringJoiner() {
        StringJoiner joiner1 = new StringJoiner(", ");
        joiner1.add("Iphone 14");
        joiner1.add("Iphone 14 Pro");
        joiner1.add("Samsung Galaxy");
        joiner1.add("Samsung Watch5");
        joiner1.add("MacBook pro");
        joiner1.add("Nokia 2630");
        System.out.println(joiner1);

        StringJoiner joiner2 = new StringJoiner(", ", "[", "]");
        joiner2.add("Apple");
        joiner2.add("Samsung");
        joiner2.add("Oppo");
        joiner2.add("Xiaomi");
        System.out.println(joiner2);

        StringJoiner joiner3 = new StringJoiner(", ");
        joiner3.setEmptyValue("No items");
        System.out.println(joiner3);

        joiner1.merge(joiner2);
        System.out.println(joiner1);

    }

    /**
     * join character
     */
    private static void joinCharacter() {
        List<Order> orderList = MockUp.orderList();
        List<String> productName = orderList.stream().map(Order::getProductName).collect(Collectors.toList());
        System.out.println("Product list: " + productName);

        String productNameString = orderList.stream().map(Order::getProductName).collect(Collectors.joining(", "));
        System.out.println("Product name: " + productNameString);
    }


    /**
     * Convert list to map
     */
    private static void convertListToMap() {
        List<Order> orderList = MockUp.orderList();

        Map<Integer, String> product = orderList.stream().collect(Collectors.toMap(order -> order.getProductId(), order -> order.getProductName()));
        product.forEach((integer, s) -> System.out.println(integer + "=" + s));
    }


    /**
     * Counting Elements
     */
    private static void countingOrderItems() {
        List<Order> orderList = MockUp.orderList();

        Long noOfElements = orderList.stream()
                .collect(Collectors.counting());
        System.out.println("Total elements : " + noOfElements);
    }

    /**
     * Getting Order Average Price
     */
    private static void getAveragePrice() {
        List<Order> orderList = MockUp.orderList();
        Double average = orderList.stream()
                .collect(Collectors.averagingDouble(p -> p.getPrice()));
        System.out.println("Average price is: " + average);
    }

    /**
     * Using SUM
     */
    private static void usingSum() {
        List<Order> orderList = MockUp.orderList();
        int totalQuantity = orderList.stream().collect(Collectors.summingInt(x -> x.getQuantity()));
        System.out.println("Total quantity: " + totalQuantity);

        double totalPrice = orderList.stream().collect(Collectors.summingDouble(x -> x.getPrice()));  // collecting as list
        System.out.println("Total price: " + totalPrice);
    }

    /**
     * Convert data to Set
     */
    private static void convertingDataAsASet() {
        List<Order> orderList = MockUp.orderList();
        Set<String> venders = orderList.stream().map(order -> order.getVendor()).collect(Collectors.toSet());
        System.out.println(venders);
    }

    /**
     * Fetching data to list
     */
    private static void fetchDataToList() {
        List<Order> orderList = MockUp.orderList();
        List<Double> productPrices =
                orderList.stream()
                        .map(order -> order.getPrice())         // fetching price
                        .collect(Collectors.toList());  // collecting as list
        System.out.println(productPrices);
    }
}
