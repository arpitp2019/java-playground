import java.util.ArrayList;

public class RegularCustomer extends Customer implements Purchaser {
    
    // ========== PRIVATE INSTANCE VARIABLES ========== ✅
    private int purchaseLimit;              // Maximum items per order
    private boolean hasWarranty;            // Basic warranty status
    private ArrayList<Laptop> cartItems;    // Shopping cart
    
    
    // ========== STATIC VARIABLE ========== ✅
    private static int totalRegularCustomers = 0;
    
    // Regular customer constants
    private static final int DEFAULT_PURCHASE_LIMIT = 2;
    private static final double REGULAR_DISCOUNT_RATE = 0.05;  // 5%
    private static final double SHIPPING_CHARGE = 200.0;
    
    
    // ========== CONSTRUCTORS ========== ✅
    /**
     * Main constructor for RegularCustomer
     * Uses super() to call parent Customer constructor
     * @param name Customer name
     * @param email Customer email
     * @param phoneNumber Customer phone number
     */
    public RegularCustomer(String name, String email, String phoneNumber) {
        super(name, email, phoneNumber);  // ✅ Using super() keyword
        
        this.purchaseLimit = DEFAULT_PURCHASE_LIMIT;
        this.hasWarranty = true;  // Basic 1-year warranty
        this.cartItems = new ArrayList<>();
        
        totalRegularCustomers++;
        
        System.out.println("RegularCustomer created: " + name);
    }
    
    /**
     * Constructor with custom purchase limit
     */
    public RegularCustomer(String name, String email, String phoneNumber, int purchaseLimit) {
        super(name, email, phoneNumber);  // ✅ Using super()
        
        this.purchaseLimit = purchaseLimit;
        this.hasWarranty = true;
        this.cartItems = new ArrayList<>();
        
        totalRegularCustomers++;
    }
    
    
    // ========== IMPLEMENTING ABSTRACT METHODS FROM CUSTOMER ========== ✅
    
    /**
     * Get customer type (implements abstract method)
     * @return Customer type string
     */
    @Override
    public String getCustomerType() {
        return "Regular Customer";
    }
    
    /**
     * Calculate discount for regular customer (implements abstract method)
     * Regular customers get 5% discount if purchase >= BASE_DISCOUNT_THRESHOLD
     * @param amount Purchase amount
     * @return Discount amount in INR
     */
    @Override
    public double calculateDiscount(double amount) {
        // Using static variable from parent Customer class
        if (amount >= BASE_DISCOUNT_THRESHOLD) {
            double discount = amount * REGULAR_DISCOUNT_RATE;
            System.out.println("Regular customer discount applied: Rs." + discount);
            return discount;
        }
        System.out.println("Purchase amount below threshold. No discount.");
        return 0.0;
    }

    public String getShippingPolicy(){
        return "Free shipping for orders above Rs. 50000, otherwise Rs. 200 shipping charge";
    }



    public String getPriorityLevel(){
        return "Normal";
    }

    public void displayCustomerInfo() {
        System.out.println("\n========== Customer Information ==========");
        System.out.println("Type: " + getCustomerType());
        System.out.println("Name: " + customerName);
        System.out.println("ID: " + customerID);
        System.out.println("Email: " + customerEmail);
        System.out.println("Phone: " + customerPhoneNumber);
        System.out.println("Registration Date: " + registerationDate);
        System.out.println("Total Spent: Rs." + totalSpentAmount);
        System.out.println("Laptops Purchased: " + laptopCollection.size());
        System.out.println("Priority Level: " + getPriorityLevel());
        System.out.println("Shipping Policy: " + getShippingPolicy());
        System.out.println("Company: " + companyName);
        System.out.println("Country: " + country);
        System.out.println("==========================================\n");
    }

    @Override
    public String toString() {
        return getCustomerType() + " - " + this.customerName + " (ID: " + this.customerEmail + ", Spent: Rs." + this.totalSpentAmount + ")";
    }

