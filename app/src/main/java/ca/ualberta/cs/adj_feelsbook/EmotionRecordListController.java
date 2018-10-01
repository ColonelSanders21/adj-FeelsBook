package ca.ualberta.cs.adj_feelsbook;

public class EmotionRecordListController {

    //CITE THIS Based on tutorial video StudentPicker
    private static EmotionRecordList emotionRecords = null;
    static public EmotionRecordList getEmotionRecordList(){
        if(emotionRecords == null){
            emotionRecords = new EmotionRecordList();
        }
        return emotionRecords;
    }
    public void addRecord(EmotionRecord emotionRecord){
        getEmotionRecordList().addRecord(emotionRecord);
    }

    //For debug and testing
    public int getSize(){
        return getEmotionRecordList().getSize();
    }

    public EmotionRecord getRecord(int index){
        return getEmotionRecordList().getRecord(index);
    }
    public int getIndex(EmotionRecord record){ return getEmotionRecordList().getEmotionRecords().indexOf(record);}
}
