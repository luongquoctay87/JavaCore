package src.main.java;

import com.sun.jdi.Value;
import src.main.java.model.Order;
import src.main.java.service.MockUp;

import java.util.*;

public class App {
    public static void main(String[] args) {

//        List<String> list = new ArrayList<>();
//        list.add("A"); // 0
//        list.add("B"); // 1
//        list.add("C"); // 2
//        list.add("D"); // 3
//        list.add("E"); // 4
//        list.add("F"); // 5
//
////        if (list.isEmpty()) {
////            System.out.println("List is empty");
////        } else {
////            System.out.println(list);
////        }
//
//        System.out.println(list.subList(2, 4));


//        List<String> linkedList = new LinkedList<>();
//        linkedList.add("A"); // 0 = node {vi tri cua phan tu truoc no, vi tri cua no , vi tri cua phan tu sau no}
//        linkedList.add("Y"); // 1
//        linkedList.add("E"); // 2
//        //linkedList.add("D"); // 3
//        linkedList.add("E"); // 4
//        linkedList.add("X"); // 5
//
//        linkedList.sort(String::compareTo);
//        System.out.println(linkedList);

        List<Order> orderList = MockUp.orderList();

//        List<String> vendor = orderList.stream().map(Order::getVendor).distinct().toList();
//        System.out.println(vendor);

//        Set<String> vendorSet = new HashSet<>();
//        for (Order order : orderList) {
//            vendorSet.add(order.getVendor());
//            System.out.println("---> " + order.getVendor());
//        }

        System.out.println("================");
        // System.out.println("Vendor List: " + vendorSet);

//        TreeMap<String, Integer> vendorMap = new TreeMap<>();
//        for (Order order : orderList) {
//            vendorMap.put(order.getVendor(), order.getQuantity());
//        }
//
//        System.out.println(vendorMap);


//        TreeSet treeSet = new TreeSet();
//        for (Order order : orderList) {
//            treeSet.add(order.getVendor());
//        }
//
//        System.out.println(treeSet);

//        ArrayDeque<Object> vendors = new ArrayDeque<>();
//        vendors.push("Sam");
//        vendors.push("Bob");
//        vendors.push("Alice");
//        vendors.push(1);
//
//        for (Object vendor : vendors) {
//            System.out.println(vendor);
//        }
//        Stack stack = new Stack();
//        stack.push(1);
//        stack.push(2);
//        stack.push("qwqwqwq");
//        stack.push(4);
//        stack.push(5);
//
//        System.out.println(stack.pop());
//        System.out.println(stack.peek());

    }
}
