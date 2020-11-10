package org.hbrs.se.ws20.uebung1.view;

import org.hbrs.se.ws20.uebung1.control.GermanTranslator;

class Client {
	public static void main (String [] args){
		Client u = new Client();
		u.display(20);
		u.display(10);
		u.display(-10);
	}

	/*
	 * Methode zur Ausgabe einer Zahl auf der Console
	 */
	public void display( int aNumber ){

		// In dieser Methode soll die Methode translateNumber 
		// mit dem übergegebenen Wert der Variable aNumber 
		// aufgerufen werden.
		// Strenge Implementierung gegen das Interface Translator gewuenscht!
		GermanTranslator translators = Hilfsklasse.hilfsmethode();
		System.out.println("Das Ergebnis der Berechnung: " +
				translators.translateNumber(aNumber));

	}


}




