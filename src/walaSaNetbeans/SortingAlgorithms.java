import java.util.Comparator;

class SortingAlgorithms extends ArraysDataStruct {

    SortingAlgorithms() {
        super();
    }

    // Private methods
    private static void maxHeapifyByRefNum(Product[] productList, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = left + 1;

        if (left < n && 
        productList[left].getRefNum() > productList[largest].getRefNum()) {
            largest = left;
        }

        if (right < n && 
        productList[right].getRefNum() > productList[largest].getRefNum()) {
            largest = right;
        }

        if (largest != i) {
            // Swap
            Product temp = productList[i];
            productList[i] = productList[largest];
            productList[largest] = temp;

            maxHeapifyByRefNum(productList, n, largest);
        }
    }

    private static void maxHeapifyByDeviceType(Product[] productList, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = left + 1;

        if (left < n && 
        productList[left].getDeviceType().compareTo(productList[largest].getDeviceType()) > 0) {
            largest = left;
        }

        if (right < n && 
        productList[right].getDeviceType().compareTo(productList[largest].getDeviceType()) > 0) {
            largest = right;
        }

        if (largest != i) {
            Product temp = productList[i];
            productList[i] = productList[largest];
            productList[largest] = temp;

            maxHeapifyByDeviceType(productList, n, largest);
        }
    }

    // For public
    public Product[] sortByDeviceType() {
        Product[] productList = getProductList();
        int n = productList.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapifyByDeviceType(productList, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            Product temp = productList[0];
            productList[0] = productList[i];
            productList[i] = temp;

            maxHeapifyByDeviceType(productList, i, 0);
        }

        return productList;
    }

    public Product[] sortByRefNum() {
        Product[] productList = getProductList(); 
        int n = productList.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapifyByRefNum(productList, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            Product temp = productList[0];
            productList[0] = productList[i];
            productList[i] = temp;

            maxHeapifyByRefNum(productList, i, 0);
        }

        return productList;
    }
}

class SortbyRefNo implements Comparator<Product> {  //Used for sorting products by refno
    public int compare(Product a, Product b) {
        if(a == null || b == null)  //kung di puno yung array
            return 0;
        return a.getRefNum() - b.getRefNum();
    }
}

class SortbyDeviceType implements Comparator<Product> {  //Used for sorting products by device type
    public int compare(Product a, Product b) {
        if(a == null || b == null)  //kung di puno yung array
            return 0;
        return a.getDeviceType().compareTo(b.getDeviceType());
    }
}