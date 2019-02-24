package com.everest.engineering.main;

import com.everest.engineering.ballot.BallotSystem;
import com.everest.engineering.ballot.DefaultBallotSystem;
import com.everest.engineering.constants.StringConstants;
import com.everest.engineering.highpriest.DefaultHighPriest;
import com.everest.engineering.highpriest.HighPriest;
import sun.security.krb5.SCDynamicStoreConfig;

import java.util.*;

public class BreakerOfChain implements Game {
    @Override
    public void play() {
        System.out.println(StringConstants.GREETING);
        System.out.println(StringConstants.OUTPUT+StringConstants.NONE);
        System.out.println(StringConstants.ALLIES);
        System.out.println(StringConstants.OUTPUT+StringConstants.NONE);
        System.out.println(StringConstants.ENTER_COMPETING_KINGDOMS);
        System.out.print(StringConstants.INPUT);

        Scanner scanner = new Scanner(System.in);
        String campaigningKingdoms = scanner.nextLine();

        System.out.println("Results after round one ballot count");

        BallotSystem ballotSystem = new DefaultBallotSystem();
        ballotSystem.registerCampainingKingdoms(Arrays.asList(campaigningKingdoms.split(" ")));
        ballotSystem.casteVote();
        HighPriest defaultHighPriest = new DefaultHighPriest();
        defaultHighPriest.luckyDrawMessages(((DefaultBallotSystem) ballotSystem).getBallot());
        defaultHighPriest.distributeMessagesToOwners(((DefaultHighPriest) defaultHighPriest).getLuckyMessages());
        TreeMap<String, List<String>> result = (TreeMap)((DefaultHighPriest) defaultHighPriest).getResult();//ToDo what about kingdoms who did not got any vote; it has to beprinted with a 0

        for (Map.Entry<String, List<String>> entry : result.entrySet()){
            System.out.println(StringConstants.OUTPUT
                    +StringConstants.ALLY+entry.getKey()+": "+entry.getValue().size());
        }

        String ruler = result.descendingMap().firstKey();
        System.out.println(StringConstants.QUESTION);
        System.out.println(StringConstants.OUTPUT+ruler);
        System.out.println(StringConstants.ALLIES);
        System.out.println(StringConstants.OUTPUT+result.get(ruler));
    }
}
