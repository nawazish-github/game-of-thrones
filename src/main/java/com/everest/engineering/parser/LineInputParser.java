package com.everest.engineering.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineInputParser implements InputParser{
    public Map<String, Object> parse(List<String> inputs){
        Map<String, Object> inputMap = new HashMap<>();
        for (String input : inputs){
            String[]tokens = input.split(",");
            inputMap.put(normalizeKingdomName(tokens[0].trim()), (Object)tokens[1].trim());
        }
        return inputMap;
    }

    private String normalizeKingdomName(String token) {
        return token.toUpperCase();
    }
}
