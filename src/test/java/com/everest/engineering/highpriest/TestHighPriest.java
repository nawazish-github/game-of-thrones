package com.everest.engineering.highpriest;

import com.everest.engineering.ballot.AbstractBallotSystem;
import com.everest.engineering.message.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestHighPriest {
    private class AbstractBallotSystemTestDouble extends AbstractBallotSystem {}
    private class AbstractHighPriestTestDouble extends AbstractHighPriest{}
    private AbstractBallotSystem abstractBallotSystem = new AbstractBallotSystemTestDouble();
    private List<String> campaigningKingdoms = Arrays.asList("ICE", "LAND");

    @Test
    public void testluckyDrawMessages(){
        abstractBallotSystem.registerCampainingKingdoms(campaigningKingdoms);
        abstractBallotSystem.casteVote();
        List<Message> ballot = abstractBallotSystem.getBallot();
        AbstractHighPriestTestDouble highPriestTestDouble = new AbstractHighPriestTestDouble();
        highPriestTestDouble.luckyDrawMessages(ballot);
        int actual = highPriestTestDouble.getLuckyMessages().size();
        Assertions.assertEquals(6, actual);
    }
}
