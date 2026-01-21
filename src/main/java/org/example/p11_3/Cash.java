package org.example.p11_3;

public class Cash implements OfflinePayment {

	/*
	 * Diese Klasse beinhaltet Objekte, die eine Bezahlmethode mittels Bargeld darstellen.
	 */

	@Override
	public void printReceipt(double amount) {
		// Es wird ein Beleg mit dem Betrag ausgedruckt.
		System.out.println("Payment of " + amount + "euro successful!\nPayed with Cash.\nHave a nice day!");
	}

	@Override
	public boolean pay(double amount) {
		// Es wird ein Beleg mit dem Betrag ausgedruckt. Das Bezahlen mit Bargeld ist immer erfolgreich.
		this.printReceipt(amount);
		return true;
	}

}
