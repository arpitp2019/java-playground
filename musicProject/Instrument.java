public class Instrument {
    private String name;
    private String type;
    private double price;
    
    public Instrument(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }
    
    public void tune() {
        System.out.println("Tuning " + name + "...");
    }
    
    public String getName() {
        return name;
    }
    
    public String getType() {
        return type;
    }
}
