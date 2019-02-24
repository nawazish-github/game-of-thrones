package com.everest.engineering.highpriest;

import com.everest.engineering.dispatch.HighPriestMessageDispatcher;
import com.everest.engineering.dispatch.MessageDispatcher;
import com.everest.engineering.message.AbstractMessage;

import java.util.*;

public abstract class AbstractHighPriest implements HighPriest{
    protected List<AbstractMessage> luckyAbstractMessages = new ArrayList<>();
    private String emperor;
    private Map<String, List<String>> result;

    public abstract void luckyDrawMessages(List<AbstractMessage> ballot);

    @Override
    public void distributeMessagesToOwners(List<AbstractMessage> abstractMessages) {
        MessageDispatcher dispatcher = new HighPriestMessageDispatcher();
        this.result =  dispatcher.dispatch(abstractMessages);
    }

    @Override
    public String declareRuler(Map<String, List<String>> polls) {
        TreeMap<String, List<String>> map = new TreeMap<>(polls);
        emperor = map.lastEntry().getKey();
        return map.lastEntry().getKey();
    }

    public List<AbstractMessage> getLuckyMessages() {
        return luckyAbstractMessages;
    }

    public String getEmperor() {
        return emperor;
    }

    public Map<String, List<String>> getResult() {
        return result;
    }
}
