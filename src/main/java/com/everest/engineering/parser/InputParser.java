package com.everest.engineering.parser;

import com.everest.engineering.exceptions.ParseException;

import java.util.List;
import java.util.Map;

public interface InputParser {
    public abstract Map<String, Object> parse(List<String> inputs) throws ParseException;
}
