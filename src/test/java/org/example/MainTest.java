package org.example;

import java.util.HashMap;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private HashMap<String, Integer> inventory = new HashMap<>();

    @Test
    void shouldAddProductCorrectly() {
        boolean success = Main.addProduct(inventory, "Banana", 30);
        assertTrue(success);
    }

    @Test
    void shouldAddProductIfQuantityIsZero() {
        boolean success = Main.addProduct(inventory, "Mango", 0);
        assertTrue(success);
    }

    @Test
    void shouldAddProductIfProductHasDuplicates() {
        Main.addProduct(inventory, "Milk",  50);
        boolean success = Main.addProduct(inventory, "Milk", 32);
        assertTrue(success);
    }

    @Test
    void shouldViewProductCorrectly() {
        Main.addProduct(inventory, "Milk", 20);
        boolean success = Main.checkProduct(inventory, "Milk");
        assertTrue(success);
    }

    @Test
    void shouldNotViewProductCorrectly() {
        boolean success = Main.checkProduct(inventory, "Ice Cream");
        assertFalse(success);
    }

    @Test
    void shouldUpdateProductWithValidInput() {
        Main.addProduct(inventory, "Bread", 10);
        boolean success = Main.updateStock(inventory, "Bread", 32);
        assertTrue(success);
    }

    @Test
    void shouldNotUpdateProductWithInvalidInput() {
        boolean success = Main.updateStock(inventory, "Tofu", 55);
        assertFalse(success);
    }

    @Test
    void shouldRemoveProductCorrectly() {
        String productName = "Eggs";
        Main.addProduct(inventory, productName, 50);
        Main.removeProduct(inventory, productName);
        boolean success = inventory.containsKey(productName);
        assertFalse(success);
    }

    @Test
    void shouldNotRemoveProductWithInvalidInput() {
        boolean success = Main.removeProduct(inventory, "Pizza");
        assertFalse(success);
    }
}