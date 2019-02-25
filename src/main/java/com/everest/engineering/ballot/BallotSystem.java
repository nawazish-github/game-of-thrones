package com.everest.engineering.ballot;

import java.util.Set;

public interface BallotSystem {
    public abstract void registerCampainingKingdoms(Set<String> campainingKingdoms);
    public abstract void casteVote() throws IllegalArgumentException;
}
