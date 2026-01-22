class Pet {
    private String name;
    private String ability;
    
    public Pet(String name, String ability) {
        this.name = name;
        this.ability = ability;
    }
    
    public void useAbility() {
        System.out.println(name + " uses " + ability + "!");
    }
}
