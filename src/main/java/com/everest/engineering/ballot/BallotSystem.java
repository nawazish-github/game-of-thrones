package com.everest.engineering.ballot;

import java.util.List;

public interface BallotSystem {
    public abstract void registerCampainingKingdoms(List<String> campainingKingdoms);
    public abstract void casteVote() throws IllegalArgumentException;
}
