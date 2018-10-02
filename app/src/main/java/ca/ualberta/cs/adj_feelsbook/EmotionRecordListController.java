package ca.ualberta.cs.adj_feelsbook;

public class EmotionRecordListController {

    //Based on Student Picker tutorial and code by Abram Hindle: https://www.youtube.com/watch?v=uLnoI7mbuEo

    private static EmotionRecordList emotionRecords = null; //Static so that we can continue to access the same record list
    static public EmotionRecordList getEmotionRecordList(){

        if(emotionRecords == null){
            emotionRecords = new EmotionRecordList();
        }
        return emotionRecords;
    }
    static public void sortRecords(){ //Static again, for the same purpose
        emotionRecords.sortRecords();
    }
    public void addRecord(EmotionRecord emotionRecord){
        getEmotionRecordList().addRecord(emotionRecord);
    }
    public int getSize(){
        return getEmotionRecordList().getSize();
    }

    //For debug and testing
    public EmotionRecord getRecord(int index){
        return getEmotionRecordList().getRecord(index);
    }
    public int getIndex(EmotionRecord record){ return getEmotionRecordList().getEmotionRecords().indexOf(record);}

}
