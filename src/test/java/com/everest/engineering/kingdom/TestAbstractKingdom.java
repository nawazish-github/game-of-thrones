package com.everest.engineering.kingdom;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAbstractKingdom {

    private Emblem emblem = new Emblem("Panda");
    private TestDoubleKingdom testDoubleKingdom = new TestDoubleKingdom("LAND", emblem);

    @Test
    public void testVerifyMessageWhenSecretMessageIsCorrect(){
        boolean allegiance = testDoubleKingdom.message("a1d22n333a4444p");
        Assertions.assertEquals(true, allegiance);
    }

    @Test
    public void testVerifyMessageWhenSecretMessageIsInCorrect(){
        boolean allegiance = testDoubleKingdom.message("1234");
        Assertions.assertEquals(false, allegiance);
        allegiance = testDoubleKingdom.message(" ");
        Assertions.assertEquals(false, allegiance);
    }

    @Test
    public void testVerifyMessageWhenSecretMessageIsIn(){
         Assertions.assertThrows(NullPointerException.class, ()->testDoubleKingdom.message(null));
    }
}

class TestDoubleKingdom extends AbstractKingdom{

    public TestDoubleKingdom(String name, Emblem emblem) {
        super(name, emblem);
    }
}
