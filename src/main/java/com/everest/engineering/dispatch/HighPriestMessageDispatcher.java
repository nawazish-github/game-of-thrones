package com.everest.engineering.dispatch;

import com.everest.engineering.factory.kingdom.KingdomFactory;
import com.everest.engineering.kingdom.AbstractKingdom;
import com.everest.engineering.message.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HighPriestMessageDispatcher implements MessageDispatcher {
    @Override
    public Map<String, List<String>> dispatch(List<Message> messages) {
        Map<String, List<String>> map = new HashMap<>();
        for (Message message : messages){
            AbstractKingdom abstractKingdom
                    = KingdomFactory.getInstance(message.getReceiver().getName());
            boolean allegiance = abstractKingdom.message(message.getMessage());
            if (allegiance){
                if (!map.keySet().contains(message.getSendor().getName())){
                    List<String> list = new ArrayList<>();
                    list.add(message.getReceiver().getName());
                    map.put(message.getSendor().getName(), list);
                }else{
                    List<String> list = map.get(message.getSendor().getName());
                    list.add(message.getReceiver().getName());
                    map.put(message.getSendor().getName(), list);
                }
            }
        }
        return map;
    }
}
