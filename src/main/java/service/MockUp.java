package src.main.java.service;

import src.main.java.model.Order;

import java.util.ArrayList;
import java.util.List;

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
