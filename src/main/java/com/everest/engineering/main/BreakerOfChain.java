package com.everest.engineering.main;

import com.everest.engineering.ballot.BallotSystem;
import com.everest.engineering.ballot.DefaultBallotSystem;
import com.everest.engineering.constants.StringConstants;
import com.everest.engineering.factory.kingdom.KingdomFactory;
import com.everest.engineering.highpriest.DefaultHighPriest;
import com.everest.engineering.highpriest.HighPriest;

import java.util.*;

public class BreakerOfChain implements Game {
    @Override
    public void play() {
        while(true){
            System.out.println();
            System.out.println(StringConstants.GREETING);
            System.out.println(StringConstants.OUTPUT+StringConstants.NONE);
            System.out.println(StringConstants.ALLIES);
            System.out.println(StringConstants.OUTPUT+StringConstants.NONE);
            System.out.println(StringConstants.ENTER_COMPETING_KINGDOMS);
            System.out.print(StringConstants.INPUT);

            Scanner scanner = new Scanner(System.in);
            String cmpKingdomLine = scanner.nextLine();
            Set<String> campaigningKingdoms = new HashSet<>();
            StringTokenizer tokenizer = new StringTokenizer(cmpKingdomLine, " ");
            while (tokenizer.hasMoreElements()) {
                campaigningKingdoms.add(tokenizer.nextToken());
            }
            int rndCnt = 1;
            while(true){
                KingdomFactory.resetKingdoms();
                System.out.printf("Results after round %d ballot count \n", rndCnt++);
                BallotSystem ballotSystem = new DefaultBallotSystem();
                ballotSystem.registerCampainingKingdoms(campaigningKingdoms);
                ballotSystem.casteVote();
                HighPriest defaultHighPriest = new DefaultHighPriest();
                defaultHighPriest.luckyDrawMessages(((DefaultBallotSystem) ballotSystem).getBallot());
                defaultHighPriest.distributeMessagesToOwners(((DefaultHighPriest) defaultHighPriest).getLuckyMessages());
                TreeMap<String, List<String>> result = (TreeMap)((DefaultHighPriest) defaultHighPriest).getResult();
                System.out.println(result);
                for (Map.Entry<String, List<String>> entry : result.entrySet()){
                    System.out.println(StringConstants.OUTPUT
                            +StringConstants.ALLY+entry.getKey()+": "+entry.getValue().size());
                }
                Set<String> tiedKingdoms = checkForTies(result.entrySet());
                campaigningKingdoms = tiedKingdoms;
                if (result.entrySet().size()>0 && tiedKingdoms.size()==0){
                    String ruler = result.descendingMap().firstKey();
                    System.out.println(StringConstants.QUESTION);
                    System.out.println(StringConstants.OUTPUT+ruler);
                    System.out.println(StringConstants.ALLIES);
                    System.out.println(StringConstants.OUTPUT+result.get(ruler));
                    break;
                }
                if (result.entrySet().size() == 0)
                    break;
            }
        }
    }

    private Set<String> checkForTies(Set<Map.Entry<String, List<String>>> entrySet) {
        Set<String> kingdomsTied = new HashSet<>();
        Set<Integer> freqTie = new HashSet<>();
        for (Map.Entry<String, List<String>> entry : entrySet){
            if (!freqTie.add(entry.getValue().size())){
                kingdomsTied.add(entry.getKey());
            }
        }
        return kingdomsTied;
    }
}
