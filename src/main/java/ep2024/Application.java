package ep2024;

import ep2024.entities.Customer;
import ep2024.entities.Order;
import ep2024.entities.Product;

import java.util.ArrayList;
import java.util.List;

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
        for (int i = 0; i < 10; i++) {
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
    }
}
