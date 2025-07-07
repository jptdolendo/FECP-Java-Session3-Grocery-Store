package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    // Displays the menu for the system
    private static void displayMenu() {
        System.out.println("--- Grocery Inventory Menu ---");
        System.out.println("1. View Inventory");
        System.out.println("2. Add Product");
        System.out.println("3. Check Product");
        System.out.println("4. Update Stock");
        System.out.println("5. Remove Product");
        System.out.println("6. Exit");
    }

    // Displays all items in the inventory
    private static void viewInventory(HashMap<String, Integer> inventory) {
        // Checks if inventory is empty
        if (inventory.isEmpty()) {
            System.out.println("Inventory empty!");
            return;
        }

        System.out.println("Current Inventory:");

        // Iterates on each item and print the item
        for (String key : inventory.keySet()) {
            System.out.println(key + " - " + inventory.get(key) + " pcs");
        }
    }

    // Adds a product to the inventory
    private static boolean addProduct(HashMap<String, Integer> inventory) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product name: ");
        String newProductName = scanner.nextLine();

        // Checks if the product already exists
        if (inventory.containsKey(newProductName)) {
            System.out.println("Product already exists, update it instead.");
            return false;
        }

        System.out.print("Enter quantity: ");
        int newProductQuantity = scanner.nextInt();
        scanner.nextLine();

        // Input is invalid if quantity is less than zero
        if (newProductQuantity < 0) {
            System.out.println("Invalid input. Product not added.");
            return false;
        }

        // Adds the item in the inventory if name and quantity is valid
        inventory.put(newProductName, newProductQuantity);
        System.out.println("Product added!");

        return true;
    }

    // Displays the value of an individual product
    private static boolean checkProduct(HashMap<String, Integer> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("Inventory empty!");
            return false;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product name to check: ");
        String productToCheck = scanner.nextLine();

        if (!inventory.containsKey(productToCheck)) {
            System.out.println("Product does not exist. Check your spelling.");
            return false;
        }

        if (inventory.get(productToCheck) <= 0) {
            System.out.println(productToCheck + " is out of stock.");
            return true;
        }

        System.out.println(productToCheck + " is in stock: " + inventory.get(productToCheck));
        return true;
    }

    // Updates the stock of an item
    private static boolean updateStock(HashMap<String, Integer> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("Inventory empty!");
            return false;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product name to update: ");
        String productToUpdate = scanner.nextLine();

        if (!inventory.containsKey(productToUpdate)) {
            System.out.println("Product does not exist. Check your spelling.");
            return false;
        }

        System.out.print("Enter new stock quantity: ");
        int newProductQuantity = scanner.nextInt();
        scanner.nextLine();

        if (newProductQuantity < 0) {
            System.out.println("Invalid input. Product not updated.");
            return false;
        }

        inventory.put(productToUpdate, newProductQuantity);
        System.out.println("Stock updated!");

        return true;
    }

    // Removes an individual product
    private static boolean removeProduct(HashMap<String, Integer> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("Inventory empty!");
            return false;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product name to remove: ");
        String productToRemove = scanner.nextLine();

        if (!inventory.containsKey(productToRemove)) {
            System.out.println("Product does not exist. Check your spelling.");
            return false;
        }

        inventory.remove(productToRemove);
        System.out.println("Product removed.");

        return true;
    }

    public static void main(String[] args) {
        // Variable initialization
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> inventory = new HashMap<>();
        int choice = 0;

        // Displays the menu until the user chooses to exit
        while (choice != 6) {
            displayMenu();
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewInventory(inventory);
                    break;
                case 2:
                    addProduct(inventory);
                    break;
                case 3:
                    checkProduct(inventory);
                    break;
                case 4:
                    updateStock(inventory);
                    break;
                case 5:
                    removeProduct(inventory);
                    break;
                case 6:
                    System.out.println("Exiting system.");
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }

            System.out.println();
        }
    }
}