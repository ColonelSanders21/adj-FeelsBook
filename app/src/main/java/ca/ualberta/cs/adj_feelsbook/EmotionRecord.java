package ca.ualberta.cs.adj_feelsbook;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//Abstract class for all emotion records
public abstract class EmotionRecord implements Comparable<EmotionRecord> {

    protected Date date;
    protected String comment;
    protected DateFormat isoFormat = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss");

    EmotionRecord() {
        //No arguments required for constructor -- comment can be set by user after instantiation
        this.date = new Date();
        this.comment = "";
    }

    //setters
    public void setDate(Date date) {
        this.date = date;
    }

    public void setComment(String comment) throws CommentTooLongException {
        if (comment.length() < 100) {
            this.comment = comment;
        } else {
            throw new CommentTooLongException();
        }
    }

    //getters
    public Date getDate() {
        return this.date;
    }

    public String getComment() {
        return this.comment;
    }

    //EmotionRecord itself has no emoji, but ensures all subclasses have way of accessing it
    public abstract String getEmoji();

    @Override
    //Ensures all other extensions of EmotionRecord have a way of expressing as string properly
    public abstract String toString();


    // Credit to Paul Samsotha and ivan_pozdeev on StackOverflow for how to implement a comparable
    // interface -- https://stackoverflow.com/a/19683102
    @Override
    public int compareTo(EmotionRecord a) {
        if (this.date.after(a.getDate())) {
            return 1;
        } else if (this.date.equals(a.getDate())) {
            return 0;
        } else {
            return -1;
        }
    }

}
