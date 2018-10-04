package ca.ualberta.cs.adj_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;


//Activity that launches the list of previous emotion records
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

        //Updates counters

        setCounters();
        //Selecting item from list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(EmotionRecordListActivity.this, EditEmotionRecordActivity.class);

                // Credit to Paresh Mayani and Peter Mortensen from StackOverflow for recommending
                // this function: https://stackoverflow.com/a/7074143
                intent.putExtra("index", position );
                startActivity(intent);
                emotionAdapter.notifyDataSetChanged();
            }
        });



    }
    public void setCounters(){
        //Set love counter
        TextView loveCountTextView = findViewById(R.id.loveCountTextView);
        String s = getString(R.string.love_count) + EmotionRecordListController.getLoveCount();
        loveCountTextView.setText(s);

        //Set joy counter
        TextView joyCountTextView = findViewById(R.id.joyCountTextView);
        s = getString(R.string.joy_count) + EmotionRecordListController.getJoyCount();
        joyCountTextView.setText(s);

        //Set surprise counter
        TextView surpriseCountTextView = findViewById(R.id.surpriseCountTextView);
        s = getString(R.string.surprise_count) + EmotionRecordListController.getSurpriseCount();
        surpriseCountTextView.setText(s);

        //Set anger counter
        TextView angerCountTextView = findViewById(R.id.angerCountTextView);
        s = getString(R.string.anger_count)+ EmotionRecordListController.getAngerCount();
        angerCountTextView.setText(s);

        //Set sadness counter
        TextView sadnessCountTextView = findViewById(R.id.sadnessCountTextView);
        s = getString(R.string.sadness_count) + EmotionRecordListController.getSadnessCount();
        sadnessCountTextView.setText(s);

        //Set fear counter
        TextView fearCountTextView = findViewById(R.id.fearCountTextView);
        s = getString(R.string.fear_count)+ EmotionRecordListController.getFearCount();
        fearCountTextView.setText(s);

    }
}
