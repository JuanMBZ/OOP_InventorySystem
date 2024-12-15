class Product {
    private String brand = "";
    private String model = "";
    private double price = 0.0;
    private int quantity = 0; // all quantity
    private String status= "";
    private String deviceType = "";
    private int refNum = 0;
    private int currentQuantity = 0; //quantity after sold decrement each time

    Product(String brand, String deviceType, String model, double price, 
		int quantity, String status, int refNum) {
        this.brand = brand;
        this.deviceType = deviceType;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.refNum = refNum;
    }


    public String getProduct() {
        return
		    "\nDevice Type: " + deviceType +
		    " Reference Number: " + refNum +
            "\nBrand: " + brand +
            " Model: " + model +
            "\nPrice: " + price +
            " Quantity: " + quantity +
            " Status: " + status ;
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


    public void setStatus(String status) {
        this.status = status;
    }
    public void setCurrentQuantity(int soldQty) {
        this.currentQuantity = this.quantity - soldQty;
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
   



}