package com.everest.engineering.dispatch;

import com.everest.engineering.factory.kingdom.KingdomFactory;
import com.everest.engineering.kingdom.AbstractKingdom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DefaultMessageDispatcher {
    public List<String> dispatchMessagesForAllegiance(Map<String, Object> inputMap){
        List<String> allegianceList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : inputMap.entrySet()){
            AbstractKingdom abstractKingdom
                    = KingdomFactory.getInstance(entry.getKey());
            boolean allegiance = abstractKingdom.message((String) entry.getValue());
            if (allegiance)
                allegianceList.add(entry.getKey());
        }
        return allegianceList;
    }
}
