package Domain.db;

import Domain.model.DomainException;
import Domain.model.Kamp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class KampDb {
    Kamp kamp2010 = new Kamp("Dessel","De oude Grieken", 7,"2010");
    Kamp kamp2011 = new Kamp("Opoeteren", "Robin Hood", 8, "2011");
    Kamp kamp2012 = new Kamp("Gouvy","Asterix & Obelix", 6,"2012");
    Kamp kamp2013 = new Kamp("Lille","Kuifje",7,"2013");
    Kamp kamp2014 = new Kamp("Sankt-Vith","Lucky Luke",8,"2014");

    public ArrayList<Kamp> kampen = new ArrayList<>(Arrays.asList(kamp2010, kamp2011, kamp2012, kamp2013, kamp2014));

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
    public boolean voegToe(Kamp nieuwKamp){
        for (Kamp kamp:kampen){
            if (nieuwKamp.getJaar().equals(kamp.getJaar())){
                return false;
            }
        }
        kampen.add(nieuwKamp);
        return true;
    }

    public Kamp vindKamp(String jaar){
        if (jaar.isEmpty()) throw new DomainException("Vul een jaar in.");
        for (Kamp kamp : kampen){
            if(kamp.getJaar().equals(jaar)){
                return kamp;
            }
        }
        return null;
    }

    public void verwijderKamp(Kamp kamp){
        kampen.remove(kamp);
    }
}
