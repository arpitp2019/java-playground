public class Musician {
    private String name;
    private int age;
    private Instrument primaryInstrument;
    private Instrument secondaryInstrument;
    private String specialization;
    
    public Musician(String name, int age, String specialization) {
        this.name = name;
        this.age = age;
        this.specialization = specialization;
    }
    
    public void assignInstrument(Instrument instrument, boolean isPrimary) {
        if (isPrimary) {
            this.primaryInstrument = instrument;
            System.out.println(name + " is now playing " + instrument.getName());
        } else {
            this.secondaryInstrument = instrument;
        }
    }
    
    public void performSolo() {
        if (primaryInstrument != null) {
            primaryInstrument.tune();
            System.out.println(name + " performs an amazing " + 
                             primaryInstrument.getType() + " solo!");
        }
    }
    
    public String getName() {
        return name;
    }
    
    public Instrument getPrimaryInstrument() {
        return primaryInstrument;
    }
}
