package ca.ualberta.cs.adj_feelsbook;

//Record of fear
public class FearRecord extends EmotionRecord {
    protected String emoji;

    FearRecord() {

        super();
        emoji = "\uD83D\uDE28"; //😠
    }

    @Override
    public String toString() {
        //Returns string that looks like 😠 | YYYY-MM-DDTHH:MM:SS
        return this.emoji + " Fear | " + this.isoFormat.format(this.date) + "\n" + this.comment;
    }

    public String getEmoji() {
        return emoji;
    }
}
