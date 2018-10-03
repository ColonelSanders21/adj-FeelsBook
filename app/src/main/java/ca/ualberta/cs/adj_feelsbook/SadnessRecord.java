package ca.ualberta.cs.adj_feelsbook;

public class SadnessRecord extends EmotionRecord {
    protected String emoji;
    SadnessRecord(){
        super();
        emoji = "\uD83D\uDE22";
    }

    @Override
    public String toString(){
        //Returns string that looks like 😢 | YYYY-MM-DDTHH:MM:SS
        return this.emoji + " Sadness | " +this.isoFormat.format(this.date)+ "\n" +this.comment;
    }

    public String getEmoji(){
        return this.emoji;
    }
}
