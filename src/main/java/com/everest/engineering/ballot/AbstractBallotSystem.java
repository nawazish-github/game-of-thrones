package com.everest.engineering.ballot;

import com.everest.engineering.factory.kingdom.KingdomFactory;
import com.everest.engineering.factory.universe.UniverseFactory;
import com.everest.engineering.message.AbstractMessage;
import com.everest.engineering.message.DefaultMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Todo: There should be a DefaultBallotSystem and casteVote as abstract
public abstract class AbstractBallotSystem implements BallotSystem {
    protected List<String> campainingKingdoms;
    protected List<AbstractMessage> ballot = new ArrayList<>();
    private AbstractBallotSystem abstractBallotSystem;
    private List<String> input;

    @Override
    public void registerCampainingKingdoms(List<String> campainingKingdoms) {
        this.input = campainingKingdoms;
        this.campainingKingdoms = campainingKingdoms.stream()
                                                    .map(kingdom ->kingdom.toUpperCase())
                                                    .collect(Collectors.toList());
    }
    @Override
    public abstract void casteVote() throws IllegalArgumentException;
    public List<AbstractMessage> getBallot() {
        return ballot;
    }
    public List<String> getCampainingKingdoms() {
        return campainingKingdoms;
    }
}
