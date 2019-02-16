package com.everest.engineering.input.parser;

import com.everest.engineering.constants.StringConstants;
import com.everest.engineering.exceptions.ParseException;
import com.everest.engineering.parser.CampaigningKingdomsParser;
import com.everest.engineering.parser.InputParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestCampaigningKingdomParser {
    @Test
    public void testParser() throws ParseException {
        List<String> kingdoms = new ArrayList<>();
        kingdoms.add("Air Ice Fire");

        List<String> expected = new LinkedList<>();
        expected.add("Air");
        expected.add("Ice");
        expected.add("Fire");

        InputParser parser = new CampaigningKingdomsParser();
        Map<String, Object> map = parser.parse(kingdoms);

        List<String> actual = (List) map.get(StringConstants.CAMPAIGNING_KINGDOMS);

        Assertions.assertIterableEquals(expected, actual);

    }
}
