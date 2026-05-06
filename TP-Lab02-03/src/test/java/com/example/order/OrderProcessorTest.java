package com.example.order;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the refactored OrderProcessor class (Lab 03 - Extract Method).
 * These tests verify that the refactoring (extracting calculateTotalPrice,
 * applyDiscount, printSummary, printItems) did NOT change the external behavior.
 */
public class OrderProcessorTest {

    private ByteArrayOutputStream outputStream;
    private OrderProcessor processor;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        processor = new OrderProcessor();
    }

    @Test
    public void testPrintOrderSummaryForMember() {
        // Create test data using reflection since constructors are not available
        Customer customer = createCustomer("Alice", true);
        Item item1 = createItem("Widget", 10.0, 2);
        Item item2 = createItem("Gadget", 25.0, 1);
        Order order = createOrder(customer, Arrays.asList(item1, item2));

        processor.printOrderSummary(order);
        String output = outputStream.toString();

        assertTrue(output.contains("Order Summary:"), "Should print Order Summary header");
        assertTrue(output.contains("Customer: Alice"), "Should print customer name");
        assertTrue(output.contains("Items:"), "Should print Items header");
        assertTrue(output.contains("Widget"), "Should print item name Widget");
        assertTrue(output.contains("Gadget"), "Should print item name Gadget");
        // Total = (10*2 + 25*1) = 45, with 10% discount = 40.50
        assertTrue(output.contains("40.50"), "Should apply 10% member discount: $40.50");
    }

    @Test
    public void testPrintOrderSummaryForNonMember() {
        Customer customer = createCustomer("Bob", false);
        Item item1 = createItem("Widget", 10.0, 3);
        Order order = createOrder(customer, Arrays.asList(item1));

        processor.printOrderSummary(order);
        String output = outputStream.toString();

        assertTrue(output.contains("Customer: Bob"), "Should print customer name");
        // Total = 10*3 = 30, no discount
        assertTrue(output.contains("30.00"), "Non-member should not get discount: $30.00");
    }

    // Helper methods using reflection to create test objects
    // (since the model classes don't have public constructors)
    private Customer createCustomer(String name, boolean isMember) {
        try {
            Customer customer = Customer.class.getDeclaredConstructor().newInstance();
            var nameField = Customer.class.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(customer, name);
            var memberField = Customer.class.getDeclaredField("isMember");
            memberField.setAccessible(true);
            memberField.set(customer, isMember);
            return customer;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Customer", e);
        }
    }

    private Item createItem(String name, double price, int quantity) {
        try {
            Item item = Item.class.getDeclaredConstructor().newInstance();
            var nameField = Item.class.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(item, name);
            var priceField = Item.class.getDeclaredField("price");
            priceField.setAccessible(true);
            priceField.set(item, price);
            var quantityField = Item.class.getDeclaredField("quantity");
            quantityField.setAccessible(true);
            quantityField.set(item, quantity);
            return item;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Item", e);
        }
    }

    private Order createOrder(Customer customer, List<Item> items) {
        try {
            Order order = Order.class.getDeclaredConstructor().newInstance();
            var customerField = Order.class.getDeclaredField("customer");
            customerField.setAccessible(true);
            customerField.set(order, customer);
            var itemsField = Order.class.getDeclaredField("items");
            itemsField.setAccessible(true);
            itemsField.set(order, items);
            return order;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Order", e);
        }
    }
}
