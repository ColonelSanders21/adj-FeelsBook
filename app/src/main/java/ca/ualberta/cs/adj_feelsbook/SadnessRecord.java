package ca.ualberta.cs.adj_feelsbook;

public class SadnessRecord extends EmotionRecord {

    SadnessRecord(){
        super();
    }

    @Override
    public String toString(){
        //Returns string that looks like 😢 | YYYY-MM-DDTHH:MM:SS
        return "\uD83D\uDE22 | " + this.isoFormat.format(this.date);
    }
}
