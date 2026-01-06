package org.example;

public class TariffCalculator {

    public static void main(String[] args) {
        // Ueberpruefung


        // Beispiel Basic (100min, 3GB, 9,99€): 90 Min, 5 GB
        // Zusatzkosten: 2 GB * 1.00 € = 2.00 €
        // Erwartet: 9.99 + 2.00 = 11.99 €
        System.out.println("Basic, 90min, 5GB");
        System.out.println("Erwartet: 11.99 | Ergebnis: " + TotalCost("basic", 90, 5.0));

        System.out.println();


        // Beispiel Basic (100min, 3GB, 9,99€): 220 Min, 10 GB
        // Zusatzkosten Min (+120): 100*0.05 + 20*0.12 = 5.00 + 2.40 = 7.40 €
        // Zusatzkosten Daten (+7 GB): 5*1.00 + 2*3.00 = 5.00 + 6.00 = 11.00 €
        // Erwartet: 9.99 + 7.40 + 11.00 = 28.39 €
        System.out.println("Basic, 220min, 10GB");
        System.out.println("Erwartet: 28.39 | Ergebnis: " + TotalCost("basic", 220, 10.0));

        System.out.println();


        // Beispiel Comfort (300min, 15GB, 19,99€): 305 Min, 16 GB
        // Zusatzkosten Min (+5): 5*0.05 = 0.25 €
        // Zusatzkosten Daten (+1 GB): 1*1.00 = 1.00 €
        // Erwartet: 19.99 + 0.25 + 1.00 = 21.24 €
        System.out.println("Comfort, 305min, 10GB");
        System.out.println("Erwartet: 21.24 | Ergebnis: " + TotalCost("comfort", 305, 16.0));

        System.out.println();

        // Beispiel Comfort (300min, 15GB, 19,99€): 500 Min, 25 GB
        // Zusatzkosten Min (+200): 100*0.05 + 100*0.12 = 5.00 + 12.00 = 17.00 €
        // Zusatzkosten Daten (+10 GB): 5*1.00 + 5*3.00 = 5.00 + 15.00 = 20.00 €
        // Erwartet: 19.99 + 17.00 + 20.00 = 56.99 €
        System.out.println("Comfort, 500min, 25GB");
        System.out.println("Erwartet: 56.99 | Ergebnis: " + TotalCost("comfort", 500, 25.0));

        System.out.println();


        // Beispiel Premium (1000min, 50GB, 39,99€): 1050 Min, 51 GB
        // Zusatzkosten Min (+50): 50*0.05 = 2.50 €
        // Zusatzkosten Daten (+1 GB): 1*1.00 = 1.00 €
        // Erwartet: 39.99 + 2.50 + 1.00 = 43.49 €
        System.out.println("Premium, 1050min, 51GB");
        System.out.println("Erwartet: 43.49 | Ergebnis: " + TotalCost("premium", 1050, 51.0));

        System.out.println();


        // Beispiel Premium (1000min, 50GB, 39,99€): 1150 Min, 50 GB
        // Zusatzkosten Min (+150): 100*0.05 + 50*0.12 = 5.00 + 6.00 = 11.00 €
        // Zusatzkosten Daten: 0 €
        // Erwartet: 39.99 + 11.00 = 50.99 €
        System.out.println("Premium, 1150min, 50GB");
        System.out.println("Erwartet: 50.99 | Ergebnis: " + TotalCost("premium", 1150, 50.0));
    }


    public static double TotalCost(String tariffType, int minutesUsed, double dataUsedGb) {
        int data = 0;
        int minutes = 0;
        double price = 0;
        switch (tariffType) {
            case "basic": {
                data = 3;
                minutes = 100;
                price = 9.99;
                break;
            }
            case "comfort": {
                data = 15;
                minutes = 300;
                price = 19.99;
                break;
            }
            case "premium": {
                data = 50;
                minutes = 1000;
                price = 39.99;
                break;
            }
            default: {
                System.out.println("Error");
            }
        }

        double dataCosts = 0;

        double minutesCosts = 0;

        if (dataUsedGb > data) {
            double additionalDataUsed = dataUsedGb - data;
            //bis zu +5 GB: 1 €/GB,
            if (additionalDataUsed <= 5) {
                dataCosts = additionalDataUsed * 1;
            }
            //mehr als +5 GB: 3 €/GB
            else if (additionalDataUsed > 5) {
                dataCosts = (5 * 1) + (additionalDataUsed - 5) * 3;
            }
        }


        if (minutesUsed > minutes) {
            double additionalMinutesUsed = minutesUsed - minutes;
            //bis zu +100 Minuten: 0,05 €/Minute,
            if (additionalMinutesUsed <= 100) {
                minutesCosts = additionalMinutesUsed * 0.05;
            }
            //mehr als +100 Minuten: 0,12 €/Minute
            else if (additionalMinutesUsed > 100) {
                minutesCosts = 100 * 0.05 + (additionalMinutesUsed - 100) * 0.12;
            }
        }

        return price += dataCosts + minutesCosts;
    }
}