import java.util.ArrayList;
import java.time.LocalDate;

public abstract class Customer {
    private String customerID;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;
    private LocalDate registerationDate;
    private double totalSpentAmount;
    private ArrayList<Laptop> laptopCollection;

    protected static int totalCustomerCount = 0;
    protected static final String companyName = "TechStore India";
    protected static final int baseDiscountThreshold = 50000;
    protected static final String country = "India";

    public Customer(String customerID,String customerName, String customerEmail, String cutomerPhoneNumber, LocalDate registerationDate, double totalSpentAmount){
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNumber = cutomerPhoneNumber;
        this.registerationDate = LocalDate.now();
        this.totalSpentAmount = totalSpentAmount;
        this.laptopCollection = new ArrayList<>();
        totalCustomerCount++;
    }

    private String generateCustomerCode(){
        return "Cust -" + this.customerID + "-" + System.currentTimeMillis();
    }

    public String customerInfo(){
        return "customerID:" + this.customerID + ", customerName: " + this.customerName + ", customerEmail: " + this.customerEmail + ", registerationDate: " + this.registerationDate + ", totalSpentAmount: " + this.totalSpentAmount + ", laptopCollection: " + this.laptopCollection.toString();
    }

    protected void addPurchase(Laptop laptop){
        this.laptopCollection.add(laptop);
        this.totalSpentAmount += laptop.getPrice();
        System.out.println("Laptop " + laptop.getBrandName() + " added to " + this.customerName + "'s collection.");
    }

    protected ArrayList<Laptop> getLaptopCollection(){
        return new ArrayList<>(this.laptopCollection);
    }

    //----------------------------Setting getter methods-----------------------------------------

    public final String getCustomerID(){
        return this.customerID;
    }

    public final String getCompanyName(){
        return companyName;
    }

    public final String getCountry(){
        return country;
    }

    public String getCustomerName(){
        return this.customerName;
    }

    public String getCustomerEmail(){
        return this.customerEmail;
    }

    public String getCustomerPhoneNumber(){
        return this.customerPhoneNumber;
    }

    public double getTotalSpent(){
        return this.totalSpentAmount;
    }


    public int getLaptopPurchased(){
        return this.laptopCollection.size();
    }

    public enum PriorityLevel{
        STANDERD,
        PREMIUM
    }

    public enum CustomerType{
        REGULAR,
        PREMIUM
    }


    //----------------------------Setting Setter methods-----------------------------------------
    public void setCustomerEmail(String customerEmail){
        this.customerEmail = customerEmail;
        System.out.println("New email of customer " + this.customerName + "is updated");
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.length() == 10) {
            this.customerPhoneNumber = phoneNumber;
            System.out.println("Phone number updated for customer: " + this.customerName);
        } else {
            System.out.println("Invalid phone number. Must be 10 digits.");
        }
    }

    //--------------------------- Static methods -------------------------------------------
    public static int getCustomerCount(){
        return totalCustomerCount;
    }

    public static double getBaseDiscountThreshold(){
        return baseDiscountThreshold;
    }

    public abstract String getCustomerType();

    public abstract double calculateDiscount(Laptop laptop);

    public abstract String getShippingPolicy();

    public abstract int getPurchaseLimit();

    public abstract String getPriorityLevel();

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
        return getCustomerType() + " - " + this.customerName + " (ID: " + this.customerEmail + 
               ", Spent: Rs." + this.totalSpentAmount + ")";
    }
}


