public interface Purchasable {
    double calculateTotalPrice();
    boolean isEligibleForDiscount();
    String getPurchaseDetails();
}
