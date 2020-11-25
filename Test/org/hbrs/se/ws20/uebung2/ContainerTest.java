package org.hbrs.se.ws20.uebung2;

import org.hbrs.se.ws20.uebung2.Container;
import org.hbrs.se.ws20.uebung2.ContainerException;
import org.hbrs.se.ws20.uebung2.Member;
import org.hbrs.se.ws20.uebung2.MemberKonkret;
import org.hbrs.se.ws20.uebung2.*;
import org.hbrs.se.ws20.uebung3.persistence.PersistenceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void addMember() throws IOException, PersistenceException {
        // Test-Objekte anlegen
        Member r1 = new MemberKonkret(12);
        Member r2 = new MemberKonkret(32);
        Member r3 = new MemberKonkret(112);
        Member r4 = new MemberKonkret(1211);
        Member r5 = new MemberKonkret(934);

        // Den Container und die Liste holen
        Container.Containererzeugung();
        Container store = Container.store;







        // Testfall 1 - Check auf leeren Container
        assertEquals ( 0 , store.size() ,"Testfall 1 - Pruefung auf leeren Store"   );

        try {
            store.addMember( r1 );
            store.addMember( r2 );
            store.addMember( r3 );
            store.addMember( r4 );

        } catch (ContainerException e) {
            e.printStackTrace();
        }


        // Testfall 2 - Pruefen, ob vier Objekte eingefuegt wurden
        assertEquals ( 4 , store.size() ,"Testfall 2 - Prüfen, ob vier Objekte eingefuegt wurden"   );

        try {
            store.addMember(r5);
        } catch (ContainerException e) {
            e.printStackTrace();
        }

        // Testfall 3 - Pruefen, ob fuenftes Objekt eingefuegt wurde
        assertEquals ( 5 , store.size() , "Testfall 3 - Prüfen, ob fuenftes Objekt eingefuegt wurde"   );

        String result = store.deleteMember(12);
        // System.out.println( result );

        // Testfall 4 - Pruefen, ob Objekt geloescht wurde
        assertEquals (  4 , store.size()  , "Testfall 4 - Prüfen, ob Objekt geloescht wurde" );

        result = store.deleteMember(12222);
        System.out.println( result );

        // Testfall 5 - Pruefen, ob ein Objekt faelschlicherweise nicht geloescht wurde
        assertEquals (  4 , store.size() , "Testfall 5 - Pruefen, ob ein Objekt faelschlicherweise nicht geloescht wurde"  );

        try {
            store.addMember( r2 );
        } catch (ContainerException e) {

            e.printStackTrace();

        } finally {

            // Testfall 6 - Pruefen, ob ein Objekt faelschlicherweise nicht doppelt eingefuegt wurde
            assertEquals ( 4 , store.size() , "Testfall 6 - Pruefen, ob ein Objekt faelschlicherweise nicht doppelt eingefuegt wurde"  );
        }

        // Test der Dump-Funktion (ohne Kontrolle)

        //store.dump();
        store.store();
        store.load();

    }

}