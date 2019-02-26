package com.everest.engineering.main;

import com.everest.engineering.constants.StringConstants;

import java.util.Arrays;

public class GameOfEmpire {
    public static void main(String[] args) throws Exception {
        Game game = null;
        if (args.length ==0 //if no problem flag is provided, default to A Golden Crown solution
                || Arrays.asList(args).contains(StringConstants.A_GOLDEN_CROWN)){
            game = new A_GoldenCrown();
            game.play();
            return;
        }
        if (Arrays.asList(args).contains(StringConstants.BREAKER_OF_CHAINS)){
            game = new BreakerOfChain();
            game.play();
            return;
        }
    }
}
