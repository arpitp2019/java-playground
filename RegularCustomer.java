import java.util.ArrayList;

public class RegularCustomer extends Customer implements Purchaser {
    
    // ========== PRIVATE INSTANCE VARIABLES ========== ✅
    private int purchaseLimit;              // Maximum items per order
    private boolean hasWarranty;            // Basic warranty status
    private ArrayList<Laptop> cartItems;    // Shopping cart
    
    
    // ========== STATIC VARIABLE ========== ✅
    private static int totalRegularCustomers = 0;
    
    // Regular customer constants
    private static final double BASE_DISCOUNT_THRESHOLD = 50000.0;
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
    public double calculateDiscount(Laptop laptop) {
        // Using static variable from parent Customer class
        if (laptop.getPrice() >= BASE_DISCOUNT_THRESHOLD) {
            double discount = laptop.getPrice() * REGULAR_DISCOUNT_RATE;
            System.out.println("Regular customer discount applied: Rs." + discount);
            return discount;
        }
        System.out.println("Purchase amount below threshold. No discount.");
        return 0.0;
    }
}
    