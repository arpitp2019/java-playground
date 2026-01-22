
public class Address {
    private String street;
    private String city;
    private String country;
    private String zipCode;
    
    public Address(String street, String city, String country, String zipCode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
    }
    
    public String getFullAddress() {
        return street + ", " + city + ", " + country + " - " + zipCode;
    }
    
    public String getCity() {
        return city;
    }
}
