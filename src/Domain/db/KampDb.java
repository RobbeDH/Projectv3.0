package Domain.db;

import Domain.model.Kamp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class KampDb {
    Kamp kamp2010 = new Kamp("Dessel","De oude Grieken", 7,"2010");
    Kamp kamp2011 = new Kamp("Opoeteren", "Robin Hood", 8, "2011");
    public ArrayList<Kamp> kampen = new ArrayList<>(Arrays.asList(kamp2010, kamp2011));

    public ArrayList<Kamp> getKampen(){
        return kampen;
    }

    public int getAantalKampen(){
        return kampen.size();
    }

    public int getGemiddeldeScore(){
        int som = 0;
        for (Kamp kamp : kampen){
            som += kamp.getScore();
        }
        return som/getAantalKampen();
    }
}
