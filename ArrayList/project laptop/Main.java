
public class Main{
    public static void main(String[] args){
        Laptop laptop1 = new Laptop("escar");
        Customer customer1 = new Customer("Arpit",29,"arpitchamp1996@gmail.com","9827046820",false,true,laptop1);

        customer1.addPhoneNumber("9981098942");
        System.out.println(customer1.myLapTop().upgradeTheLaptopRam(3));
        System.out.println(customer1.myLapTop().getPrice());
        
    }

}


