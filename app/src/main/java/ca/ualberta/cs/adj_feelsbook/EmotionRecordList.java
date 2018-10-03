package ca.ualberta.cs.adj_feelsbook;

import java.util.ArrayList;
import java.util.Collections;


public class EmotionRecordList {
    private ArrayList<EmotionRecord> emotionRecords;
    private int loveCount;
    private int joyCount;
    private int surpriseCount;
    private int angerCount;
    private int sadnessCount;
    private int fearCount;


    EmotionRecordList(){
        this.emotionRecords = new ArrayList<EmotionRecord>();
        this.loveCount = 0;
        this.joyCount = 0;
        this.surpriseCount = 0;
        this.angerCount = 0;
        this.sadnessCount = 0;
        this.fearCount = 0;
    }

    //getters

    public ArrayList<EmotionRecord> getEmotionRecords() {
        return emotionRecords;
    }

    public EmotionRecord getRecord(int index){
        return this.emotionRecords.get(index);
    }
    public int getSize(){
        return this.emotionRecords.size();
    }
    public int getLoveCount(){
        return this.loveCount;
    }
    public int getJoyCount(){
        return this.joyCount;
    }
    public int getSurpriseCount(){
        return this.surpriseCount;
    }
    public int getAngerCount(){
        return this.angerCount;
    }
    public int getSadnessCount(){
        return this.sadnessCount;
    }
    public int getFearCount(){
        return this.fearCount;
    }

    //other list functionality
    public boolean containsRecord(EmotionRecord record){
        return this.emotionRecords.contains(record);
    }
    public void sortRecords(){
        Collections.sort(this.emotionRecords);
    }
    public void removeRecord(EmotionRecord record) throws RecordNotInListException{
        if(this.containsRecord(record)){
            String recordType = record.getClass().getSimpleName();
            emotionRecords.remove(record);
            this.sortRecords();
            switch(recordType) {
                case "LoveRecord":
                    loveCount--;
                    break;
                case "JoyRecord":
                    joyCount--;
                    break;
                case "SurpriseRecord":
                    surpriseCount--;
                    break;
                case "AngerRecord":
                    angerCount--;
                    break;
                case "SadnessRecord":
                    sadnessCount--;
                    break;
                case "FearRecord":
                    fearCount--;
                    break;
            }
        }
        else{
            throw new RecordNotInListException();
        }
    }
    public void addRecord(EmotionRecord record){
        String recordType = record.getClass().getSimpleName();
        switch(recordType) {
            case "LoveRecord":
                loveCount++;
                break;
            case "JoyRecord":
                joyCount++;
                break;
            case "SurpriseRecord":
                surpriseCount++;
                break;
            case "AngerRecord":
                angerCount++;
                break;
            case "SadnessRecord":
                sadnessCount++;
                break;
            case "FearRecord":
                fearCount++;
                break;
        }
        emotionRecords.add(record);
        this.sortRecords();
    }
}
