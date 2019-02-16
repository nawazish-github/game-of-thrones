package com.everest.engineering.ballot;

import com.everest.engineering.message.Message;

import java.util.List;

public interface BallotSystem {
    public abstract void registerCampainingKingdoms(List<String> campainingKingdoms);
    public abstract void casteVote() throws IllegalArgumentException;
}
