package com.everest.engineering.highpriest;

import com.everest.engineering.dispatch.HighPriestMessageDispatcher;
import com.everest.engineering.dispatch.MessageDispatcher;
import com.everest.engineering.message.AbstractMessage;

import java.util.*;

public class AbstractHighPriest implements HighPriest{
    private List<AbstractMessage> luckyAbstractMessages = new ArrayList<>();
    private String emperor;
    private Map<String, List<String>> result;

    @Override
    public void luckyDrawMessages(List<AbstractMessage> ballot) {
        //AbstractBallotSystem abstractBallotSystem = DefaultBallotSystem.getInstance();
        //List<AbstractMessage> ballot = abstractBallotSystem.getBallot();
        int votesCount = ballot.size();
        List<AbstractMessage> list = new ArrayList<>();
        for (int i = 0; i < 6 ; i++){
            int rand = (int)Math.random()%votesCount;
            list.add(ballot.get(rand));
        }
        this.luckyAbstractMessages = list;
    }

    @Override
    public void distributeMessagesToOwners(List<AbstractMessage> abstractMessages) {
        MessageDispatcher dispatcher = new HighPriestMessageDispatcher();
        this.result =  dispatcher.dispatch(abstractMessages);
    }

    @Override
    public String declareRuler(Map<String, List<String>> polls) {
        TreeMap<String, List<String>> map = new TreeMap<>(polls);
        emperor = map.lastEntry().getKey();
        return map.lastEntry().getKey();
    }

    public List<AbstractMessage> getLuckyMessages() {
        return luckyAbstractMessages;
    }

    public String getEmperor() {
        return emperor;
    }

    public Map<String, List<String>> getResult() {
        return result;
    }
}
