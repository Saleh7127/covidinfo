package sample;

import java.util.ArrayList;

public class scrap {
    private static ArrayList<String> hold;

    public static void setData(ArrayList<String> hold) {
        scrap.hold = hold;
    }
    public static String getData(int n) {
        return (scrap.hold.get(n));
    }
}
