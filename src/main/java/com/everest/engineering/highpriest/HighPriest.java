package com.everest.engineering.highpriest;

import com.everest.engineering.message.AbstractMessage;

import java.util.List;
import java.util.Map;

public interface HighPriest {
    public abstract void luckyDrawMessages(List<AbstractMessage> ballot);
    public abstract void distributeMessagesToOwners(List<AbstractMessage> abstractMessages);
    public abstract String declareRuler(Map<String, List<String>> polls);
}
