package org.example.p10;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Date {
	/*
	 * Diese Klasse modelliert ein Datum und implementiert die Bestimmung der Differenz zwischen zwei Daten in Tagen.
	 */
	
	
	/*
	 * Das Attribut der Klasse ist ein Datum vom Typ LocalDate.
	 */
	LocalDate date;
	
	public Date(String date) {
		/*
		 * Dem Konstruktor wird ein Datum als Zeichenkette vom Format "YYYY-MM-DD" uebergeben.
		 */
		this.date = LocalDate.parse(date);
	}
	
	
	/*
	 * Die Methode der Klasse ist getDifferenceDays, der ein Datum als Zeichenkette vom Format "YYYY-MM-DD" uebergeben wird.
	 * Die Differenz zwischen dem Attribut date und dem uebergebenen Datum wird in Tagen zurueckgegeben.
	 * Im Kontext der Aufgabe kann mit dieser Methode also bestimmt werden, ob eine Deadline ueberschritten wurde oder nicht.
	 */
	public int getDifferenceDays(String date) {
		LocalDate newDate = LocalDate.parse(date);
		return (int) ChronoUnit.DAYS.between(this.date, newDate);
	}

}
