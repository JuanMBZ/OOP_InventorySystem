package operation;

import java.util.Arrays;
import products.*;

public class ArraysDataStruct {
    private Product[] productList; // array of products
    private int size;

    public ArraysDataStruct() {
        this.productList = new Product[10];
        this.size = 0; 
    }

    public void add(Product product) {
        if (size == productList.length) {
            // resize
            productList = Arrays.copyOf(productList, productList.length+1);
        }
        productList[size++] = product;
    }

    public boolean remove(String model) {
        if (size == 0) {
            return false; //empty
        }

        for (int i = 0; i < size; i++) {
            if (productList[i].getModel().compareTo(model) == 0) {
                // shift elements to the left  
                System.arraycopy(productList, i + 1, productList, i, size - i - 1);
                productList[--size] = null; 
                return true; // Successfully removed
            }
        }
        return false; // Not found
    }

    public Product search(int refNumKey) {
        for (int i = 0; i < size; i++) {
            if (productList[i].getRefNum() == refNumKey) {
                return productList[i]; //found
            }
        }
        return null; // Not found
    }

    // accessors
    // traversing
    public Product[] getProductList() {
        return Arrays.copyOf(productList, size); //copy return only
    }
    
    public Product[] getList() {    //Return the list pointer, for sorting
        return productList;
    }

    public int getLength() {
        return size; 
    }
    
    public Product productAt(int index) {   //return the product at the specified index
        return productList[index];
    }
}
