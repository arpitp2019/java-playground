class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter methods
    public String getName() { return this.name; }
    public int getAge() { return this.age; }

    // Setter method
    public void setName(String newName) { this.name = newName; }
}
