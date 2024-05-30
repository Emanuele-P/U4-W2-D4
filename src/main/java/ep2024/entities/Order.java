package ep2024.entities;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {

    private long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;

    public Order(String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Customer customer) {
        Random random = new Random();
        this.id = random.nextLong(100000000, 999999999);
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }

    public static Order createRandomOrder(List<Product> availableProducts, List<Customer> listOfCustomers) {
        Faker faker = new Faker();
        Random random = new Random();

        String status = faker.options().option("Pending", "Shipped", "Delivered", "Cancelled");
        LocalDate orderDate = LocalDate.now().minusDays(random.nextInt(1, 60));
        LocalDate deliveryDate = orderDate.plusDays(random.nextInt(5, 15));

        Customer customer = listOfCustomers.get(random.nextInt(listOfCustomers.size()));
        int productI = random.nextInt(1, availableProducts.size() + 1);
        List<Product> products = new ArrayList<>(availableProducts.subList(random.nextInt(0, availableProducts.size()), random.nextInt(1, availableProducts.size())));

        return new Order(status, orderDate, deliveryDate, products, customer);
    }

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}
