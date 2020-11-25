package org.hbrs.se.ws20.uebung3.persistence;

import org.hbrs.se.ws20.uebung2.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MemberView {
    public void dump( List<Member> liste){
        System.out.println("Ausgabe aller Member-Objekte: ");


        liste.forEach( new Consumer<Member>() {
            @Override
            public void accept(Member p) {
                // Die Funktion
                System.out.println( p.toString()  );
            }
        });

        // Loesung Nr. 3:
        // Abkürzende Schreibweise für forEach mit einem LambaAusdruck
        // Ein Objekt wird mit einer Anweisung (Funktion) parametrisiert
        liste.forEach( (Member element) -> System.out.println(element));

        // Der Type Member kann auf der linken Seite weggelassen werden!
        liste.forEach( element -> System.out.println( element ) );


        // Loesung Nr. 4:
        // Vorteil: Möglichkeit der parallelen Verarbeitung der Liste möglich
        // Erhöht die Performance der Anwendung
        liste.parallelStream().forEach( element -> System.out.println(element) );

        // Ueber die Streaming-Funktion koennen weitere Filterungen durchgefuehrt werden
        // Dieses Vorgehen wird auch als Pattern Filter-Map-Reduce bezeichnet (vgl. Kapitel 4 bzw. 6
        // sowie die Uebung Nr. 4:
        // Variante 4.1 (mit zwei Filtern und mit foreach als Reduzierung (reduce)):
        System.out.println("Ausgabe als Stream:");
        liste.stream() // Parallelisierung hier moeglich mit .parallelstream()
                .filter( element -> element.getID() > 20 )
                .filter(element -> element.getID() < 1000 )
                .forEach(element -> System.out.println(element) );

        // Variante 4.2 (mit zwei Filtern und einer Reduzierung (reduce) auf eine Liste ohne foreach):
        List<Integer> newListe = liste.stream() // Parallelisierung hier moeglich mit .parallelstream()
                .filter( element -> element.getID() > 20 )
                .filter(element -> element.getID() < 1000 )
                .map( element -> element.getID() )
                .collect( Collectors.toList() );

        System.out.println( newListe );

        // Variante fuer die Variante Nr. 4.2:
        // Achtung: diese Variante ist im Gegensatz zur 4.2 nicht parallelisierbar!
        List<Integer> newListe2 = new ArrayList<Integer>();
        for ( Member p : liste ) {
            if (p.getID() > 20 && p.getID()<1000 ) {
                newListe2.add(p.getID());
            }
        }
        System.out.println(newListe2);

    }

    /*
     * Interne Methode zur Ermittlung einer Member
     *
     */
}
