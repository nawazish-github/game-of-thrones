package com.everest.engineering.ballot;

import com.everest.engineering.factory.kingdom.KingdomFactory;
import com.everest.engineering.factory.universe.UniverseFactory;
import com.everest.engineering.message.DefaultMessage;

import java.util.List;

public class DefaultBallotSystem extends AbstractBallotSystem{
    private static DefaultBallotSystem defaultBallotSystem;
    public static synchronized AbstractBallotSystem getInstance() {
        if (defaultBallotSystem == null){
            defaultBallotSystem = new DefaultBallotSystem();
            return defaultBallotSystem;
        }
        return defaultBallotSystem;
    }
    @Override
    public void casteVote() throws IllegalArgumentException {
        List<String> kingdoms = UniverseFactory.getAllKingdoms();
        for(String campaigner : super.campainingKingdoms){
            for (String kingdom : kingdoms){
                if (!this.campainingKingdoms.contains(kingdom)) //Because campaigner shouldn't send message to its own kingdom
                    super.ballot.add(new DefaultMessage(KingdomFactory.getInstance(campaigner.toUpperCase()),
                                            KingdomFactory.getInstance(kingdom.toUpperCase())));
            }
        }
    }
}
