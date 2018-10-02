package ca.ualberta.cs.adj_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collection;


//Activity that launches when the user
public class EmotionRecordListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.emotion_record_list);
    }

    @Override
    protected void onResume(){
        super.onResume();

        //Based on StudentPicker tutorial by Abram Hindle: https://www.youtube.com/watch?v=7zKCuqScaRE&list=PL240uJOh_Vb4PtMZ0f7N8ACYkCLv0673O&index=6
        ListView listView = findViewById(R.id.emotionListView);
        Collection<EmotionRecord> emotionRecordCollection = EmotionRecordListController.getEmotionRecordList().getEmotionRecords();
        ArrayList<EmotionRecord> list = new ArrayList<EmotionRecord>(emotionRecordCollection);
        final ArrayAdapter<EmotionRecord> emotionAdapter = new ArrayAdapter<EmotionRecord>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(emotionAdapter);

        //Updates
        updateLoveCount();
        updateJoyCount();
        updateSurpriseCount();
        updateAngerCount();
        updateSadnessCount();
        updateFearCount();

        //Selecting item from list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(EmotionRecordListActivity.this, EditEmotionRecordActivity.class);

                //Credit to Paresh Mayani and Peter Mortensen from StackOverflow for recommending
                //this function: https://stackoverflow.com/a/7074143
                intent.putExtra("index", position );
                startActivity(intent);
                emotionAdapter.notifyDataSetChanged();
            }
        });



    }

    //These each get a template string from R.string and add the current number of emotions to their TextViews
    public void updateLoveCount(){
        TextView loveCountTextView = findViewById(R.id.loveCountTextView);
        int loveCount = EmotionRecordListController.getEmotionRecordList().getLoveCount();
        String newLoveCount = getString(R.string.love_count) + loveCount;
        loveCountTextView.setText(newLoveCount);
    }
    public void updateJoyCount(){
        TextView joyCountTextView = findViewById(R.id.joyCountTextView);
        int joyCount = EmotionRecordListController.getEmotionRecordList().getJoyCount();
        String newJoyCount = getString(R.string.joy_count) + joyCount;
        joyCountTextView.setText(newJoyCount);
    }
    public void updateSurpriseCount(){
        TextView surpriseCountTextView = findViewById(R.id.surpriseCountTextView);
        int surpriseCount = EmotionRecordListController.getEmotionRecordList().getSurpriseCount();
        String newSadnessCount = getString(R.string.surprise_count) + surpriseCount;
        surpriseCountTextView.setText(newSadnessCount);
    }

    public void updateAngerCount(){
        TextView angerCountTextView = findViewById(R.id.angerCountTextView);
        int angerCount = EmotionRecordListController.getEmotionRecordList().getAngerCount();
        String newAngerCount = getString(R.string.anger_count) + angerCount;
        angerCountTextView.setText(newAngerCount);
    }

    public void updateSadnessCount(){
        TextView sadnessCountTextView = findViewById(R.id.sadnessCountTextView);
        int sadnessCount = EmotionRecordListController.getEmotionRecordList().getSadnessCount();
        String newSadnessCount = getString(R.string.sadness_count) + sadnessCount;
        sadnessCountTextView.setText(newSadnessCount);
    }

    public void updateFearCount(){
        TextView fearCountTextView = findViewById(R.id.fearCountTextView);
        int fearCount = EmotionRecordListController.getEmotionRecordList().getFearCount();
        String newFearCount = getString(R.string.fear_count) + fearCount;
        fearCountTextView.setText(newFearCount);
    }
}
