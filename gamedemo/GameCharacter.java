public class GameCharacter {
    private String playerName;
    private Weapon primaryWeapon;
    private Weapon secondaryWeapon;
    private Pet companion;
    private int health;
    
    public GameCharacter(String playerName) {
        this.playerName = playerName;
        this.health = 100;
    }
    
    public void equipWeapon(Weapon weapon, boolean isPrimary) {
        if (isPrimary) {
            primaryWeapon = weapon;
            System.out.println(playerName + " equipped primary weapon");
        } else {
            secondaryWeapon = weapon;
        }
    }
    
    public void adoptPet(Pet pet) {
        companion = pet;
        System.out.println(playerName + " adopted a companion!");
    }
    
    public void attack() {
        if (primaryWeapon != null) {
            System.out.print(playerName + " attacks with ");
            primaryWeapon.displayInfo();
            health -= 5;
        } else {
            System.out.println(playerName + " has no weapon equipped!");
        }
    }
    
    public void callCompanion() {
        if (companion != null) {
            companion.useAbility();
        } else {
            System.out.println("No companion to call!");
        }
    }
    
    public void displayStatus() {
        System.out.println("\n=== " + playerName + "'s Status ===");
        System.out.println("Health: " + health);
        System.out.print("Primary Weapon: ");
        if (primaryWeapon != null) {
            primaryWeapon.displayInfo();
        } else {
            System.out.println("None");
        }
    }
}
