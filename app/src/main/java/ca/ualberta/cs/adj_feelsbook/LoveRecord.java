package ca.ualberta.cs.adj_feelsbook;

//Record of love
public class LoveRecord extends EmotionRecord {
    protected String emoji;

    LoveRecord() {
        super();
        emoji = "\uD83D\uDE0D"; //😍
    }

    @Override
    public String toString() {
        //Returns string that looks like 😍 | YYYY-MM-DDTHH:MM:SS
        return this.emoji + " Love | " + this.isoFormat.format(this.date) + "\n" + this.comment;
    }

    public String getEmoji() {
        return this.emoji;
    }
}
