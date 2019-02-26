package com.everest.engineering.highpriest;

import com.everest.engineering.message.AbstractMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DefaultHighPriest extends AbstractHighPriest {
    @Override
    public void luckyDrawMessages(List<AbstractMessage> ballot) {
        Random random = new Random();
        int votesCount = ballot.size();
        List<AbstractMessage> list = new ArrayList<>();
        for (int i = 0; i < 6 && votesCount > 0 ; i++){
            int r = random.nextInt();
            int rand = (int)r%votesCount;
            --votesCount; //the chosen vote should not be again chosen.
            list.add(ballot.remove(Math.abs(rand)));
        }
        super.luckyAbstractMessages = list;
    }
}
