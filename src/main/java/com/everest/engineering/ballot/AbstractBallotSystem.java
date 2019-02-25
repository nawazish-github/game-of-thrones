package com.everest.engineering.ballot;

import com.everest.engineering.factory.kingdom.KingdomFactory;
import com.everest.engineering.factory.universe.UniverseFactory;
import com.everest.engineering.message.AbstractMessage;
import com.everest.engineering.message.DefaultMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractBallotSystem implements BallotSystem {
    protected List<String> campainingKingdoms;
    protected List<AbstractMessage> ballot = new ArrayList<>();
    private AbstractBallotSystem abstractBallotSystem;
    private Set<String> input;

    @Override
    public void registerCampainingKingdoms(Set<String> campainingKingdoms) {
        this.input = campainingKingdoms;
        this.campainingKingdoms = campainingKingdoms.stream()
                                                    .filter(kingdom -> !kingdom.isEmpty())
                                                    .map(kingdom -> kingdom.trim().toUpperCase())
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
