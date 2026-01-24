public class Laptop{
    private String brand;
    private String model;
    private int ramSize;
    private double price;

    public Laptop(String brandname, String modelName, int ramSizeGB, double priceINR){
        this.brand = brandname;
        this.model = modelName;
        this.ramSize = ramSizeGB;
        this.price = priceINR;
    }

    public Laptop(String brandname, String modelName, double priceINR){
        this(brandname, modelName, getDefaultRamSize(brandname), priceINR);
    }

    public Laptop(String brandname){
        this(brandname, getDefaultModel(brandname), getDefaultRamSize(brandname), getDefaultPrice(brandname));
    }

    public Laptop(String brandname, double priceINR){
        this(brandname, getDefaultModel(brandname), getDefaultRamSize(brandname), priceINR);
    }

    private static String getDefaultModel(String brandname){
        if (brandname.equalsIgnoreCase("Dell")){
            return "Inspiron";
        }else if (brandname.equalsIgnoreCase("HP")){
            return "Pavilion";
        }else{
            return "GenericModel";
        }
    }

    private static int getDefaultRamSize(String brandname){
        if (brandname.equalsIgnoreCase("Dell")){
            return 8;
        }else if (brandname.equalsIgnoreCase("HP")){
            return 16;
        }else{
            return 4;
        }
    }

    private static double getDefaultPrice(String brandname){
        if (brandname.equalsIgnoreCase("Dell")){
            return 55650.0;
        }else if (brandname.equalsIgnoreCase("HP")){
            return 90000.0;
        }else {
            return 40000.0;
        }
    }

    public Laptop(){
        this("Dell", "Inspiron", 8, 55000.0);
    }

    public String getBrandName(){
        return this.brand;
    }

    public String getModelName(){
        return this.model;
    }

    public int getRamSize(){
        return this.ramSize;
    }

    public double getPrice(){
        return this.price;
    }



    public String toString(){
        return "Brand: " + this.brand + ", Model: " + this.model + ", RAM: " + this.ramSize + "GB, Price: " + this.price;
    }

    // Fixed: Changed name from estimatedPriceAfterRepair to estimatePriceAfterRepair
    public double estimatePriceAfterRepair(double repairCost){
        return this.price + repairCost + 300;
    }

    // Actually repairs and updates price
    public double repairLaptop(double repairCost){
        this.price = this.price + repairCost + 300;
        return this.price;
    }

    public String upgradeTheLaptopRam(int additionalRamSize){
    // Check if additionalRamSize is power of 2
    if (additionalRamSize <= 0 || (additionalRamSize & (additionalRamSize - 1)) != 0) {
        return "Invalid RAM size. Must be a power of 2 (2, 4, 8, 16, 32, 64, etc.)";
    }
    
    if (this.ramSize < additionalRamSize){
        // Calculate upgrade cost
        int ramIncrease = additionalRamSize - this.ramSize;
        double upgradeCost = ramIncrease * 2000.0;  // 2000 per GB
        
        // Update laptop
        this.ramSize = additionalRamSize;
        this.price = this.price + upgradeCost;
        
        return "RAM upgraded to " + this.ramSize + "GB. New price: " + this.price;
        
    } else if (this.ramSize == additionalRamSize){
        return "No upgrade needed, RAM size is already " + this.ramSize + "GB";   
        
    } else {
        return "Upgrade failed, additional RAM size must be greater than current RAM size of " + this.ramSize + "GB";   
    }
    }

    public String isLaptopResellableToString(){
        if (this.price <= 110000.0){
            return "Laptop is resellable (estimated price: " + this.price + ")";
        } else {
            return "Laptop not resellable (too expensive: " + this.price + ")";
        }
    }

    public boolean isLaptopResellable(){
    return this.price <= 110000.0;  // ✅ No if-else needed at al
    }

}



 