package com.everest.engineering.factory.universe;

import com.everest.engineering.constants.StringConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniverseFactory {
    private static Universe universe;
    public static Universe getInstance(){
        synchronized (UniverseFactory.class) {
            if (universe == null)
                universe = new Universe("Southeros");
        }
        return universe; //no synchronization required as its read-only op.
    }

    public static List<String> getAllKingdoms(){
        List<String> list = new ArrayList<>();
        list.add(StringConstants.ICE);
        list.add(StringConstants.SPACE);
        list.add(StringConstants.WATER);
        list.add(StringConstants.AIR);
        list.add(StringConstants.FIRE);
        list.add(StringConstants.LAND);
        return list;
    }
}

