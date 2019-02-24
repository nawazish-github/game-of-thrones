package com.everest.engineering.main;

import com.everest.engineering.ballot.BallotSystem;
import com.everest.engineering.ballot.DefaultBallotSystem;
import com.everest.engineering.highpriest.DefaultHighPriest;
import com.everest.engineering.highpriest.HighPriest;

import java.util.Arrays;
import java.util.Scanner;

public class BreakerOfChain implements Game {
    @Override
    public void play() {
        BallotSystem ballotSystem = new DefaultBallotSystem();
        Scanner scanner = new Scanner(System.in);
        String campaigningKingdoms = scanner.nextLine();
        ballotSystem.registerCampainingKingdoms(Arrays.asList(campaigningKingdoms.split(" ")));
        ballotSystem.casteVote();
        HighPriest defaultHighPriest = new DefaultHighPriest();
        defaultHighPriest.luckyDrawMessages(((DefaultBallotSystem) ballotSystem).getBallot());
        defaultHighPriest.distributeMessagesToOwners(((DefaultHighPriest) defaultHighPriest).getLuckyMessages());
        System.out.println(((DefaultHighPriest) defaultHighPriest).getResult());

    }
}
