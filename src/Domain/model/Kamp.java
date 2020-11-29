package Domain.model;

public class Kamp {
    private String plaats;
    private String thema;
    private int score;
    private String jaar;

    public Kamp(){}

    public Kamp(String plaats, String thema, int score, String jaar){
        this.setJaar(jaar);
        this.setPlaats(plaats);
        this.setThema(thema);
        this.setScore(score);
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

    public void setPlaats(String plaats) {
        if (plaats.isEmpty()) throw new DomainException("Vul een plaats in.");
        this.plaats = plaats;
    }

    public void setThema(String thema) {
        if (thema.isEmpty()) throw new DomainException("Vul een kampthema in.");
        this.thema = thema;
    }

    public void setScore(int score) {
        if (score < 0 || score > 10) throw new DomainException("Vul een score in.");
        this.score = score;
    }

    public void setJaar(String jaar) {
        if (jaar.isEmpty()) throw new DomainException("Vul een jaar in.");
        this.jaar = jaar;
    }
}