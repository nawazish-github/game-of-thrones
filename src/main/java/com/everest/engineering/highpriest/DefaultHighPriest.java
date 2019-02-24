package com.everest.engineering.highpriest;

import com.everest.engineering.message.AbstractMessage;

import java.util.ArrayList;
import java.util.List;

public class DefaultHighPriest extends AbstractHighPriest {
    @Override
    public void luckyDrawMessages(List<AbstractMessage> ballot) {
        int votesCount = ballot.size();
        List<AbstractMessage> list = new ArrayList<>();
        for (int i = 0; i < 6 ; i++){
            int rand = (int)Math.random()%votesCount;
            list.add(ballot.get(rand));
        }
        super.luckyAbstractMessages = list;
    }
}