    @Override
    public double calculateTotalPurchase(){
        double total = 0;
        for (int i = 0; i < this.laptopCollection.size(); i++){
            total += this.laptopCollection.get(i).getPrice();
        }
        return total;
    }

    @Override
    public boolean getDiscountEligibility(){
        return this.totalSpentAmount >= BASE_DISCOUNT_THRESHOLD;
    }

    @Override
    public String getPurchaseHistory(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n========== Purchase History ==========\n");
        for (int i = 0; i < this.laptopCollection.size(); i++){
            sb.append(i + 1).append(". ").append(this.laptopCollection.get(i).toString()).append("\n");
        }
        sb.append("======================================\n");
        return sb.toString();
    }

    @Override
    public void addToCart(Laptop laptop){
        this.cartItems.add(laptop);
    }

    @Override
    public int getPurchaseCount(){
        return this.laptopCollection.size();
    }

    public void checkout(){
        if (this.cartItems.isEmpty()){
            System.out.println("Cart is empty. No purchase to checkout.");
            return;
        }

        double total = 0;
        System.out.println("\n========== Checkout ==========");
        for (int i = 0; i < this.cartItems.size(); i++){
            Laptop laptop = this.cartItems.get(i);
            total += laptop.getPrice();
            System.out.println(i + 1 + ". " + laptop.getBrand() + " " + laptop.getModel() + " - Rs." + laptop.getPrice());
        }

        double discount = calculateDiscount(total);
        double finalAmount = total - discount;
        double shipping = SHIPPING_CHARGE;
        if (total >= 50000){
            shipping = 0;
        }
        finalAmount += shipping;

        System.out.println("Total: Rs." + total);
        System.out.println("Discount: Rs." + discount);
        System.out.println("Shipping: Rs." + shipping);
        System.out.println("Final Amount: Rs." + finalAmount);

        this.totalSpentAmount += finalAmount;
        this.laptopCollection.addAll(this.cartItems);
        this.cartItems.clear();

        System.out.println("Checkout complete. Thank you for your purchase!");
    }

    public void viewCart(){
        if (this.cartItems.isEmpty()){
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("\n========== Cart Items ==========");
        for (int i = 0; i < this.cartItems.size(); i++){
            Laptop laptop = this.cartItems.get(i);
            System.out.println(i + 1 + ". " + laptop.getBrand() + " " + laptop.getModel() + " - Rs." + laptop.getPrice());
        }
        System.out.println("================================");
    }

    public void removeFromCart(int index){
        if (index < 0 || index >= this.cartItems.size()){
            System.out.println("Invalid index.");
            return;
        }
        this.cartItems.remove(index);
        System.out.println("Item removed from cart.");
    }

    

    // ========== GETTERS AND SETTERS ========== ✅
    // Only essential methods - maintaining encapsulation and security
    
    /**
     * Get the purchase limit for this customer
     * Returns the instance variable, not the static constant
     * @return Maximum items per order for this specific customer
     */
    public int getPurchaseLimit() {
        return this.purchaseLimit;
    }
    

    /**
     * Check if customer has warranty
     * @return true if warranty is active, false otherwise
     */
    public boolean getHasWarranty() {
        return this.hasWarranty;
    }
    
    /**
     * Set warranty status for this customer
     * @param hasWarranty true to activate warranty, false to deactivate
     */
    public void setHasWarranty(boolean hasWarranty) {
        this.hasWarranty = hasWarranty;
    }
    
    /**
     * Get the number of items currently in cart
     * Does NOT expose internal ArrayList - maintains encapsulation
     * @return Number of items in cart
     */
    public int getCartSize() {
        return this.cartItems.size();
    }
    
    /**
     * Get total number of regular customers (static)
     * Read-only access - no setter to prevent tampering
     * @return Total count of regular customers
     */
    public static int getTotalRegularCustomers() {
        return totalRegularCustomers;
    }
    
}
    