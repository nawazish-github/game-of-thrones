package com.everest.engineering.message.dispatch;

import com.everest.engineering.dispatch.DefaultMessageDispatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TestMessageDispatch {
    @Test
    public void testDispatchMessagesForAllegiance(){
        Map<String, Object> inputMap = new LinkedHashMap<>();
        inputMap.put("AIR", "\"oaaawaala\"");
        inputMap.put("LAND", "\"a1d22n333a4444p\"");
        inputMap.put("ICE", "\"zmzmzmzaztzozh\"");

        List<String> expected = expected = Arrays.asList("AIR", "LAND", "ICE");
        DefaultMessageDispatcher defaultMessageDispatcher
                             = new DefaultMessageDispatcher();

        List<String> actual
                = defaultMessageDispatcher.dispatchMessagesForAllegiance(inputMap);

        Assertions.assertIterableEquals(expected, actual);
    }
}
