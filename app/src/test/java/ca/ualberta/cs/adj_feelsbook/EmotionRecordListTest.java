package ca.ualberta.cs.adj_feelsbook;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;


public class EmotionRecordListTest {
    @Test
    public void addRemoveRecordTest(){
        EmotionRecordList recordList = new EmotionRecordList();
        LoveRecord love1 = new LoveRecord();
        recordList.addRecord(love1);
        assertTrue(recordList.getRecord(0) == love1);
        assertTrue(recordList.getLoveCount() == 1);
        assertTrue(recordList.getAngerCount() == 0);

        recordList.removeRecord(love1);
        assertTrue(recordList.getLoveCount() == 0);
        assertTrue(recordList.getSize() == 0);
        assertFalse(recordList.containsRecord(love1));

    }
    @Test
    public void sortRecordsTest(){
        EmotionRecordList recordList = new EmotionRecordList();
        LoveRecord love1 = new LoveRecord();
        LoveRecord love2 = new LoveRecord();
        recordList.addRecord(love1);
        recordList.addRecord(love2);
        recordList.sortRecords();
        assertTrue(recordList.getRecord(0) == love1);

        Date oldDate = love1.getDate();

        //Specifying a certain date has been deprecated, using only to test sorting method
        Date newDate = new Date(2021, 2, 2);
        love1.setDate(newDate);
        assertTrue(love1.getDate().equals(newDate));
        assertTrue(oldDate.before(newDate));
        recordList.sortRecords();
        assertTrue(recordList.getRecord(0) == love2);
        AngerRecord angry1 = new AngerRecord();
        recordList.addRecord(angry1);
        assertTrue(recordList.getRecord(1) == angry1);
        recordList.removeRecord(love2);
        assertTrue(recordList.getRecord(1) == love1);

    }
}
