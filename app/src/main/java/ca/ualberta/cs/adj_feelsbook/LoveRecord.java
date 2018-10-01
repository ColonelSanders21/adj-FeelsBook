package ca.ualberta.cs.adj_feelsbook;


public class LoveRecord extends EmotionRecord {
    protected String emoji;
    LoveRecord(){
        super();
        emoji = "😍";
    }

    @Override
    public String toString(){
        //Returns string that looks like 😍 | YYYY-MM-DDTHH:MM:SS
        return "\uD83D\uDE0D | " +this.isoFormat.format(this.date);
    }
    public String getEmoji(){
        return this.emoji;
    }
}
