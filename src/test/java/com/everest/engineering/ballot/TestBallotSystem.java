package com.everest.engineering.ballot;

import com.everest.engineering.factory.kingdom.KingdomFactory;
import com.everest.engineering.factory.universe.UniverseFactory;
import com.everest.engineering.message.AbstractMessage;
import com.everest.engineering.message.DefaultMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestBallotSystem {
    @Test
    public void testRegisterCampainingKingdoms(){
        List<String> expected = Arrays.asList("ICE", "LAND");
        AbstractBallotSystem abstractBallotSystem = new DefaultBallotSystem();
        abstractBallotSystem.registerCampainingKingdoms(expected);
        List<String> actual = abstractBallotSystem.getCampainingKingdoms();
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    public void testCasteVote(){
        List<String> kingdoms = UniverseFactory.getAllKingdoms();
        List<String> campaigningKingdoms = Arrays.asList("ICE", "LAND");
        List<AbstractMessage> expectedBallot = new ArrayList<>();

        for (String campainingKingdom : campaigningKingdoms){
            for (String kingdom : kingdoms){
                if (!campaigningKingdoms.contains(kingdom)) //Because campaign shouldn't send message to its own kingdom
                    expectedBallot.add(
                            new DefaultMessage(KingdomFactory.getInstance(campainingKingdom),
                                    KingdomFactory.getInstance(kingdom.toUpperCase()))
                    );
            }
        }
        AbstractBallotSystem abstractBallotSystem = new DefaultBallotSystem();
        abstractBallotSystem.registerCampainingKingdoms(campaigningKingdoms);
        abstractBallotSystem.casteVote();
        List<AbstractMessage> actual = abstractBallotSystem.getBallot();

        if (expectedBallot.size()!=actual.size())
            Assertions.assertFalse(true, "Ballot size failure");

        int size = expectedBallot.size()-1;
        while(size >= 0){
            if(!expectedBallot.get(size).getSendor().getName().equals(actual.get(size).getReceiver().getName()))
                Assertions.assertFalse(false,"Ballots differ: "+expectedBallot.get(size).getSendor()
                +" and "+actual.get(size).getReceiver().getName());
            --size;
        }
    }
}


