package ca.ualberta.cs.adj_feelsbook;

//Record of surprise
public class SurpriseRecord extends EmotionRecord {
    protected String emoji;
    SurpriseRecord(){

        super();
        emoji = "\uD83D\uDE2E"; //😮
    }

    @Override
    public String toString(){
        //Returns string that looks like 😮 | YYYY-MM-DDTHH:MM:SS
        return this.emoji + " Surprise | " +this.isoFormat.format(this.date)+ "\n" +this.comment;
    }

    public String getEmoji(){
        return this.emoji;
    }
}
