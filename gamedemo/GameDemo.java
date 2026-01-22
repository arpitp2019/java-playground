public class GameDemo {
    public static void main(String[] args) {
        // Create character
        GameCharacter hero = new GameCharacter("DragonSlayer");
        
        // Create weapon objects
        Weapon sword = new Weapon("Flaming Sword", 85);
        Weapon bow = new Weapon("Thunder Bow", 65);
        
        // Create pet object
        Pet dragon = new Pet("Sparky", "Fire Breath");
        
        // Equip weapons (passing references)
        hero.equipWeapon(sword, true);
        hero.equipWeapon(bow, false);
        
        // Adopt companion (passing reference)
        hero.adoptPet(dragon);
        
        // Use the referenced objects through character
        hero.attack();
        hero.callCompanion();
        hero.displayStatus();
        
        // Multiple references to same object
        GameCharacter villain = new GameCharacter("DarkKnight");
        villain.equipWeapon(sword, true);
        System.out.println("\nVillain steals the sword!");
        villain.attack();
    }
}
