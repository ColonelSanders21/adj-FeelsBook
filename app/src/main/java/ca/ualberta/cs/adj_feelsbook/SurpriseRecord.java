package ca.ualberta.cs.adj_feelsbook;

public class SurpriseRecord extends EmotionRecord {

    SurpriseRecord(){
        super();
    }

    @Override
    public String toString(){
        //Returns string that looks like 😮 | YYYY-MM-DDTHH:MM:SS
        return "\uD83D\uDE2E | " + this.isoFormat.format(this.date);
    }
}
