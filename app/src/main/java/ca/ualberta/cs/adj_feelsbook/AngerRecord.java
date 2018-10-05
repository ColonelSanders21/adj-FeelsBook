package ca.ualberta.cs.adj_feelsbook;

//Record of anger
public class AngerRecord extends EmotionRecord {
    private String emoji;

    AngerRecord() {

        super();
        emoji = "\uD83D\uDE20"; // 😠
    }

    @Override
    public String toString() {
        //Returns string that looks like 😠 | YYYY-MM-DDTHH:MM:SS
        return this.emoji + " Anger | " + this.isoFormat.format(this.date) + "\n" + this.comment;
    }

    public String getEmoji() {
        return this.emoji;
    }
}
