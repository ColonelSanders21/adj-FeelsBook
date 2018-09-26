package ca.ualberta.cs.adj_feelsbook;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmotionRecordTest {

    @Test
    public void getTimestampTest() {
        EmotionRecord record = new EmotionRecord("2018-09-01T18:30:00", "joy");
        String timestamp = record.getTimestamp();
        assertTrue("Timestamps are not equal",timestamp.equals("2018-09-01T18:30:00"));

    }

    @Test
    public void getEmotionTest() {
        EmotionRecord record = new EmotionRecord("2018-09-01T18:30:00", "joy");
        String emotion = record.getEmotion();
        assertTrue("Emotions are not equal", emotion.equals("joy"));
    }

    @Test
    public void getCommentTest() {
        //Part 1: Constructor with no comment
        EmotionRecord record1 = new EmotionRecord("2018-09-01T18:30:00", "joy");
        String comment = record1.getComment();
        assertTrue("Comment is not blank", comment.equals(""));

        //Part 2: Constructor with a comment
        EmotionRecord record2 = new EmotionRecord("2018-09-01T18:30:00", "joy", "This is a test comment");
        comment  = record2.getComment();
        assertTrue("Comments are not equal", comment.equals("This is a test comment"));
    }

    @Test
    public void setTimestampTest() {
        EmotionRecord record = new EmotionRecord("2018-09-01T18:30:00", "joy");
        String old_timestamp = record.getTimestamp();
        String new_timestamp = "2018-09-01T20:30:00";
        record.setTimestamp(new_timestamp);
        assertTrue("Timestamp did not change", !old_timestamp.equals(record.getTimestamp()));
    }

    @Test
    public void setEmotionTest() {
    }

    @Test
    public void setCommentTest() {
    }
}