package com.everest.engineering.input.parser;

import com.everest.engineering.parser.LineInputParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestLineInputParser {
    @Test
    public void testParseInputs(){
        LineInputParser lineInputParser = new LineInputParser();
        List<String> inputList = new ArrayList<>();

        Map<String, String> expected = new HashMap<>();
        expected.put("AIR", "\"oaaawaala\"");
        expected.put("LAND", "\"a1d22n333a4444p\"");
        expected.put("ICE", "\"zmzmzmzaztzozh\"");

        inputList.add("Air, \"oaaawaala\"");
        inputList.add("Land, \"a1d22n333a4444p\"");
        inputList.add("Ice, \"zmzmzmzaztzozh\"");
        Map<String, Object> actual = lineInputParser.parse(inputList);

        Assertions.assertIterableEquals(expected.entrySet(), actual.entrySet());
    }
}
