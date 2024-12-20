package products;


public class Product {
    private String brand = "";
    private String model = "";
    private double price = 0.0;
    private int quantity = 0; // all quantity
    private String status= "";
    private String deviceType = "";
    private int refNum = 0;
    private double totalPrice;
    private int currentQuantity = 0; //quantity after sold decrement each time
    private Object objArr[];    //para mapasa sa gui

    public Product(String brand, String deviceType, String model, double price, 
		int quantity, String status, int refNum) {
        this.brand = brand;
        this.deviceType = deviceType;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
        this.refNum = refNum;
        if(quantity>=10)
            this.status = "Available";
        else if(quantity>0)
            this.status = "Running Out";
        else if(quantity==0)
            this.status = "Empty";
        else
            this.status = "Error";
        //For object array
        objArr = new Object[8];
        objArr[0] = brand;
        objArr[1] = deviceType;
        objArr[2] = model;
        objArr[3] = price;
        objArr[4] = quantity;
        objArr[5] = this.status;
        objArr[6] = refNum;
        objArr[7] = price*quantity;
    }
    
    public Product(Object objArr[]) {   //Constructor para sa user input sa GUI
        brand = (String)objArr[0];
        deviceType = (String)objArr[1];
        model = (String)objArr[2];
        price = (double)objArr[3];
        quantity = (int)objArr[4];
        status = (String)objArr[5];
        refNum = (int)objArr[6];
        totalPrice = (double)((double)price) * ((int)quantity);
        objArr[7] = totalPrice;
        this.objArr = objArr;
    }

    public String getProduct() {
        return
            "\nDevice Type: " + deviceType +
            " Reference Number: " + refNum +
            "\nBrand: " + brand +
            " Model: " + model +
            "\nPrice" + price +
            " Quantity: " + quantity +
            " Status: " + status ;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void setCurrentQuantity(int soldQty) {
        this.currentQuantity = this.quantity - soldQty;
    }
    public void setQuantity(int qty) {
        quantity = qty;
    }
    

    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
    public String getModel() {
        return model;
    }
    public String getDeviceType(){
        return deviceType;
    }
    public int getRefNum(){
        return refNum;
    }
    public int getCurrentQuantity(){
        return quantity - currentQuantity;
    }
    public String getBrand() {
        return brand;
    }
    public String getStatus() {
        if(quantity>=10)
            this.status = "Available";
        else if(quantity>0)
            this.status = "Running Out";
        else if(quantity==0)
            this.status = "Empty";
        else
            this.status = "Error";
        return status;
    }
    public double getTotalPrice() {
        totalPrice = price*quantity;
        return totalPrice;
    }
    
    public Object[] getObjArr() {
        return objArr;
    }
    
    public String printOutputFile(){
        return brand+","+deviceType +","+model+","+price+","+quantity+","+status+","+refNum;
    }
    
    @Override
    public String toString() {
    return "Device Type: " + deviceType +
           ", Reference Number: " + refNum +
           ", Brand: " + brand +
           ", Model: " + model +
           ", Price: " + price +
           ", Quantity: " + quantity +
           ", Status: " + status;
    }
}