package org.example.p10;

public class CD extends Medium {
    private String artist;
    private int soundtracks;

    public CD(String mediumID, String title, String artist, int soundtracks) {
        super(mediumID, title);
        this.artist = artist;
        this.soundtracks = soundtracks;
    }


    //Getter
    public String getArtist() {
        return artist;
    }

    public int getSoundtracks() {
        return soundtracks;
    }
}
