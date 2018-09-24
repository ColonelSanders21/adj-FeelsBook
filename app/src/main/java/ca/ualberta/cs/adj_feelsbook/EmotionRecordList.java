package ca.ualberta.cs.adj_feelsbook;

import java.util.List;

public class EmotionRecordList {
    private int love_count;
    private int joy_count;
    private int surprise_count;
    private int anger_count;
    private int sadness_count;
    private int fear_count;
    private List<EmotionRecord> records;

    EmotionRecordList(){
        love_count = 0;
        joy_count = 0;
        surprise_count = 0;
        anger_count = 0;
        sadness_count = 0;
        fear_count = 0;
        
    }

}
