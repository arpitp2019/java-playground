import java.util.ArrayList;

public class Customer {
    private String name;
    private int age;
    private String email;
    private ArrayList<String> phoneNumbers;
    private boolean isMarried;
    private boolean isAdult;
    private Laptop purchasedLaptop;

    // Main constructor with defensive copy
    public Customer(String name, int age, String email, ArrayList<String> phoneNumbers, 
                    boolean isMarried, boolean isAdult, Laptop laptopName){
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumbers = new ArrayList<>(phoneNumbers);  // ✅ Defensive copy
        this.isMarried = isMarried;
        this.isAdult = isAdult;
        this.purchasedLaptop = laptopName;
    }

    // Constructor with single phone number (for your Main.java)
    public Customer(String name, int age, String email, String phoneNumber, 
                    boolean isMarried, boolean isAdult, Laptop laptopName){
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumbers = new ArrayList<>();
        this.phoneNumbers.add(phoneNumber);  // Add single phone
        this.isMarried = isMarried;
        this.isAdult = isAdult;
        this.purchasedLaptop = laptopName;
    }

    // Constructor without phone numbers and laptop
    public Customer(String name, int age, String email, boolean isMarried, boolean isAdult){
        this(name, age, email, new ArrayList<>(), isMarried, isAdult, null);
    }

    // Constructor with just name and email
    public Customer(String name, int age, String email){
        this(name, age, email, new ArrayList<>(), false, true, null);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Returns a copy to protect internal list
    public ArrayList<String> getPhoneNumbers() {
        return new ArrayList<>(this.phoneNumbers);  // ✅ Return copy
    }

    public boolean getIsMarried(){
        return isMarried;
    }

    public boolean getIsAdult(){
        return isAdult;
    }

    /*  This method is not necessary as per encapsulation best practices
    public Laptop getPurchasedLaptop(){
        return purchasedLaptop;
    }
*/


    public String getRamSize(){
        if (this.purchasedLaptop == null){
            return "No laptop purchased";
        }
        return this.purchasedLaptop.getRamSize() + "GB";
    }


    public Laptop myLapTop(){
        return this.purchasedLaptop;  
    }


    public boolean isAdult(){
        return this.age >= 18;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
        this.isAdult = (age >= 18);
    }

    public void addPhoneNumber(String phoneNumber){
        if (phoneNumber == null || phoneNumber.length() != 10){
            System.out.println("Invalid phone number. Must be 10 digits.");
            return;
        }
        
        char firstChar = phoneNumber.charAt(0);
        if (firstChar < '6' || firstChar > '9'){
            System.out.println("Invalid phone number, must start with digits 6-9");
            return;
        }
        
        if (this.phoneNumbers.contains(phoneNumber)){
            System.out.println("Phone number already exists");
            return;
        }
        
        this.phoneNumbers.add(phoneNumber);
    }

    public ArrayList<String> getAllPhoneNumbers(){
    return new ArrayList<>(this.phoneNumbers);  // ✅ Returns a copy
}


    @Override
    public String toString(){
        return "Customer: " + this.name + " (" + this.age + " years), Email: " + this.email + 
               ", Phones: " + this.getAllPhoneNumbers() + ", Laptop: " + 
               (this.purchasedLaptop != null ? this.purchasedLaptop.getBrandName() : "None");
    }
}
