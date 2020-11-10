package org.hbrs.se.ws20.uebung1.control.test;

import org.hbrs.se.ws20.uebung1.control.GermanTranslator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    @Test
    void translateNumberTest() {
        GermanTranslator x = new GermanTranslator();
        double version = x.version;
        assertEquals("eins", x.translateNumber(1));
        assertEquals("fünf", x.translateNumber(5));
        assertEquals("zehn", x.translateNumber(10));
        assertEquals("Übersetzung der Zahl " + 90 + " nicht möglich " + version, x.translateNumber(90));
        assertEquals("Übersetzung der Zahl " + -10 + " nicht möglich " + version, x.translateNumber(-10));
        assertEquals("Übersetzung der Zahl " + 0 + " nicht möglich " + version, x.translateNumber(0));

    }
}
