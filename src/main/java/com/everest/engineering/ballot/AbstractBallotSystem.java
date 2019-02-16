package com.everest.engineering.ballot;

import com.everest.engineering.factory.kingdom.KingdomFactory;
import com.everest.engineering.factory.universe.UniverseFactory;
import com.everest.engineering.message.Message;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBallotSystem implements BallotSystem {
    private List<String> campainingKingdoms;
    private List<Message> ballot = new ArrayList<>();
    private AbstractBallotSystem abstractBallotSystem;

    @Override
    public void registerCampainingKingdoms(List<String> campainingKingdoms) {
        this.campainingKingdoms = campainingKingdoms;
    }

    @Override
    public void casteVote() throws IllegalArgumentException {
        List<String> kingdoms = UniverseFactory.getAllKingdoms();
        for(String campaigner : this.campainingKingdoms){
            for (String kingdom : kingdoms){
                if (!campaigner.equals(kingdom)) //Because campaigne shouldn't send message to its own kingdowm
                    ballot.add(new Message(KingdomFactory.getInstance(campaigner.toUpperCase()),
                                            KingdomFactory.getInstance(kingdom.toUpperCase())));
            }
        }
    }

    public List<Message> getBallot() {
        return ballot;
    }

    public List<String> getCampainingKingdoms() {
        return campainingKingdoms;
    }

}
