class Weapon {
    private String name;
    private int damage;
    
    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }
    
    public void displayInfo() {
        System.out.println(name + " (Damage: " + damage + ")");
    }
    
    public int getDamage() {
        return damage;
    }
}