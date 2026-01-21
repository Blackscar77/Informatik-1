package org.example.p11_3;

public class DigitalPay implements OnlinePayment{
	
	/*
	 * Diese Klasse beinhaltet Objekte, die eine Bezahlmethode mit DigitalPay darstellen.
	 */

	protected double credit;
	protected String pinCode;
	
	public DigitalPay(double credit, String pinCode) {
		// Das Guthaben und der Pincode werden bei Konstruktion gesetzt.
		this.credit = credit;
		this.pinCode = pinCode;
	}
	
	@Override
	public boolean verify(String pinCode) {
		// Der ueberlegene Pincode wird mit dem Pincode der Kreditkarte verglichen.
		return pinCode == this.pinCode;
	}
	
	@Override
	public void topup(double amount) {
		// Der uebergebene Betrag wird zum Guthaben addiert.
		this.credit += amount;
	}

	@Override
	public boolean pay(double amount) {
		// Wenn das Guthaben mindestens so hoch ist wie der Betrag, ist die Bezahlung erfolgreich.
		if (this.credit >= amount) {
			this.credit -= amount;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean pay(double amount, String pinCode) {
		// Wenn der uebergebene Pincode korrekt ist, wird die Bezahlung durchgefuehrt.
		if (this.verify(pinCode)) {
			return this.pay(amount);
		} else {
			return false;
		}
	}
	
}
