package com.everest.engineering.highpriest;

import com.everest.engineering.ballot.AbstractBallotSystem;
import com.everest.engineering.ballot.DefaultBallotSystem;
import com.everest.engineering.dispatch.HighPriestMessageDispatcher;
import com.everest.engineering.dispatch.MessageDispatcher;
import com.everest.engineering.message.Message;

import java.util.*;
import java.util.stream.Collectors;

public class AbstractHighPriest implements HighPriest{
    private List<Message> luckyMessages = new ArrayList<>();
    private String emperor;

    @Override
    public void luckyDrawMessages(List<Message> ballot) {
        //AbstractBallotSystem abstractBallotSystem = DefaultBallotSystem.getInstance();
        //List<Message> ballot = abstractBallotSystem.getBallot();
        int votesCount = ballot.size();
        List<Message> list = new ArrayList<>();
        for (int i = 0; i < 6 ; i++){
            int rand = (int)Math.random()%votesCount;
            list.add(ballot.get(rand));
        }
        this.luckyMessages = list;
    }

    @Override
    public void distributeMessagesToOwners(List<Message> messages) {
        MessageDispatcher dispatcher = new HighPriestMessageDispatcher();
        Map<String, List<String>> result =  dispatcher.dispatch(messages);
    }

    @Override
    public String declareRuler(Map<String, List<String>> polls) {
        TreeMap<String, List<String>> map = new TreeMap<>(polls);
        emperor = map.lastEntry().getKey();
        return map.lastEntry().getKey();
    }

    public List<Message> getLuckyMessages() {
        return luckyMessages;
    }

    public String getEmperor() {
        return emperor;
    }
}
