import java.io.*;
import java.util.Arrays;

class Features{
    private final ArraysDataStruct productList;
    private final int STOCKMIN = 10; // adjust when necessary

    Features() {
        productList = new ArraysDataStruct();
    }

    public void addProduct(String brand, String deviceType, String model, 
                           double price, int quantity, String status, int refNum) {
        Product product = new Product(brand, deviceType, model, price, quantity, status, refNum);
        productList.add(product); // Add product 
    }

    public void adjustProductStatus() {
        Product[] products = productList.getProductList();
        int n = products.length; // get sizee
        for (int i = 0; i < n; i++) {
            Product product = products[i];
            if (product.getQuantity() == 0) {
                product.setStatus("Sold Out");
            } else if (product.getQuantity() < STOCKMIN) {
                product.setStatus("Low Stock");
            } else {
                product.setStatus("Available");
            }
        }
    }

    public void notifyLowStock() {
        Product[] products = productList.getProductList();
        int n = products.length; 
        for (int i = 0; i < n; i++) {
            Product product = products[i];
            if (product.getQuantity() <= STOCKMIN) {
                System.out.println("Alert: Product " + product.getModel() + 
                                   " is nearing sold out. (" + product.getQuantity() + " remaining)");
            }
        }
    }
    public void totalProducts() {
        int totalQty = 0;
        double totalPrice = 0.0;

        Product[] products = productList.getProductList();
        int n = products.length;
        for (int i = 0; i < n; i++) {
            Product product = products[i];
            totalQty += product.getQuantity();
            totalPrice += product.getQuantity() * product.getPrice();
        }

        System.out.println("Overall Qty: " + totalQty);
        System.out.println("Overall Price: " + totalPrice);
    }

    public void totalSales() {
        int totalQtySold = 0;
        double totalSales = 0.0;

        Product[] products = productList.getProductList();
        int n = products.length;
        for (int i = 0; i < n; i++) {
            Product product = products[i];
            if (product.getQuantity() < STOCKMIN) {
                int soldQty = product.getQuantity() - product.getCurrentQuantity();
                totalQtySold += soldQty;
                totalSales += soldQty * product.getPrice();
            }
        }

        System.out.println("Total Sales Qty: " + totalQtySold);
        System.out.println("Total Sales Amount: " + totalSales);
    }

    public void printAllProducts() {
        Product[] products = productList.getProductList();
        int n = products.length;
        if (n == 0) {
            System.out.println("Empty list");
            return;
        }

        for (int i = 0; i < n; i++) {
            Product product = products[i];
            System.out.println("\n\nProduct " + (i + 1) + ": ");
            System.out.println(product.getProduct());
        }
    }
    
    public ArraysDataStruct getProductList() {
        return productList;
    }
    public void sortProductsByRefNo() {
        Arrays.sort(productList.getList(), new SortbyRefNo());
    }
    
    public void sortProductsByDeviceType() {
        Arrays.sort(productList.getList(), new SortbyDeviceType());
    }
    public void readDataFromFile(String fileName, Features features){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) 
        {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] data = line.split(",");
                if (data.length != 7) {
                    System.err.println("Invalid line format: " + line);
                continue; // Skip invalid lines
                }
                try
                {
                    String brand = data[0].trim();
                    String deviceType = data[1].trim();
                    String model = data[2].trim();
                    double price = Double.parseDouble(data[3].trim());
                    int quantity = Integer.parseInt(data[4].trim());
                    String status = data[5].trim();
                    int refNum = Integer.parseInt(data[6].trim());
                    features.addProduct(brand, deviceType, model, price, quantity, status, refNum);
                }
                catch (NumberFormatException e){
                }
            }
        }
        catch (IOException e) {
        }
    }
    public void printToFile(String fileName,Features features) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Product[] products = features.getProductList().getProductList();
            for (Product product : products) {
                if (product != null) { 
                    //writer.write(product.printOutputFile());
                    writer.newLine(); 
                }
            }
        } 
        catch (IOException e) {
        }
    }
    
}
