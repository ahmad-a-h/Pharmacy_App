package com.example.pharmacy;

public class Product {
    private int pid;
    private String name;
    private int quantity;
    private Double price;


    public Product(int pid, String name, int quantity, Double price) {
        this.pid = pid;
        this.name = name;
        this.quantity = quantity;
        this.price = price;

    }

    @Override
    public String toString() {
        return "ID: " + pid +
                "\nName: " + name +
                "\nQuantity: " + quantity +
                "\nPrice: " + price     ;
    }
}

