package ca.ualberta.cs.adj_feelsbook;

import java.util.ArrayList;
import java.util.Collections;


public class EmotionRecordList {
    private ArrayList<EmotionRecord> emotionRecords;
    //private ArrayList<Integer> emotionRecordCounts;
    /* (a, b, c, d, e, f) => a=love count, b=joy count, c=surprise count, d=anger count,
                             e = sadness count, f = fear count */
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
    public void removeRecord(EmotionRecord record){
        if(this.containsRecord(record)){
            String recordType = record.getClass().getSimpleName();
            emotionRecords.remove(record);
            this.sortRecords();
            if(recordType.equals("LoveRecord")){
                loveCount--;
            }
            else if(recordType.equals("JoyRecord")){
                joyCount--;
            }
            else if(recordType.equals("SurpriseRecord")){
                surpriseCount--;
            }
            else if(recordType.equals("AngerRecord")){
                angerCount--;
            }
            else if(recordType.equals("SadnessRecord")){
                sadnessCount--;
            }
            else if(recordType.equals("FearRecord")){
                fearCount--;
            }
            else{
                //Theoretically, this exception should never be thrown
                //throw new RecordTypeNotValidException();
            }

        }
        else{
            //throw new RecordNotInListException();
        }
    }
    public void addRecord(EmotionRecord record){
        String recordType = record.getClass().getSimpleName();
        if(recordType.equals("LoveRecord")){
            loveCount++;
            emotionRecords.add(record);
            this.sortRecords();

        }
        else if(recordType.equals("JoyRecord")){
            joyCount++;
            emotionRecords.add(record);
            this.sortRecords();

        }
        else if(recordType.equals("SurpriseRecord")){
            surpriseCount++;
            emotionRecords.add(record);
            this.sortRecords();

        }
        else if(recordType.equals("AngerRecord")){
            angerCount++;
            emotionRecords.add(record);
            this.sortRecords();

        }
        else if(recordType.equals("SadnessRecord")){
            sadnessCount++;
            emotionRecords.add(record);
            this.sortRecords();

        }
        else if(recordType.equals("FearRecord")){
            fearCount++;
            emotionRecords.add(record);
            this.sortRecords();

        }
        else{
            //throw new RecordTypeNotValidException();
        }
    }
}
