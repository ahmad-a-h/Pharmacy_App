package com.example.pharmacy;

public class Product {
    private int pid;
    private String name;
    private int quantity;
    private double price;
    private String category;
    private int img;

    public Product(int img) {
        this.pid = pid;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;

    }

    @Override
    public String toString() {
        return "ID: " + pid +
                "\nName: " + name +
                "\nAvailable Quantity: " + quantity +
                "\nProduct Price: " + price +
                "\nCategory: " + category;
    }
    public int getImage() {
        return img;
    }
}
