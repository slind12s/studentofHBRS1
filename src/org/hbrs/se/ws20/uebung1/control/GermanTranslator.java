package org.hbrs.se.ws20.uebung1.control;
import java.util.*;
public class GermanTranslator implements Translator {

	public String date = "Okt/2020"; // Default-Wert

	/**
	 * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
	 */
	public String translateNumber( int number ) {
		// [ihr Source Code aus Übung 1-2]
		Hashtable<Integer, String> my_dict = new Hashtable<Integer, String>();
		my_dict.put(1,"eins");
		my_dict.put(2,"zwei");
		my_dict.put(3,"drei");
		my_dict.put(4,"vier");
		my_dict.put(5,"fünf");
		my_dict.put(6,"sechs");
		my_dict.put(7,"sieben");
		my_dict.put(8,"acht");
		my_dict.put(9,"neun");
		my_dict.put(10,"zehn");

		if(number < 1 | number >10){
			String fehler = "Übersetzung der Zahl " + number + " nicht möglich " + version;
			return fehler;
		}
		return my_dict.get(number);
	}
		
	/**
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	public void printInfo() {
		System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
	}

	/**
	 * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: Nov/2020))
	 * Das Datum sollte system-intern gesetzt werden und nicht von externen View-Klassen
	 */
	public void setDate( String date ) {
		this.date = date;
	}

}
