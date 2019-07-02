package de.ayley.goldenlobby.util;

import java.util.ArrayList;

public class ArrayLists {

    private static ArrayList<String> build = new ArrayList<>();
    private static ArrayList<String> vanish = new ArrayList<>();
    private static ArrayList<String> lobby1 = new ArrayList<>();
    private static ArrayList<String> lobby2 = new ArrayList<>();
    private static ArrayList<String> lobby3 = new ArrayList<>();
    private static ArrayList<String> lobby4 = new ArrayList<>();
    private static ArrayList<String> lobby5 = new ArrayList<>();
    private static ArrayList<String> SeeVIPPremium = new ArrayList<>();
    private static ArrayList<String> NoVanish = new ArrayList<>();


    public static ArrayList<String> getNoVanish() {
        return NoVanish;
    }

    public static ArrayList<String> getSeeVIPPremium() {
        return SeeVIPPremium;
    }

    public static ArrayList<String> getLobby2() {
        return lobby2;
    }

    public static ArrayList<String> getLobby3() {
        return lobby3;
    }

    public static ArrayList<String> getLobby4() {
        return lobby4;
    }

    public static ArrayList<String> getLobby5() {
        return lobby5;
    }


    public static ArrayList<String> getLobby1() {
        return lobby1;
    }

    public static ArrayList<String> getBuild() {
        return build;
    }

    public static ArrayList<String> getVanish() {
        return vanish;
    }
}
