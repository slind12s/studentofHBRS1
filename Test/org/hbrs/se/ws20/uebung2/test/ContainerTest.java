package org.hbrs.se.ws20.uebung2.test;

import org.hbrs.se.ws20.uebung2.Container;
import org.hbrs.se.ws20.uebung2.Member;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ContainerTest {
    Member member5 = new Container();
    Member member8 = new Container();
    Member member3 = new Container();

    @BeforeEach
    void addMember(Member member1) {
        addMember(member1);
    }
    @Test
    void dump() {
        assertEquals(1,1);

    }
}