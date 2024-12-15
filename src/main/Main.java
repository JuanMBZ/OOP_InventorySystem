package main;

import operation.*;
import products.*;
import userinterface.*;
import java.util.Scanner;

public class Main {
    

    public static void main(String[] args) {
        ArraysDataStruct productList = new ArraysDataStruct();
        Features features = new Features(productList);
        SortingAlgorithms sorter = new SortingAlgorithms();
        Product products;
        InventoryDisplay inventoryGUI =new InventoryDisplay(productList);
        int key; //search key
        int index=0;
        String inputFile = "../walaSaNetbeans/inventory.in";
        String outputFile = inputFile;

        Scanner scanner = new Scanner(System.in);
        
        //Start GUI
        inventoryGUI.setVisible(true);
        
        features.addProduct("Mac Pro", "Laptop", "Model", 50000, 
        20, "Available", 69); 
        inventoryGUI.addTableRow(productList.productAt(index++).getObjArr());   //add to table row
        features.addProduct("Nokia", "Cellphone", "3210", 5000, 
        10, "Available", 3); 
        inventoryGUI.addTableRow(productList.productAt(index++).getObjArr());
        features.addProduct("IPad", "Tablet", "Model", 30000, 
        5, "Available", 7); 
        inventoryGUI.addTableRow(productList.productAt(index++).getObjArr());
        
        int choice;
        do {
            
            System.out.println("\n--- Lelectrunic Inventory System ---");
            System.out.println("0. Exit");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Search Product");
            System.out.println("4. Sell a Product");
            System.out.println("5. Display All Products");
            System.out.println("6. Adjust Product Status (Automatic)");
            System.out.println("7. Notify Low Stock (Automatic)");
            System.out.println("8. Total Products (Automatic)");
            System.out.println("9. Total Sales (Automatic)");
            System.out.println("10. Sort by Reference Number");
            System.out.println("11. Sort by Device Type");
            
            System.out.print("Erabe kono yarou: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 0: 
                    break;
                case 1:
                    System.out.print("Enter Brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Enter Device Type: ");
                    String deviceType = scanner.nextLine();
                    System.out.print("Enter Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Status: ");
                    String status = scanner.nextLine();
                    System.out.print("Enter Reference Number: ");
                    int refNum = scanner.nextInt();
                    features.addProduct(brand, deviceType, model, price, quantity, status, refNum);
                    inventoryGUI.addTableRow(productList.productAt(index++).getObjArr());   
                    break;

                case 2:
                    System.out.print("Enter Model to Remove: ");
                    String modelToRemove = scanner.nextLine();
                    boolean removed = features.getProductList().remove(modelToRemove);
                    if (removed) {
                        System.out.println("Product removed successfully.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Reference no. to Search: ");
                    key = scanner.nextInt();
                    products = features.getProductList().search(key);
                    if (products != null) {
                        System.out.println("Product Found:\n" + products.getProduct());
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4: 
                    System.out.print("Enter Reference no. to Sell: ");
                    key = scanner.nextInt();
                    products = features.getProductList().search(key);
                    if (products != null) {
                        
                        System.out.print("Enter Qty: ");
                        products.setCurrentQuantity(scanner.nextInt());
                        System.out.println("Remaining product Qty: " + products.getCurrentQuantity());
                    } else {
                        System.out.println("Product not found.");
                    }

                    break;
                case 5:
                    features.printAllProducts();
                    features.printToFile(outputFile);
                    break;

                case 6:
                    features.adjustProductStatus(); //automamic but test first
                    System.out.println("Product statuses updated.");
                    break;

                case 7:
                    features.notifyLowStock(); //automamic but test first
                    break;

                case 8:
                    features.totalProducts(); //automamic but test first
                    break;

                case 9:
                    features.totalSales(); //automamic but test first
                    break;

                case 10:
                    //sorter.sortByRefNum();
                    features.sortProductsByRefNo();
                    System.out.println("Products sorted by Reference Number.");
                    break;

                case 11:
                    //sorter.sortByDeviceType();
                    features.sortProductsByDeviceType();
                    System.out.println("Products sorted by Device Type.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

    }
}
