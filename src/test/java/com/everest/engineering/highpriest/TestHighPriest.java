package com.everest.engineering.highpriest;

import com.everest.engineering.ballot.AbstractBallotSystem;
import com.everest.engineering.constants.StringConstants;
import com.everest.engineering.factory.kingdom.KingdomFactory;
import com.everest.engineering.factory.universe.UniverseFactory;
import com.everest.engineering.kingdom.AbstractKingdom;
import com.everest.engineering.message.AbstractMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TestHighPriest {//ToDo: Setup a @BeforeEach method

    private AbstractBallotSystem abstractBallotSystem;
    //private Set<String> campaigningKingdoms =  new HashSet<>();
    private DefaultHighPriest highPriestTestDouble;

    @Test
    public void testluckyDrawMessages(){
        Set<String> campaigningKingdoms =  new HashSet<>();
        campaigningKingdoms.add("ICE");
        campaigningKingdoms.add("LAND");
        abstractBallotSystem = new AbstractBallotSystemTestDouble();
        highPriestTestDouble = new DefaultHighPriest();
        abstractBallotSystem.registerCampainingKingdoms(campaigningKingdoms);
        abstractBallotSystem.casteVote();
        List<AbstractMessage> ballot = abstractBallotSystem.getBallot();
        highPriestTestDouble.luckyDrawMessages(ballot);
        int actual = highPriestTestDouble.getLuckyMessages().size();
        Assertions.assertEquals(6, actual);
    }

    @Test
    public void testDistributeMessagesToOwners(){
        Set<String> campaigningKingdoms =  new LinkedHashSet<>();
        campaigningKingdoms.add("ICE");
        campaigningKingdoms.add("LAND");
        abstractBallotSystem = new AbstractBallotSystemTestDouble();
        highPriestTestDouble = new DefaultHighPriest();
        abstractBallotSystem.registerCampainingKingdoms(campaigningKingdoms);
        abstractBallotSystem.casteVote();
        highPriestTestDouble.distributeMessagesToOwners(abstractBallotSystem.getBallot());
        Map<String, List<String>> actual = highPriestTestDouble.getResult();

        List<String> kingdoms = UniverseFactory.getAllKingdoms();
        Map<String, List<String>> expected = new HashMap<>();
        List<String> alliesOfIce = Arrays.asList(StringConstants.SPACE, StringConstants.WATER, StringConstants.AIR,
                                                StringConstants.FIRE);
        expected.put(StringConstants.ICE, alliesOfIce);
        expected.put(StringConstants.LAND, Collections.emptyList());
        System.out.println(actual.get(StringConstants.ICE));
        Assertions.assertIterableEquals(expected.get(StringConstants.ICE), actual.get(StringConstants.ICE));
        Assertions.assertIterableEquals(expected.get(StringConstants.LAND),
                actual.getOrDefault(StringConstants.LAND, Collections.emptyList()));

    }
}

class TestMessage extends AbstractMessage{

    public TestMessage(AbstractKingdom sendor, AbstractKingdom receiver) {
        super(sendor, receiver);
    }

    @Override
    protected String getRandomMessage() {
        switch(super.getReceiver().getName()){
            case "SPACE":
                return "gorilla";
            case "LAND":
                return "PandA23232";
            case "WATER":
                return "Oc77t0opus";
            case "ICE":
                return "Mammoth";
            case "AIR":
                return "O9999WL";
            case "FIRE":
                return "drag on with it __";
            default:
                throw new IllegalArgumentException("Invalid Kingdom name: "+super.getReceiver().getName());
        }
    }
}

class AbstractBallotSystemTestDouble extends AbstractBallotSystem {
    @Override
    public void casteVote() throws IllegalArgumentException {
        List<String> kingdoms = UniverseFactory.getAllKingdoms();
        for(String campaigner : super.campainingKingdoms){
            for (String kingdom : kingdoms){
                if (!this.campainingKingdoms.contains(kingdom)) //Because campaigner shouldn't send message to its own kingdom
                    super.ballot.add(new TestMessage(KingdomFactory.getInstance(campaigner.toUpperCase()),
                            KingdomFactory.getInstance(kingdom.toUpperCase())));
            }
        }
    }
}
