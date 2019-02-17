package com.everest.engineering.message;

import com.everest.engineering.kingdom.AbstractKingdom;
import com.everest.engineering.kingdom.Kingdom;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMessage {
    private final AbstractKingdom sendor;
    private final AbstractKingdom receiver;
    private final String message;
    private final static List<String> messageTable = initializeMessageTable();

    public AbstractMessage(AbstractKingdom sendor, AbstractKingdom receiver) {
        this.sendor = sendor;
        this.receiver = receiver;
        this.message = getRandomMessage();
    }

    /*private String getRandomMessage() {
        //24 implies the total number of standard msgs in the table. This would allow to choose a message randomly.
        int rand = (int)Math.random()%24;
        return messageTable.get(rand);
    }*/

    protected abstract String getRandomMessage();

    private static List<String> initializeMessageTable(){
        List<String> list = new ArrayList<>();
        list.add("Summer is coming");
        list.add("a1d22n333a4444p");
        list.add("oaaawaala");
        list.add("zmzmzmzaztzozh");
        list.add("Go, risk it all");
        list.add("Let's swing the sword together");
        list.add("Die or play the tame of thrones");
        list.add("Ahoy! Fight for me with men and money");
        list.add("Drag on Martin!");
        list.add("When you play the tame of thrones, you win or you die.");
        list.add("What could we say to the Lord of Death? Game on?");
        list.add("Turn us away, and we will burn you first");
        list.add("Death is so terribly final, while life is full of possibilities.");
        list.add("You Win or You Die");
        list.add("His watch is Ended");
        list.add("Sphinx of black quartz, judge my dozen vows");
        list.add("Fear cuts deeper than swords, My Lord.");
        list.add("Different roads sometimes lead to the same castle.");
        list.add("A DRAGON IS NOT A SLAVE.");
        list.add("Do not waste paper");
        list.add("Go ring all the bells");
        list.add("Crazy Fredrick bought many very exquisite pearl, emerald and diamond jewels.");
        list.add("The quick brown fox jumps over a lazy dog multiple times.");
        list.add("We promptly judged antique ivory buckles for the next prize.");
        list.add("Walar Morghulis: All men must die.");
        return list;
    }

    public AbstractKingdom getSendor() {
        return sendor;
    }

    public AbstractKingdom getReceiver() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }

    public static List<String> getMessageTable() {
        return messageTable;
    }
}
