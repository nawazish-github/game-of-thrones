package com.everest.engineering.main;

import com.everest.engineering.constants.StringConstants;
import com.everest.engineering.dispatch.DefaultMessageDispatcher;
import com.everest.engineering.exceptions.ParseException;
import com.everest.engineering.parser.InputParser;
import com.everest.engineering.parser.LineInputParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GameOfEmpire {
    public static void main(String[] args) throws ParseException {
        System.out.println(StringConstants.GREETING);
        System.out.println(StringConstants.INPUT_GREETING);

        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        while(true){
            System.out.print(StringConstants.INPUT);
            String input = scanner.nextLine();
            if (input.isEmpty())
                break;
            inputs.add(input);
        }
        InputParser lineInputParser = new LineInputParser(); //ToDo: Might need an interface
        Map<String, Object> inputMap = lineInputParser.parse(inputs);
        DefaultMessageDispatcher defaultMessageDispatcher = new DefaultMessageDispatcher();
        List<String> allegianceList
                = defaultMessageDispatcher.dispatchMessagesForAllegiance(inputMap);
        System.out.println(StringConstants.QUESTION);
        System.out.print(StringConstants.OUTPUT);
        if (allegianceList.size() < 3){
            System.out.println(StringConstants.NONE);
            return;
        }
        else
            System.out.println(StringConstants.KING_SHAN);
        System.out.println(StringConstants.ALLIES);
        System.out.print(StringConstants.OUTPUT);
        if(allegianceList.size() == 0){
            System.out.println(StringConstants.NONE);
        }
        else{
            System.out.println(allegianceList);
        }
    }
}
