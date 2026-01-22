
public class Venue {
    private String name;
    private Address location;
    private int capacity;
    private String venueType;
    
    public Venue(String name, Address location, int capacity, String venueType) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.venueType = venueType;
    }
    
    public void displayVenueInfo() {
        System.out.println("\n=== Venue: " + name + " ===");
        System.out.println("Type: " + venueType);
        System.out.println("Capacity: " + capacity + " people");
        System.out.println("Location: " + location.getFullAddress());
    }
    
    public String getName() {
        return name;
    }
    
    public int getCapacity() {
        return capacity;
    }
}
