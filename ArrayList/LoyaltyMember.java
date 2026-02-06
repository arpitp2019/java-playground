// LoyaltyMember.java - Interface for loyalty program capabilities
public interface LoyaltyMember {
    
    /**
     * Earn loyalty points based on purchase amount
     * @param amount Purchase amount in INR
     * @return Points earned
     */
    int earnLoyaltyPoints(double amount);
    
    /**
     * Redeem loyalty points for discount
     * @param points Number of points to redeem
     * @return Discount amount in INR
     */
    double redeemPoints(int points);
    
    /**
     * Get current loyalty tier of the customer
     * @return Tier name (Silver/Gold/Platinum/Corporate)
     */
    String getLoyaltyTier();
    
    /**
     * Check current points balance
     * @return Available loyalty points
     */
    int checkPointsBalance();
    
    /**
     * Get benefits description based on tier
     * @return String describing tier benefits
     */
    String getTierBenefits();
}
