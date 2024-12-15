import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Features features = new Features();
        SortingAlgorithms sorter = new SortingAlgorithms();
        ArraysDataStruct arrayOperations = new ArraysDataStruct();
        Product products;
        int key; //search key
        String inputFile = "input.in";
        String outputFile = inputFile;

        Scanner scanner = new Scanner(System.in);
        features.readDataFromFile(inputFile,features);

        int choice;
        do {
            System.out.println("\n--- Electronic Inventory System ---");
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
                    features.printToFile(outputFile, features);
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
