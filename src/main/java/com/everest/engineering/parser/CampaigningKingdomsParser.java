package com.everest.engineering.parser;

import com.everest.engineering.constants.StringConstants;
import com.everest.engineering.exceptions.ParseException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CampaigningKingdomsParser implements InputParser {
    @Override
    public Map<String, Object> parse(List<String> inputs) {
        String campaigningKingdoms = inputs.get(0);
        List<String> list = Arrays.asList(campaigningKingdoms.split(" "));
        if (list.size() == 0)
            throw new IllegalArgumentException("No kingdom participating for " +
                    "being ruler of Southeros! Needs at least one kingdom");
        Map<String, Object> map = new HashMap<>();
        map.put(StringConstants.CAMPAIGNING_KINGDOMS, list);
        return map;
    }
}
