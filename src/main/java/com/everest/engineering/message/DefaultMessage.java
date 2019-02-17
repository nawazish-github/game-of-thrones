package com.everest.engineering.message;

import com.everest.engineering.kingdom.AbstractKingdom;

public class DefaultMessage extends AbstractMessage{
    public DefaultMessage(AbstractKingdom sendor, AbstractKingdom receiver) {
        super(sendor, receiver);
    }

    @Override
    protected String getRandomMessage() {
        //24 implies the total number of standard msgs in the table. This would allow to choose a message randomly.
        int rand = (int)Math.random()%24;
        return getMessageTable().get(rand);
    }
}
