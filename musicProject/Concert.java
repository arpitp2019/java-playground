public class Concert {
    private String concertName;
    private Band performingBand;
    private Venue concertVenue;
    private Song[] setlist;
    private Album featuredAlbum;
    private String date;
    private double ticketPrice;
    private int setlistCount;
    
    public Concert(String concertName, Band band, Venue venue, String date, double ticketPrice) {
        this.concertName = concertName;
        this.performingBand = band;
        this.concertVenue = venue;
        this.date = date;
        this.ticketPrice = ticketPrice;
        this.setlist = new Song[10];
        this.setlistCount = 0;
    }
    
    public void setFeaturedAlbum(Album album) {
        this.featuredAlbum = album;
    }
    
    public void addToSetlist(Song song) {
        if (setlistCount < setlist.length) {
            setlist[setlistCount] = song;
            setlistCount++;
        }
    }
    
    public void startConcert() {
        System.out.println("\n");
        System.out.println("=".repeat(60));
        System.out.println("🎸  " + concertName.toUpperCase() + "  🎸");
        System.out.println("=".repeat(60));
        System.out.println("Date: " + date);
        System.out.println("Ticket Price: $" + ticketPrice);
        
        concertVenue.displayVenueInfo();
        performingBand.displayBandInfo();
        
        if (featuredAlbum != null) {
            System.out.println("\nFeaturing Album: " + featuredAlbum.getAlbumTitle());
        }
        
        System.out.println("\n--- SETLIST ---");
        for (int i = 0; i < setlistCount; i++) {
            if (setlist[i] != null) {
                System.out.println((i+1) + ". " + setlist[i].getTitle());
            }
        }
        
        System.out.println("\n🎵 Concert is starting! 🎵");
        performingBand.rehearse();
        
        if (setlistCount > 0 && setlist[0] != null) {
            setlist[0].playSong();
        }
    }
    
    public void estimateRevenue() {
        double maxRevenue = concertVenue.getCapacity() * ticketPrice;
        System.out.println("\nEstimated Max Revenue: $" + maxRevenue);
    }
}
