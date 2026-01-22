public class Album {
    private String albumTitle;
    private Band recordingBand;
    private Song[] tracks;
    private int releaseYear;
    private int trackCount;
    
    public Album(String albumTitle, Band recordingBand, int releaseYear, int maxTracks) {
        this.albumTitle = albumTitle;
        this.recordingBand = recordingBand;
        this.releaseYear = releaseYear;
        this.tracks = new Song[maxTracks];
        this.trackCount = 0;
    }
    
    public void addTrack(Song song) {
        if (trackCount < tracks.length) {
            tracks[trackCount] = song;
            trackCount++;
            System.out.println("Added '" + song.getTitle() + "' to album");
        }
    }
    
    public void playAlbum() {
        System.out.println("\n▶ Playing Album: " + albumTitle);
        System.out.println("By: " + recordingBand.getBandName());
        System.out.println("Released: " + releaseYear);
        System.out.println("Tracks:");
        
        for (int i = 0; i < trackCount; i++) {
            if (tracks[i] != null) {
                System.out.println((i+1) + ". " + tracks[i].getTitle());
            }
        }
    }
    
    public int getTotalDuration() {
        int total = 0;
        for (int i = 0; i < trackCount; i++) {
            if (tracks[i] != null) {
                total += tracks[i].getDuration();
            }
        }
        return total;
    }
    
    public String getAlbumTitle() {
        return albumTitle;
    }
}
