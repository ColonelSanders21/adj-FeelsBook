package ca.ualberta.cs.adj_feelsbook;

public class AngerRecord extends EmotionRecord {
    protected String emoji;
    AngerRecord(){

        super();
        emoji = "\uD83D\uDE20";
    }

    @Override
    public String toString(){
        //Returns string that looks like 😠 | YYYY-MM-DDTHH:MM:SS
        return "\uD83D\uDE20 | " + this.isoFormat.format(this.date);
    }
    public String getEmoji(){
        return this.emoji;
    }
}
