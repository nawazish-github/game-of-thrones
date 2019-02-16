package com.everest.engineering.ballot;

public class DefaultBallotSystem extends AbstractBallotSystem{
    private static DefaultBallotSystem defaultBallotSystem;
    public static synchronized AbstractBallotSystem getInstance() {
        if (defaultBallotSystem == null){
            defaultBallotSystem = new DefaultBallotSystem();
            return defaultBallotSystem;
        }
        return defaultBallotSystem;
    }
}
