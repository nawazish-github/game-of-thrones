package com.everest.engineering.factory.kingdom;

import com.everest.engineering.kingdom.AbstractKingdom;
import com.everest.engineering.kingdom.Emblem;
import com.everest.engineering.kingdom.Kingdom;

public class KingdomFactory {

    private static AbstractKingdom spaceKingdom;
    private static AbstractKingdom landKingdom;
    private static AbstractKingdom waterKingdom;
    private static AbstractKingdom iceKingdom;
    private static AbstractKingdom airKingdom;
    private static AbstractKingdom fireKingdom;

    public static AbstractKingdom getInstance(String kingdomName){
        synchronized (KingdomFactory.class){
            switch(kingdomName){
                case "SPACE":
                    if (spaceKingdom == null)
                        spaceKingdom = new AbstractKingdom("SPACE", new Emblem("Gorilla"));
                    return spaceKingdom;
                case "LAND":
                    if (landKingdom == null)
                        landKingdom = new AbstractKingdom("LAND", new Emblem("Panda"));
                    return landKingdom;
                case "WATER":
                    if (waterKingdom == null)
                        waterKingdom = new AbstractKingdom("WATER", new Emblem("Octopus"));
                    return waterKingdom;
                case "ICE":
                    if (iceKingdom == null)
                        iceKingdom = new AbstractKingdom("ICE", new Emblem("Mammoth"));
                    return iceKingdom;
                case "AIR":
                    if (airKingdom == null)
                         airKingdom = new AbstractKingdom("AIR", new Emblem("Owl"));
                    return airKingdom;
                case "FIRE":
                    if (fireKingdom == null)
                        fireKingdom = new AbstractKingdom("FIRE", new Emblem("Dragon"));
                    return fireKingdom;
                default:
                    throw new IllegalArgumentException("Invalid Kingdom name: "+kingdomName);
            }
        }
    }

    public static void resetKingdoms(){
        spaceKingdom = null;
        landKingdom = null;
        waterKingdom = null;
        iceKingdom = null;
        airKingdom = null;
        fireKingdom = null;
    }
}
