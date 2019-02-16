package com.everest.engineering.highpriest;

import com.everest.engineering.message.Message;

import java.util.List;
import java.util.Map;

public interface HighPriest {
    public abstract void luckyDrawMessages();
    public abstract void distributeMessagesToOwners(List<Message> messages);
    public abstract String declareRuler(Map<String, List<String>> polls);
}
