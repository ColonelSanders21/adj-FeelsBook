package ca.ualberta.cs.adj_feelsbook;

import java.util.ArrayList;
import java.util.Collections;

//Container for EmotionRecords
public class EmotionRecordList {
    private ArrayList<EmotionRecord> emotionRecords;

    EmotionRecordList() {
        this.emotionRecords = new ArrayList<EmotionRecord>();
    }

    //getters
    public ArrayList<EmotionRecord> getEmotionRecords() {
        return emotionRecords;
    }

    public EmotionRecord getRecord(int index) {
        return this.emotionRecords.get(index);
    }

    public int getSize() {
        return this.emotionRecords.size();
    }

    //other list functionality
    public boolean containsRecord(EmotionRecord record) {
        return this.emotionRecords.contains(record);
    }

    public void sortRecords() {
        Collections.sort(this.emotionRecords);
    }

    public void removeRecord(EmotionRecord record) throws RecordNotInListException {
        if (this.containsRecord(record)) {
            emotionRecords.remove(record);
            this.sortRecords();
        } else {
            throw new RecordNotInListException();
        }
    }

    public void addRecord(EmotionRecord record) {
        emotionRecords.add(record);
        this.sortRecords();
    }
}
