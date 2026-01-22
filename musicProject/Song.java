
public class Song {
    private String title;
    private int durationSeconds;
    private Musician composer;
    private Musician leadVocalist;
    private Musician[] performers;
    private String genre;
    
    public Song(String title, int durationSeconds, String genre) {
        this.title = title;
        this.durationSeconds = durationSeconds;
        this.genre = genre;
        this.performers = new Musician[5];
    }
    
    public void setComposer(Musician composer) {
        this.composer = composer;
    }
    
    public void setLeadVocalist(Musician vocalist) {
        this.leadVocalist = vocalist;
    }
    
    public void addPerformer(Musician musician, int position) {
        if (position < performers.length) {
            performers[position] = musician;
        }
    }
    
    public void playSong() {
        System.out.println("\n♪ Playing: " + title + " (" + genre + ")");
        System.out.println("Duration: " + durationSeconds + " seconds");
        if (composer != null) {
            System.out.println("Composed by: " + composer.getName());
        }
        if (leadVocalist != null) {
            System.out.println("Lead Vocals: " + leadVocalist.getName());
        }
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getDuration() {
        return durationSeconds;
    }
}
