package ca.ualberta.cs.adj_feelsbook;

import java.util.List;


public class EmotionRecordList {
    private List<EmotionRecord> emotionRecords;

    //To store the counts of each emotion we will use an int array.
    //EmotionCounts[0] = love, [1] = joy, [2] = surprise, [3] = anger, [4] = sadness, [5] = fear
    private int[] emotionCounts = {0,0,0,0,0,0};

    EmotionRecordList(){

    }

    public int getSize(){
        return this.emotionRecords.size();
    }

    public void addRecord(EmotionRecord record){
        this.emotionRecords.add(record);
        if(record.getEmotion() == "love"){
            this.emotionCounts[0]++;
        }
        else if(record.getEmotion() == "joy"){
            this.emotionCounts[1]++;
        }
        else if(record.getEmotion() == "surprise"){
            this.emotionCounts[2]++;
        }
        else if(record.getEmotion() == "anger"){
            this.emotionCounts[3]++;
        }
        else if(record.getEmotion() == "sadness"){
            this.emotionCounts[4]++;
        }
        else if(record.getEmotion() == "fear"){
            this.emotionCounts[5]++;
        }
    }

    public void removeRecord(EmotionRecord record) throws RecordNotInListException{
        if(!this.emotionRecords.contains(record)){
            throw new RecordNotInListException();
            }
        else{
            if(record.getEmotion() == "love"){
                this.emotionCounts[0]--;
            }
            else if(record.getEmotion() == "joy"){
                this.emotionCounts[1]--;
            }
            else if(record.getEmotion() == "surprise"){
                this.emotionCounts[2]--;
            }
            else if(record.getEmotion() == "anger"){
                this.emotionCounts[3]--;
            }
            else if(record.getEmotion() == "sadness"){
                this.emotionCounts[4]--;
            }
            else if(record.getEmotion() == "fear"){
                this.emotionCounts[5]--;
            }
            this.emotionRecords.remove(record);
        }
    }

    public int[] getEmotionCounts(){
        return this.emotionCounts;
    }

}
