public class MusicStudioApp {
    public static void main(String[] args) {
        
        Instrument electricGuitar = new Instrument("Fender Stratocaster", "Electric Guitar", 1500.0);
        Instrument drums = new Instrument("Pearl Drum Kit", "Drums", 3000.0);
        Instrument bass = new Instrument("Fender Jazz Bass", "Bass Guitar", 1200.0);
        Instrument keyboard = new Instrument("Roland Synthesizer", "Keyboard", 2500.0);
        
        Address venueAddress = new Address("123 Rock Avenue", "Los Angeles", "USA", "90001");
        
        Musician alex = new Musician("Alex Thunder", 28, "Lead Vocals");
        Musician sarah = new Musician("Sarah Strings", 25, "Guitar");
        sarah.assignInstrument(electricGuitar, true);
        
        Musician mike = new Musician("Mike Boom", 30, "Drums");
        mike.assignInstrument(drums, true);
        
        Musician jenny = new Musician("Jenny Bass", 27, "Bass");
        jenny.assignInstrument(bass, true);
        
        Musician chris = new Musician("Chris Keys", 29, "Keyboard");
        chris.assignInstrument(keyboard, true);
        
        Venue stadiumVenue = new Venue("Rock Paradise Stadium", venueAddress, 50000, "Outdoor Stadium");
        
        Band thunderBolts = new Band("Thunder Bolts", 2018);
        thunderBolts.addMember(alex, "lead");
        thunderBolts.addMember(sarah, "guitar");
        thunderBolts.addMember(mike, "drums");
        thunderBolts.addMember(jenny, "bass");
        thunderBolts.addMember(chris, "keyboard");
        
        Song song1 = new Song("Electric Storm", 240, "Rock");
        song1.setComposer(sarah);
        song1.setLeadVocalist(alex);
        song1.addPerformer(sarah, 0);
        song1.addPerformer(mike, 1);
        
        Song song2 = new Song("Highway Dreams", 210, "Rock");
        song2.setComposer(alex);
        song2.setLeadVocalist(alex);
        
        Song song3 = new Song("Thunder Roll", 195, "Rock");
        song3.setComposer(sarah);
        song3.setLeadVocalist(alex);
        
        Album album = new Album("Electric Nights", thunderBolts, 2024, 5);
        album.addTrack(song1);
        album.addTrack(song2);
        album.addTrack(song3);
        
        System.out.println("\n" + "=".repeat(60));
        album.playAlbum();
        System.out.println("Total Duration: " + album.getTotalDuration() + " seconds");
        
        Concert megaConcert = new Concert("Summer Rock Fest 2026", thunderBolts, 
                                         stadiumVenue, "July 15, 2026", 150.0);
        megaConcert.setFeaturedAlbum(album);
        megaConcert.addToSetlist(song1);
        megaConcert.addToSetlist(song2);
        megaConcert.addToSetlist(song3);
        
        megaConcert.startConcert();
        megaConcert.estimateRevenue();
    }
}
