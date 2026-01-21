package org.example.p11_3;

public interface Payment {
	
	/*
	 * Diese Klasse modelliert eine abstrakte Bezahlmethode.
	 */
	
	// Abstrakte Methode zum Bezahlen eines Betrags.
	public abstract boolean pay(double amount);
	
}
