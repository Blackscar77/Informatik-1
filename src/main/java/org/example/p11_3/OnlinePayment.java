package org.example.p11_3;

public interface OnlinePayment extends Payment {
	
	/*
	 * Diese Klasse modelliert eine abstrakte Online-Bezahlmethode.
	 * Die Attribute sind ein Guthaben und ein Pincode.
	 */
	/*
	protected double credit;
	protected String pinCode;

	 */
	
	// Abstrakte Methode zum verifizieren eines Pincodes.
	public abstract boolean verify(String pinCode);
	
	// Abstrakte Methode zum Aufladen eines Guthabens.
	public abstract void topup(double amount);
	
}
