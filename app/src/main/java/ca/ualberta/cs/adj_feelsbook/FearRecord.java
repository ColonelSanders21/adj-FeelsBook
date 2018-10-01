package ca.ualberta.cs.adj_feelsbook;

public class FearRecord extends EmotionRecord {
    protected String emoji;
    FearRecord(){

        super();
        emoji = "\uD83D\uDE20";
    }

    @Override
    public String toString(){
        //Returns string that looks like 😠 | YYYY-MM-DDTHH:MM:SS
        return "\uD83D\uDE28 | " + this.isoFormat.format(this.date);
    }

    public String getEmoji() {
        return emoji;
    }
}
