package Domain.model;

public class Kamp {
    private String plaats;
    private String thema;
    private int score;
    private String jaar;

    public Kamp(){}

    public Kamp(String plaats, String thema, int score, String jaar){
        this.plaats = plaats;
        this.thema = thema;
        this.score = score;
        this.jaar = jaar;
    }

    public String getPlaats() {
        return plaats;
    }

    public String getThema() {
        return thema;
    }

    public String getJaar() {
        return jaar;
    }

    public int getScore() {
        return score;
    }
}