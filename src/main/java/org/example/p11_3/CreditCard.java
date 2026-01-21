package org.example.p11_3;

public class CreditCard implements OfflinePayment, OnlinePayment {

    /*
     * Diese Klasse beinhaltet Objekte, die eine Kreditkrate darstellen.
     */

    protected double credit;
    protected String pinCode;

    public CreditCard(double credit, String pinCode) {
        // Das Guthaben und der Pincode werden bei Konstruktion gesetzt.
        this.credit = credit;
        this.pinCode = pinCode;
    }

    public boolean pay(double amount) {
        // Beim Bezahlen wird der Betrag vom Guthaben abgezogen.
        this.credit -= amount;
        return true;
    }

    public void printReceipt(double amount) {
        // Es wird ein Beleg mit dem Betrag ausgedruckt.
        System.out.println("Payment of " + amount + "euro successful!\nPayed with Credit Card.\nHave a lovely day!");
    }

    public boolean verify(String pinCode) {
        // Der ueberbegene Pincode wird mit dem Pincode der Kreditkarte verglichen.
        return pinCode == this.pinCode;
    }

    public void topup(double amount) {
        // Wenn auf der Kreditkarte noch Guthaben vorhanden ist, wird der uebergebene Betrag addiert.
        // Sonst werden die Schulden zzgl. 5 Prozent beglichen und der ggf. uebrige Restbetrag aufgeladen.
        if (this.credit < 0) {
            double debt = -credit * 1.05;
            if (debt <= amount) {
                this.credit += (amount - debt);
            } else {
                this.credit += amount / 1.05;
            }
        } else {
            this.credit += amount;
        }

    }

    public boolean pay(double amount, String pinCode, boolean online) {
        // Wenn es sich um eine Online-Zahlung handelt, wird der Pincode ueberprueft und anschliessend eine Zahlung
        // durchgefuehrt, ohne dass ein Beleg gedruckt wird.
        // Wenn es sich um eine Offline-Zahlung handelt, wird die Zahlung durchgefuehrt und ein Beleg gedruckt.
        if (online) {
            if (this.verify(pinCode)) {
                return this.pay(amount);
            }
            return false;
        } else {
            boolean success = this.pay(amount);
            if (success) {
                this.printReceipt(amount);
            }
            return success;
        }
    }
}
