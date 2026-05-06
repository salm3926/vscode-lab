package com.example.order;

public class OrderProcessor {
    public void printOrderSummary(Order order) {
        double totalPrice = calculateTotalPrice(order.getItems());


        totalPrice = applyDiscount(totalPrice, order.getCustomer().isMember());
        printSummary(order, totalPrice);
    }

    private double calculateTotalPrice(java.util.List<Item> items) {
        double totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        return totalPrice;
    }

    private double applyDiscount(double totalPrice, boolean isMember) {
        if (isMember) {
            return totalPrice * 0.9; // 10% discount for members
        }
        return totalPrice;
    }

    private void printSummary(Order order, double totalPrice) {
        System.out.println("Order Summary:");
        System.out.println("Customer: " + order.getCustomer().getName());
        printItems(order.getItems());
        System.out.printf("Total Price: $%.2f%n", totalPrice);
    }

    private void printItems(java.util.List<Item> items) {
        System.out.println("Items:");
        for (Item item : items) {
            System.out.println("  - " + item.getName() + ": " + item.getQuantity() + " x $" + item.getPrice() + " = $" + (item.getQuantity() * item.getPrice()));
        }
    }
}