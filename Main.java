/* 
public class Main {
    public static void main(String[] args) {
        // 1. Original object create kiya
        Person original = new Person("arpit", 29);
        
        // 2. Method call kiya jo naya object return karega
        Person twin = createTwin(original);
        
        // 3. Twin ka naam badal diya
        twin.setName("Karan");

        System.out.println("Original Name: " + original.getName()); // Arjun
        System.out.println("Twin Name: " + twin.getName());         // Karan
    }

    // Ye method Person object ko parameter mein leta hai aur naya object return karta hai
    public static Person createTwin(Person injectedName) {
        // Yahan 'new' use karke Heap mein ek naya memory space banaya
        Person newPerson = new Person(injectedName.getName(), injectedName.getAge());
        return newPerson;
    }
}

*/

class Person {
    private String name;
    private int age; // Primitive Field

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Shallow Copy Constructor
    public Person(Person other) {
        this.name = other.name; // String is a reference but immutable
        this.age = other.age;   // Primitive value copy ho rahi hai
    }

    public void setAge(int age) { this.age = age; }
    public int getAge() { return this.age; }
    public String getName() { return this.name; }
}

public class Main {
    public static void main(String[] args) {
        // 1. Original Object banaya
        Person original = new Person("Arpit", 29);

        // 2. Shallow Copy banayi (Naya object, but shared internal references)
        Person copy = new Person(original);

        // 3. Copy ki age badal di
        copy.setAge(35);

        // Result Check
        System.out.println("Original Age: " + original.getAge()); // Output: 29
        System.out.println("Copy Age: " + copy.getAge());         // Output: 35
    }
}