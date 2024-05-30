package ep2024;

import ep2024.entities.Customer;
import ep2024.entities.Order;
import ep2024.entities.Product;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {

        List<Customer> customerList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            customerList.add(Customer.createRandomCustomer());
        }
        System.out.println("----------CUSTOMERS:");
        customerList.forEach(System.out::println);

        System.out.println();
        System.out.println("----------SHOP:");
        List<Product> shop = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            shop.add(Product.createRandomProduct());
        }
        shop.forEach(System.out::println);

        System.out.println();
        System.out.println("----------ORDERS:");
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            orders.add(Order.createRandomOrder(shop, customerList));
        }
        orders.forEach(System.out::println);

        System.out.println();
        System.out.println("----------EX1----------");
        Map<String, List<Customer>> orderByCustomer = customerList.stream()
                .collect(Collectors.groupingBy(customer -> customer.getName()));
        orderByCustomer.forEach((customerName, customers) -> {
            System.out.println("Customer: " + customerName + ", Orders: " + orders);
        });

        System.out.println();
        System.out.println("----------EX2----------");
        Map<String, Double> totalByCustomer = orders.stream()
                .collect(Collectors.groupingBy(order -> order.getCustomer().getName(),
                        Collectors.summingDouble(order -> order.getProducts().stream()
                                .mapToDouble(Product::getPrice)
                                .sum())));
        DecimalFormat df = new DecimalFormat("#,##");
        totalByCustomer.forEach((customerName, totalImport) -> {
            System.out.println("Customer: " + customerName + ", total import: " + df.format(totalImport) + "$");
        });

        System.out.println();
        System.out.println("----------EX3----------");
        OptionalDouble maxPrice = shop.stream().mapToDouble(Product::getPrice).max();
        if (maxPrice.isPresent()) {
            System.out.println("The most expensive item is: " + maxPrice.getAsDouble() + "$");
        } else {
            System.out.println("Empty list");
        }

        System.out.println();
        System.out.println("----------EX4----------");
        Double average = orders.stream().flatMap(order -> order.getProducts().stream())
                .collect(Collectors.averagingDouble((order -> order.getPrice())));
        System.out.println("Average import: " + df.format(average) + "$");

        System.out.println();
        System.out.println("----------EX5----------");
        Map<String, Double> pricePerCategory = shop.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.summingDouble(Product::getPrice)));
        pricePerCategory.forEach((category, totalImport) -> {
            System.out.println("Category: " + category + ", Total import: " + totalImport + "$");
        });
    }
}
