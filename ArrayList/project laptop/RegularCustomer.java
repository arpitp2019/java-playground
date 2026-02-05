import java.util.ArrayList;

public class RegularCustomer extends Customer implements Purchaser {
    
    // ========== PRIVATE INSTANCE VARIABLES ========== ✅
    private int purchaseLimit;              // Maximum items per order
    private WarrantyInfo warrantyInfo;      // Warranty information (using static nested class)
    private ArrayList<Laptop> cartItems;    // Shopping cart
    
    
    // ========== STATIC NESTED CLASS ========== ✅
    /**
     * Static nested class for warranty information
     * Does not need access to outer class instance
     * Can be instantiated independently
     */
    public static class WarrantyInfo {
        private boolean isActive;
        private int durationYears;
        private String warrantyType;
        
        public WarrantyInfo(boolean isActive, int durationYears, String warrantyType) {
            if (warrantyType == null || warrantyType.trim().isEmpty()) {
                throw new IllegalArgumentException("Warranty type cannot be null or empty");
            }
            if (durationYears < 0) {
                throw new IllegalArgumentException("Warranty duration cannot be negative");
            }
            this.isActive = isActive;
            this.durationYears = durationYears;
            this.warrantyType = warrantyType;
        }
        
        public boolean isActive() {
            return isActive;
        }
        
        public void setActive(boolean active) {
            isActive = active;
        }
        
        public int getDurationYears() {
            return durationYears;
        }
        
        public String getWarrantyType() {
            return warrantyType;
        }
        
        @Override
        public String toString() {
            return warrantyType + " (" + durationYears + " years) - " + (isActive ? "Active" : "Inactive");
        }
    }
    
    
    // ========== INNER CLASS (NON-STATIC) ========== ✅
    /**
     * Inner class for managing cart item details
     * Has access to outer class instance variables and methods
     * Used to track additional metadata for items in cart
     */
    public class CartItemDetails {
        private Laptop laptop;
        private String addedDate;
        private boolean isGift;
        
        public CartItemDetails(Laptop laptop, String addedDate, boolean isGift) {
            if (laptop == null) {
                throw new IllegalArgumentException("Laptop cannot be null");
            }
            if (addedDate == null || addedDate.trim().isEmpty()) {
                throw new IllegalArgumentException("Added date cannot be null or empty");
            }
            this.laptop = laptop;
            this.addedDate = addedDate;
            this.isGift = isGift;
        }
        
        public Laptop getLaptop() {
            return laptop;
        }
        
        public String getAddedDate() {
            return addedDate;
        }
        
        public boolean isGift() {
            return isGift;
        }
        
        // Inner class can access outer class members
        public double getDiscountedPrice() {
            double originalPrice = laptop.getPrice();
            double discount = calculateDiscount(originalPrice);
            return originalPrice - discount;
        }
        
        public String getCustomerName() {
            // Accessing outer class's inherited protected field
            return RegularCustomer.this.customerName;
        }
        
