
public class Band {
    private String bandName;
    private Musician leadSinger;
    private Musician guitarist;
    private Musician drummer;
    private Musician bassist;
    private Musician keyboardist;
    private int formationYear;
    
    public Band(String bandName, int formationYear) {
        this.bandName = bandName;
        this.formationYear = formationYear;
    }
    
    public void addMember(Musician musician, String role) {
        switch(role.toLowerCase()) {
            case "lead":
                leadSinger = musician;
                break;
            case "guitar":
                guitarist = musician;
                break;
            case "drums":
                drummer = musician;
                break;
            case "bass":
                bassist = musician;
                break;
            case "keyboard":
                keyboardist = musician;
                break;
        }
        System.out.println(musician.getName() + " joined " + bandName + " as " + role);
    }
    
    public void rehearse() {
        System.out.println("\n" + bandName + " is rehearsing...");
        if (guitarist != null) guitarist.performSolo();
        if (drummer != null) drummer.performSolo();
    }
    
    public void displayBandInfo() {
        System.out.println("\n=== Band: " + bandName + " ===");
        System.out.println("Formed: " + formationYear);
        if (leadSinger != null) 
            System.out.println("Lead Singer: " + leadSinger.getName());
        if (guitarist != null) 
            System.out.println("Guitarist: " + guitarist.getName());
    }
    
    public String getBandName() {
        return bandName;
    }
    
    public Musician getLeadSinger() {
        return leadSinger;
    }
}
