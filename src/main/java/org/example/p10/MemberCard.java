package org.example.p10;

public class MemberCard {

    protected String name;
    protected String mail;
    protected String memberID;
    protected int credit; //in cent
    protected Date deadline;

    protected Medium borrowedMedium;

    public MemberCard(String name, String mail, String memberID) {
        this.name = name;
        this.mail = mail;
        this.memberID = memberID;
        this.credit = 0;
        this.deadline = null;
    }


    public void topup(int add) {
        credit += add;
    }


    public boolean lend(Medium medium, String deadline) {
        if (this.borrowedMedium != null || !medium.isAvailable()) {
            return false;
        }
        this.borrowedMedium = medium;
        this.deadline = new Date(deadline);
        medium.setupLoan(this);
        return true;
    }

    public boolean returnMedium(String returnDateStr) {
        if (this.borrowedMedium == null) {
            return false;
        }

        // Deine Date-Klasse: ChronoUnit.DAYS.between(this.deadline, returnDate)
        // Beispiel: Deadline 2026-02-01, Rückgabe 2026-02-03 -> diff = -2
        int diff = this.deadline.getDifferenceDays(returnDateStr);
        int fine = 0;

        // Wenn diff negativ ist, ist die Rückgabe verspätet
        if (diff > 0) {
            fine = Math.abs(diff) * 50;
        }

        // Prüfung: Reicht das Guthaben für das Bußgeld?
        if (fine > this.credit) {
            return false;
        }

        // Bußgeld abziehen und Medium freigeben
        this.credit -= fine;
        this.borrowedMedium.resetLoan();
        this.borrowedMedium = null;
        this.deadline = null;

        return true;
    }

    //Getter
    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getMemberID() {
        return memberID;
    }

    public int getCredit() {
        return credit;
    }

    public Date getDeadline() {
        return deadline;
    }

    public Medium getBorrowedMedium() {
        return borrowedMedium;
    }
}