        @Override
        public String toString() {
            return laptop.getBrand() + " " + laptop.getModel() + " (Added: " + addedDate + ", Gift: " + isGift + ")";
        }
    }
    
    
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
        
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Customer name cannot be null or empty");
            }
            if (email == null || email.trim().isEmpty()) {
                throw new IllegalArgumentException("Customer email cannot be null or empty");
            }
            if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
                throw new IllegalArgumentException("Customer phone number cannot be null or empty");
            }
            
            this.purchaseLimit = DEFAULT_PURCHASE_LIMIT;
            this.warrantyInfo = new WarrantyInfo(true, 1, "Basic Warranty");  // Using static nested class
            this.cartItems = new ArrayList<>();
            
            totalRegularCustomers++;
            
            System.out.println("RegularCustomer created: " + name);
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating RegularCustomer: " + e.getMessage());
            throw e; // Re-throw to prevent incomplete object creation
        } catch (Exception e) {
            System.err.println("Unexpected error creating RegularCustomer: " + e.getMessage());
            throw new RuntimeException("Failed to create RegularCustomer", e);
        }
    }
    
    /**
     * Constructor with custom purchase limit
     */
    public RegularCustomer(String name, String email, String phoneNumber, int purchaseLimit) {
        super(name, email, phoneNumber);  // ✅ Using super()
        
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Customer name cannot be null or empty");
            }
            if (email == null || email.trim().isEmpty()) {
                throw new IllegalArgumentException("Customer email cannot be null or empty");
            }
            if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
                throw new IllegalArgumentException("Customer phone number cannot be null or empty");
            }
            if (purchaseLimit <= 0) {
                throw new IllegalArgumentException("Purchase limit must be greater than 0");
            }
            
            this.purchaseLimit = purchaseLimit;
            this.warrantyInfo = new WarrantyInfo(true, 1, "Basic Warranty");
            this.cartItems = new ArrayList<>();
            
            totalRegularCustomers++;
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating RegularCustomer: " + e.getMessage());
            throw e; // Re-throw to prevent incomplete object creation
        } catch (Exception e) {
            System.err.println("Unexpected error creating RegularCustomer: " + e.getMessage());
            throw new RuntimeException("Failed to create RegularCustomer", e);
        }
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
        try {
            if (amount < 0) {
                throw new IllegalArgumentException("Amount cannot be negative");
            }
            // Using static variable from parent Customer class
            if (amount >= BASE_DISCOUNT_THRESHOLD) {
                double discount = amount * REGULAR_DISCOUNT_RATE;
                System.out.println("Regular customer discount applied: Rs." + discount);
                return discount;
            }
            System.out.println("Purchase amount below threshold. No discount.");
            return 0.0;
        } catch (IllegalArgumentException e) {
            System.err.println("Error calculating discount: " + e.getMessage());
            return 0.0;
        } catch (Exception e) {
            System.err.println("Unexpected error in calculateDiscount: " + e.getMessage());
            return 0.0;
        }
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
        try {
            if (this.laptopCollection == null) {
                throw new NullPointerException("Laptop collection is null");
            }
            double total = 0;
            for (int i = 0; i < this.laptopCollection.size(); i++){
                Laptop laptop = this.laptopCollection.get(i);
                if (laptop != null) {
                    total += laptop.getPrice();
                } else {
                    System.err.println("Warning: Null laptop found at index " + i);
                }
            }
            return total;
        } catch (NullPointerException e) {
            System.err.println("Error in calculateTotalPurchase: " + e.getMessage());
            return 0.0;
        } catch (Exception e) {
            System.err.println("Unexpected error in calculateTotalPurchase: " + e.getMessage());
            return 0.0;
        }
    }

    @Override
    public boolean getDiscountEligibility(){
        return this.totalSpentAmount >= BASE_DISCOUNT_THRESHOLD;
    }

    @Override
    public String getPurchaseHistory(){
        try {
            if (this.laptopCollection == null) {
                return "Purchase history not available (collection is null)";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("\n========== Purchase History ==========\n");
            for (int i = 0; i < this.laptopCollection.size(); i++){
                Laptop laptop = this.laptopCollection.get(i);
                if (laptop != null) {
                    sb.append(i + 1).append(". ").append(laptop.toString()).append("\n");
                } else {
                    sb.append(i + 1).append(". [Invalid Entry]\n");
                }
            }
            sb.append("======================================\n");
            return sb.toString();
        } catch (Exception e) {
            System.err.println("Error generating purchase history: " + e.getMessage());
            return "Error: Unable to generate purchase history";
        }
    }

    @Override
    public void addToCart(Laptop laptop){
        try {
            if (laptop == null) {
                throw new IllegalArgumentException("Cannot add null laptop to cart");
            }
            if (this.cartItems == null) {
                throw new NullPointerException("Cart is not initialized");
            }
            if (this.cartItems.size() >= this.purchaseLimit) {
                throw new IllegalStateException("Cart is full. Purchase limit reached: " + this.purchaseLimit);
            }
            this.cartItems.add(laptop);
            System.out.println("Laptop added to cart: " + laptop.getBrand() + " " + laptop.getModel());
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.err.println("Error adding to cart: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error adding to cart: " + e.getMessage());
        }
    }

    @Override
    public int getPurchaseCount(){
        return this.laptopCollection.size();
    }

    public void checkout(){
        try {
            if (this.cartItems == null) {
                throw new NullPointerException("Cart is not initialized");
            }
            if (this.cartItems.isEmpty()){
                System.out.println("Cart is empty. No purchase to checkout.");
                return;
            }

            double total = 0;
            System.out.println("\n========== Checkout ==========");
            for (int i = 0; i < this.cartItems.size(); i++){
                Laptop laptop = this.cartItems.get(i);
                if (laptop == null) {
                    System.err.println("Warning: Null laptop at index " + i + ", skipping...");
                    continue;
                }
                total += laptop.getPrice();
                System.out.println(i + 1 + ". " + laptop.getBrand() + " " + laptop.getModel() + " - Rs." + laptop.getPrice());
            }

            if (total < 0) {
                throw new IllegalStateException("Invalid total amount: " + total);
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

            if (this.laptopCollection == null) {
                throw new NullPointerException("Laptop collection is not initialized");
            }

            this.totalSpentAmount += finalAmount;
            this.laptopCollection.addAll(this.cartItems);
            this.cartItems.clear();

            System.out.println("Checkout complete. Thank you for your purchase!");
        } catch (NullPointerException e) {
            System.err.println("Checkout error (null reference): " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("Checkout error (invalid state): " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error during checkout: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void viewCart(){
        try {
            if (this.cartItems == null) {
                throw new NullPointerException("Cart is not initialized");
            }
            if (this.cartItems.isEmpty()){
                System.out.println("Cart is empty.");
                return;
            }

            System.out.println("\n========== Cart Items ==========");
            for (int i = 0; i < this.cartItems.size(); i++){
                Laptop laptop = this.cartItems.get(i);
                if (laptop != null) {
                    System.out.println(i + 1 + ". " + laptop.getBrand() + " " + laptop.getModel() + " - Rs." + laptop.getPrice());
                } else {
                    System.out.println(i + 1 + ". [Invalid Entry]");
                }
            }
            System.out.println("================================");
        } catch (NullPointerException e) {
            System.err.println("Error viewing cart: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error viewing cart: " + e.getMessage());
        }
    }

    public void removeFromCart(int index){
        try {
            if (this.cartItems == null) {
                throw new NullPointerException("Cart is not initialized");
            }
            if (this.cartItems.isEmpty()) {
                throw new IllegalStateException("Cannot remove from empty cart");
            }
            if (index < 0 || index >= this.cartItems.size()){
                throw new IndexOutOfBoundsException("Invalid index: " + index + ". Valid range: 0-" + (this.cartItems.size() - 1));
            }
            Laptop removedLaptop = this.cartItems.remove(index);
            System.out.println("Item removed from cart: " + (removedLaptop != null ? removedLaptop.getBrand() + " " + removedLaptop.getModel() : "Unknown"));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Error removing from cart: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error removing from cart: " + e.getMessage());
        }
    }

    /**
     * Generate a detailed purchase summary report
     * Demonstrates METHOD LOCAL CLASS (nested class inside a method)
     * @return Formatted purchase summary string
     */
    public String generatePurchaseSummary() {
        
        // ========== METHOD LOCAL CLASS ========== ✅
        /**
         * Local class defined inside a method
         * Used only within this method for processing purchase data
         * Can access final or effectively final local variables
         */
        class PurchaseSummaryProcessor {
            private double totalAmount;
            private double totalDiscount;
            private int itemCount;
            
            public void processPurchases() {
                try {
                    if (laptopCollection == null) {
                        throw new NullPointerException("Laptop collection is null");
                    }
                    totalAmount = 0;
                    totalDiscount = 0;
                    itemCount = laptopCollection.size();
                    
                    for (Laptop laptop : laptopCollection) {
                        if (laptop != null) {
                            double price = laptop.getPrice();
                            totalAmount += price;
                            totalDiscount += calculateDiscount(price);
                        } else {
                            System.err.println("Warning: Null laptop found in collection");
                        }
                    }
                } catch (NullPointerException e) {
                    System.err.println("Error processing purchases: " + e.getMessage());
                    itemCount = 0;
                } catch (Exception e) {
                    System.err.println("Unexpected error processing purchases: " + e.getMessage());
                }
            }
            
            public String generateReport() {
                StringBuilder report = new StringBuilder();
                report.append("\n========== Purchase Summary Report ==========").append("\n");
                report.append("Customer: ").append(customerName).append("\n");
                report.append("Customer Type: ").append(getCustomerType()).append("\n");
                report.append("Total Items Purchased: ").append(itemCount).append("\n");
                report.append("Total Amount: Rs.").append(totalAmount).append("\n");
                report.append("Total Discounts: Rs.").append(totalDiscount).append("\n");
                report.append("Net Spent: Rs.").append(totalSpentAmount).append("\n");
                report.append("Warranty: ").append(warrantyInfo.toString()).append("\n");
                report.append("=============================================").append("\n");
                return report.toString();
            }
        }
        
        // Using the method local class
        PurchaseSummaryProcessor processor = new PurchaseSummaryProcessor();
        processor.processPurchases();
        return processor.generateReport();
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
    public WarrantyInfo getWarrantyInfo() {
        return this.warrantyInfo;
    }
    
    /**
     * Set warranty information for this customer
     * @param warrantyInfo WarrantyInfo object containing warranty details
     */
    public void setWarrantyInfo(WarrantyInfo warrantyInfo) {
        try {
            if (warrantyInfo == null) {
                throw new IllegalArgumentException("Warranty info cannot be null");
            }
            this.warrantyInfo = warrantyInfo;
        } catch (IllegalArgumentException e) {
            System.err.println("Error setting warranty info: " + e.getMessage());
        }
    }
    
    /**
     * Get the number of items currently in cart
     * Does NOT expose internal ArrayList - maintains encapsulation
     * @return Number of items in cart
     */
    public int getCartSize() {
        try {
            if (this.cartItems == null) {
                System.err.println("Warning: Cart is not initialized");
                return 0;
            }
            return this.cartItems.size();
        } catch (Exception e) {
            System.err.println("Error getting cart size: " + e.getMessage());
            return 0;
        }
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
    