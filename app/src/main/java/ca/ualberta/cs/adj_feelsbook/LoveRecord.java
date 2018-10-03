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
        return this.emoji + " Love | " +this.isoFormat.format(this.date)+ "\n" +this.comment;
    }
    public String getEmoji(){
        return this.emoji;
    }
}
