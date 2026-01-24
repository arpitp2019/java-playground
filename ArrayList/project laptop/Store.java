import java.util.ArrayList;

public class Store {
    private String storeName;
    private String storeLocation;
    private ArrayList<Customer> customers;
    private ArrayList<Laptop> availableLaptops;
    private ArrayList<String> transactions;
    private ArrayList<Double> soldLaptopAmountList;
    
    public Store(String storeName, String storeLocation){
        this.storeName = storeName;
        this.storeLocation = storeLocation;
        this.customers = new ArrayList<>();
        this.availableLaptops = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.soldLaptopAmountList = new ArrayList<>();
    }

    public void addLaptopToInventory(Laptop laptop){
        this.availableLaptops.add(laptop);
    }

    public void printInventory(){
    if (this.availableLaptops.isEmpty()){
        System.out.println("No laptops in inventory");
        return;
    }
    
    System.out.println("=== Available Laptops ===");
    for (Laptop laptop : this.availableLaptops){
        System.out.println(laptop);  // ✅ Uses Laptop's toString() method
    }
    }

    public double getTotalInventoryValue(){
        double totalValue = 0.0;
        for (Laptop laptop : this.availableLaptops){
            totalValue += laptop.getPrice();
        }
        return totalValue;
    }


    public void sellLaptopFromStore(Customer customer,Laptop laptop){
        this.availableLaptops.remove(laptop);
        customer.myLaptopCollection().add(laptop);
        String transactionsRecord = this.storeName + "has" + "Sold" + laptop.getBrandName() + " " + laptop.getModelName() + " to " + customer.getName() + "from" + this.storeLocation;
        this.transactions.add(transactionsRecord);
        this.soldLaptopAmountList.add(laptop.getPrice());
    }

    public void printTransactionHistory() {
        if (this.transactions.isEmpty()) {
            System.out.println("No transactions recorded");
            return;
        }
    
        System.out.println("=== Transaction History ===");
        for (String transaction : this.transactions) {
            System.out.println(transaction);
        }
    }

    // Get transaction history as a copy
    public ArrayList<String> getTransactionHistory() {
        return new ArrayList<>(this.transactions); // Return defensive copy
        
    }

    public void getTotalSales(){
        System.out.println("Total Sales: " + this.transactions.size());
    }

    public Double totalSoldLaptopAmount(){
        if (this.soldLaptopAmountList.isEmpty()){
            System.out.println("No laptops sold yet.");
            return 0.0;
        }
        Double amount = 0.0;
        for (double i : this.soldLaptopAmountList){
            amount += i;
        }
        return amount;
    }

    public void registerCustomer(Customer customer){
        this.customers.add(customer);
    }

    public void printAllCustomers(){
        if (this.customers.isEmpty()){
            System.out.println("No customers registered yet.");
            return;
        }

	    for (Customer cust : this.customers){
		    System.out.println(cust.getName());
	    }
    }

    public String getMostExpensiveLaptop(){
        if (this.availableLaptops.isEmpty()){
            return "No Laptop is available in Inventory";  // ✅ Return, not print
        }

        Laptop mostExpensive = this.availableLaptops.get(0);
    
        for (Laptop laptop : this.availableLaptops){
            if (laptop.getPrice() > mostExpensive.getPrice()){
                mostExpensive = laptop;
            }
        }
        return "Most expensive laptop is " + mostExpensive.getBrandName() + 
            " " + mostExpensive.getModelName() + 
            " having price Rs." + mostExpensive.getPrice();
    }
}






