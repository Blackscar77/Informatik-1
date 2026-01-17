package org.example.p10;

public class DVD extends Medium {
    private String director;
    private int duration;

    public DVD(String mediumID, String title, String director, int duration) {
        super(mediumID, title);
        this.director = director;
        this.duration = duration;
    }

    //Getter
    public String getDirector() {
        return director;
    }

    public int getDuration() {
        return duration;
    }
}
