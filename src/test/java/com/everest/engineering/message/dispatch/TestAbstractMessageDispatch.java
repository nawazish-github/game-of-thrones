package com.everest.engineering.message.dispatch;

import com.everest.engineering.dispatch.DefaultMessageDispatcher;
import com.everest.engineering.factory.kingdom.KingdomFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TestAbstractMessageDispatch {


    @Test
    public void testDispatchMessagesForAllegiance(){
        KingdomFactory.resetKingdoms();
        Map<String, Object> inputMap = new LinkedHashMap<>();
        inputMap.put("AIR", "\"oaaawaala\"");
        inputMap.put("LAND", "\"a1d22n333a4444p\"");
        inputMap.put("ICE", "\"zmzmzmzaztzozh\"");

        List<String> expected = expected = Arrays.asList("AIR", "LAND", "ICE");
        DefaultMessageDispatcher defaultMessageDispatcher
                             = new DefaultMessageDispatcher();
        List<String> actual
                = defaultMessageDispatcher.dispatchMessagqesForAllegiance(inputMap);

        if (expected.size() != actual.size())
            Assertions.assertFalse(true, "Sizes differ: "
                    + "Expected size "+expected.size()+" Actual size: "+actual.size());
        for (String s : expected){
            if(!actual.contains(s))
                Assertions.assertFalse(true, "Content differ: "+ s +" not found");
        }
    }
}
