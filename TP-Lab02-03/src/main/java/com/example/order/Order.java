package com.example.order;

class Order {
    private Customer customer;
    private java.util.List<Item> items;

    public Customer getCustomer() {
        return customer;
    }

    public java.util.List<Item> getItems() {
        return items;
    }
}