package ca.ualberta.cs.adj_feelsbook;

public class SurpriseRecord extends EmotionRecord {
    protected String emoji;
    SurpriseRecord(){

        super();
        emoji = "\uD83D\uDE2E";
    }

    @Override
    public String toString(){
        //Returns string that looks like 😮 | YYYY-MM-DDTHH:MM:SS
        return "\uD83D\uDE2E | " + this.isoFormat.format(this.date);
    }

    public String getEmoji(){
        return this.emoji;
    }
}
