package ep2024.entities;

import com.github.javafaker.Faker;

import java.util.Random;

public class Customer {
    private long id;
    private String name;
    private int tier;

    public Customer(String name, String s) {
        Random random = new Random();
        this.id = random.nextLong(100000000, 999999999);
        this.name = name;
        this.tier = random.nextInt(1, 4);
    }

    public static Customer createRandomCustomer() {
        Faker faker = new Faker();
        return new Customer(faker.dragonBall().character(), faker.name().lastName());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTier() {
        return tier;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }
}
