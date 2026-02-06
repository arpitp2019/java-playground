// Purchaser.java - Interface for purchasing capabilities
public interface Purchaser {
    
    /**
     * Calculate total purchase amount from all purchased items
     * @return Total purchase value in INR
     */
    double calculateTotalPurchase();
    
    /**
     * Check if customer is eligible for discount based on purchase amount
     * @return true if eligible, false otherwise
     */
    boolean getDiscountEligibility();
    
    /**
     * Get complete purchase history of the customer
     * @return String containing purchase details
     */
    String getPurchaseHistory();
    
    /**
     * Add a laptop to customer's cart/purchase list
     * @param laptop Laptop object to be added
     */
    void addToCart(Laptop laptop);
    
    /**
     * Get number of items purchased
     * @return Count of purchased laptops
     */
    int getPurchaseCount();
}
