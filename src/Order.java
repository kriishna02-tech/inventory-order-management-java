class Order {
    private final  int orderId;   //final ka matlab hai: variable ko ek baar value assign karne ke baad us variable ko kisi aur value se replace nahi kar sakte.
    private final  int productId;
    private final  String customerName;
    private final int quantity;

    public Order(int orderId , int productId , String customerName , int quantity ) {
        this.orderId = orderId;
        this.productId = productId;
        this.customerName = customerName;
        this.quantity = quantity;
    }

    public int  getOrderId(){
        return orderId;
    }
    public int  getProductId(){
        return productId;
    }
    public String getCustomerName(){
        return customerName;
    }
    public int  getQuantity(){
        return quantity;
    }

    @Override 
    public String toString(){
        return "Id " + orderId + " | Prodcut Id : "+ productId + " | Customer name : "+ customerName + " | Quantity : " + quantity;  
    }



    
}
