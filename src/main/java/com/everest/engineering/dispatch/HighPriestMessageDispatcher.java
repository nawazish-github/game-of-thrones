package com.everest.engineering.dispatch;

import com.everest.engineering.factory.kingdom.KingdomFactory;
import com.everest.engineering.kingdom.AbstractKingdom;
import com.everest.engineering.message.AbstractMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HighPriestMessageDispatcher implements MessageDispatcher {
    @Override
    public Map<String, List<String>> dispatch(List<AbstractMessage> abstractMessages) {
        Map<String, List<String>> map = new HashMap<>();
        for (AbstractMessage abstractMessage : abstractMessages){
            AbstractKingdom abstractKingdom
                    = KingdomFactory.getInstance(abstractMessage.getReceiver().getName());
            boolean allegiance = abstractKingdom.message(abstractMessage.getMessage());
            if (allegiance){
                if (!map.keySet().contains(abstractMessage.getSendor().getName())){
                    List<String> list = new ArrayList<>();
                    list.add(abstractMessage.getReceiver().getName());
                    map.put(abstractMessage.getSendor().getName(), list);
                }else{
                    List<String> list = map.get(abstractMessage.getSendor().getName());
                    list.add(abstractMessage.getReceiver().getName());
                    map.put(abstractMessage.getSendor().getName(), list);
                }
            }
        }
        return map;
    }
}
