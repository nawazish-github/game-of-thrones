package com.everest.engineering.message;

import com.everest.engineering.kingdom.AbstractKingdom;

import java.util.Random;

public class DefaultMessage extends AbstractMessage{
    public DefaultMessage(AbstractKingdom sendor, AbstractKingdom receiver) {
        super(sendor, receiver);
    }
    private static Random random = new Random();

    @Override
    protected String getRandomMessage() {
        int i = random.nextInt();
        //24 implies the total number of standard msgs in the table. This would allow to choose a message randomly.
        int rand = (int)i%24;
        return getMessageTable().get(Math.abs(rand));
    }
}
