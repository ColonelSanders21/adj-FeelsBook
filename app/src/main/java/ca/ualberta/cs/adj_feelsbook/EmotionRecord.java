package ca.ualberta.cs.adj_feelsbook;

import java.util.List;

public class EmotionRecord {
    //An instance of this class represents an emotion recorded with a timestamp and optional comment
    protected String timestamp;
    protected String comment;

    //May remove this -- could split into emotion subclasses?
    protected String emotion;


    //Constructor for no comment.
    EmotionRecord(String timestamp, String emotion){
        this.timestamp = timestamp;
        this.emotion = emotion;
        this.comment = "";
    }

    //Constructor with added comment
    EmotionRecord(String timestamp, String emotion, String comment){
        this.timestamp = timestamp;
        this.emotion = emotion;
        this.comment = comment;
    }

    //Getter method section
    public String getTimestamp(){
        return this.timestamp;
    }

    public String getEmotion(){
        return this.emotion;
    }

    public String getComment(){
        return this.comment;
    }

    //Setter method section
    public void setTimestamp(String timestamp){
        this.timestamp = timestamp;
        //Add exception for if not proper format
    }

    public void setEmotion(String emotion){
        this.emotion = emotion;
        //Add exception for unexpected emotions
        //Implemented, but not required for assignment -- may remove later
    }

    public void setComment(String comment){
        this.comment = comment;
        //Add exception for length being >100 chars
    }

}
