package org.example.p10;

public class Library {
    public static void main(String[] args) {
        // Medien erstellen
        Book hp = new Book("B1", "Harry Potter und der Stein der Weisen", "J. K. Rowling", "978-3-551-55167-7", 335);
        CD cd = new CD("C1", "Take Me Back To Eden", "Sleep Token", 12);
        DVD dvd = new DVD("D1", "Avatar Aufbruch nach Pandora", "James Cameron", 162);

        // Kunden erstellen
        MemberCard chris = new MemberCard("Chris Tall", "chris.tall@gmail.com", "ID001");
        MemberCard ralf = new MemberCard("Ralf Schmitz", "ralf.schmitz@gmail.com", "ID002");

        // Chris leiht CD
        System.out.println("Chris leiht CD (erwartet: true): " + chris.lend(cd, "2026-01-31"));

        // Ralf versucht CD zu leihen (sollte fehlschlagen)
        System.out.println("Ralf leiht CD (belegt) (erwartet: false): " + ralf.lend(cd, "2026-02-01"));

        // Ralf leiht DVD
        System.out.println("Ralf leiht DVD (erwartet: true): " + ralf.lend(dvd, "2026-02-01"));

        // Chris versucht Buch zu leihen (hat schon CD)
        System.out.println("Chris leiht Buch (limit 1) (erwartet: false): " + chris.lend(hp, "2026-02-04"));

        // 15.01.2026: Chris gibt CD zurück und leiht Buch
        System.out.println("Chris gibt CD zurück (erwartet: true): " + chris.returnMedium("2026-01-15"));
        System.out.println("Chris leiht nun Buch (erwartet: true): " + chris.lend(hp, "2026-02-15"));

        // 03.02.2026: Ralf möchte DVD zurückgeben (überfällig seit 01.02.)
        // 2 Tage Verzug = 100 Cent. Ralf hat 0 Guthaben.
        System.out.println("Ralf gibt DVD zurück (ohne Geld) (erwartet: false): " + ralf.returnMedium("2026-02-03"));

        System.out.println("5€ Aufladen");
        ralf.topup(500); // 5 Euro aufladen
        System.out.println("Ralf gibt DVD zurück (nach Aufladung) (erwartet: true): " + ralf.returnMedium("2026-02-03"));
        System.out.println("Ralfs Restguthaben (in Cent): " + ralf.getCredit());
    }
}