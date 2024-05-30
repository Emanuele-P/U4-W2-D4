package ep2024.entities;

import com.github.javafaker.Faker;

import java.util.Random;

public class Product {
    private long id;
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        Random random = new Random();
        this.id = random.nextLong(10000000, 99999999);
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public static Product createRandomProduct() {
        Faker faker = new Faker();
        String name = faker.commerce().productName();
        String category = faker.commerce().department();
        double price = Double.parseDouble(faker.commerce().price());
        return new Product(name, category, price);
    }

    public long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name= '" + name + '\'' +
                ", category= '" + category + '\'' +
                ", price= " + price + " $" +
                '}';
    }
}
