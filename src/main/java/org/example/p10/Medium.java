package org.example.p10;

public abstract class Medium {

    protected String title;
    protected String mediumID;
    protected boolean available;
    protected MemberCard currentBorrower;

    public Medium(String mediumID, String title) {
        this.mediumID = mediumID;
        this.title = title;
        this.available = true;
        this.currentBorrower = null;
    }

    public void setupLoan(MemberCard memberCard) {
        available = false;
        currentBorrower = memberCard;
    }

    public void resetLoan() {
        available = true;
        currentBorrower = null;
    }

    //Getter
    public String getTitle() {
        return title;
    }

    public String getMediumID() {
        return mediumID;
    }

    public boolean isAvailable() {
        return available;
    }

    public MemberCard getCurrentBorrower() {
        return currentBorrower;
    }
}
