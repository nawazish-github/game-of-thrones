package com.everest.engineering.kingdom;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AbstractKingdom implements Kingdom {
    private final String name;
    private final Emblem emblem;
    private final Map<Character,Integer> kingdomNameMap;
    private volatile boolean hasVoted = false;

    public AbstractKingdom(String name, Emblem emblem) {
        this.name = name;
        kingdomNameMap = createCharFreqTable(emblem.getName());//ToDo: Is this required to be done here.
        this.emblem = emblem;
    }

    public boolean message(String message) {
        boolean voteStatus = verifyMessage(message);
        if (hasVoted)
            return false;
        else{
            hasVoted = true;
            return voteStatus;
        }
    }

    public boolean verifyMessage(String message) {
        Map<Character, Integer> msgFreqMap = createCharFreqTable(message);
        for (Map.Entry entry : kingdomNameMap.entrySet()){
            Character key = (Character) entry.getKey();
            Integer value = (Integer) entry.getValue();
            Integer i = msgFreqMap.get(key);
            if (i == null)
                return false;
            if (i < value)
                return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    private Map<Character,Integer> createCharFreqTable(String string) {
        Objects.requireNonNull(string, "Emblem animal name cannot be null!");
        Map<Character,Integer> freqMap = new HashMap<>();
        char[] chars = string.toLowerCase().toCharArray(); //normalize characters to avoid comparisons complications.
        for (char ch : chars){
            if (freqMap.containsKey(ch)){
                int freq = freqMap.get(ch);
                freqMap.put(ch, ++freq);
            }else{
                freqMap.put(ch, 1);
            }
        }
        return freqMap;
    }
}
