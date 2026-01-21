package org.example.p11_3;

public interface OfflinePayment extends Payment {
	
	/*
	 * Diese Klasse modelliert eine abstrakte Offline-Bezahlmethode.
	 */
	
	// Abstrakte Methode zum Drucken eines Belegs bei einer Offline-Bezahlung.
	public abstract void printReceipt(double amount);
	
}
