package org.hbrs.se.ws20.uebung2;

import org.hbrs.se.ws20.uebung3.persistence.PersistenceException;
import org.hbrs.se.ws20.uebung3.persistence.PersistenceStrategy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Container {
	/*
	 * Interne ArrayList zur Abspeicherung der Objekte
	 * Alternative: HashMap oder Set. HashMap hat vor allem Probleme
	 * bei der Bewahrung der Konsistenz vom Key und Value (siehe TestStore, letzter Test)
	 */
	File containermembers;
	OutputStream out;
	static Container store;
	static int anzahlcontainer;
	static List<Member> liste;

	/*
	 * Leerer Konstruktor
	 */

	private Container(){
		this.liste = new ArrayList<>();

	}
	public static Container getInstance(){
		return store;
	}


	public static Container Containererzeugung(){
		Container store = new Container();
		if(anzahlcontainer >=1){
			store = null;
			System.out.println("Es wurde bereits ein Container angelegt");
		}
		if(anzahlcontainer == 0){
			++anzahlcontainer;
		}
		return store;
	}

	public void Weiterleitung(Container store,List<Member> liste){
		this.store = store;
		this.liste = liste;
	}

	
	/*
	 * Methode zum Hinzufuegen einer Member.
	 * @throws ContainerException
	 */

	public void addMember ( Member r ) throws ContainerException {
		if ( contains( r ) == true ) {
			ContainerException ex = new ContainerException();
			ex.addID ( r.getID() );
			throw ex;
		}
		liste.add( r );
	
	} 
	
	/*
	 * Methode zur Ueberpruefung, ob ein Member-Objekt in der Liste enthalten ist
	 * 
	 */
	private boolean contains(Member r) {
		Integer ID = r.getID();
		for ( Member rec : liste) {
			// wichtig: Check auf die Values innerhalb der Integer-Objekte!
			if ( rec.getID().intValue() == ID.intValue() ) {
				return true;
			}
		}
		return false;
		
		// liste.contains(r), falls equals-Methode in Member ueberschrieben.
	}
	/*
	 * Methode zum Loeschen einer Member
	 * 
	 */
	public String deleteMember( Integer id ) {
		Member rec = getMember( id );
		if (rec == null) return "Member nicht enthalten - ERROR"; else {
			liste.remove(rec);
			return "Member mit der ID " + id + " konnte geloescht werden";
		}
	}
	
	/*
	 * Methode zur Bestimmung der Anzahl der von Member-Objekten
	 * Aufruf der Methode size() aus List
	 * 
	 */
	public int size(){
		if (liste == null){
			return 0;
		}
		return liste.size();
	}

	
	/*
	 * Methode zur Ausgabe aller IDs der Member-Objekte. Es werden verschiedene Varianten vorgestellt!
	 * Fuer eine ordnungsgemaesse Ausgabe sollten die unpassenden Varianten und und Loesungen
	 * natuerlich auskommentiert werden.
	 * 
	 */

	private Member getMember(Integer id) {
		for ( Member rec : liste) {
			if (id == rec.getID().intValue() ){
				return rec;
			}
		}
		return null;
	}
	public void store() throws PersistenceException, IOException {
		this.containermembers = new File("Container.txt");
		this.out = new FileOutputStream(containermembers);
		for (int counter = 0; counter < size(); ++counter) {
			out.write(liste.get(counter).toString().getBytes());
		}
		out.close();
	}

	public void load() throws PersistenceException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(containermembers)));
		String memberobjects =reader.readLine();
		reader.close();
	}



}
