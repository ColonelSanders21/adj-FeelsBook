package ca.ualberta.cs.adj_feelsbook;

public class JoyRecord extends EmotionRecord {

    JoyRecord(){
        super();
    }

    @Override
    public String toString(){
        //Returns string that looks like 😊 | YYYY-MM-DDTHH:MM:SS
        return "\uD83D\uDE0A | " + this.isoFormat.format(this.date);
    }
}
