package ca.ualberta.cs.adj_feelsbook;

//Record of joy
public class JoyRecord extends EmotionRecord {
    protected String emoji;
    JoyRecord(){

        super();
        emoji = "\uD83D\uDE0A"; //😊
    }

    @Override
    public String toString(){
        //Returns string that looks like 😊 | YYYY-MM-DDTHH:MM:SS
        return this.emoji + " Joy | " +this.isoFormat.format(this.date)+ "\n" +this.comment;
    }

    public String getEmoji(){
        return this.emoji;
    }
}
