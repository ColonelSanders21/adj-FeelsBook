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
    static public void setEmotionRecordList(EmotionRecordList newList){
        emotionRecords = newList;
    }
    static public void sortRecords(){ //Static again, for the same purpose
        emotionRecords.sortRecords();
    }
    static public void addRecord(EmotionRecord emotionRecord){
        getEmotionRecordList().addRecord(emotionRecord);
    }
    static public int getSize(){
        return getEmotionRecordList().getSize();
    }

    static public int countRecord(EmotionRecord recordToCount){
        int count = 0;
        for(int i= 0; i < getSize(); i++){
            if(emotionRecords.getRecord(i).getClass() == recordToCount.getClass()){
                count++;
            }
        }
        return count;
    }

    static public int getLoveCount(){
        return countRecord(new LoveRecord());
    }
    static public int getJoyCount(){
        return countRecord(new JoyRecord());
    }
    static public int getSurpriseCount(){
        return countRecord(new SurpriseRecord());
    }
    static public int getAngerCount(){
        return countRecord(new AngerRecord());
    }
    static public int getSadnessCount(){
        return countRecord(new SadnessRecord());
    }
    static public int getFearCount(){
        return countRecord(new FearRecord());
    }
    //For debug and testing
    public EmotionRecord getRecord(int index){
        return getEmotionRecordList().getRecord(index);
    }
    public int getIndex(EmotionRecord record){ return getEmotionRecordList().getEmotionRecords().indexOf(record);}

}
