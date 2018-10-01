package ca.ualberta.cs.adj_feelsbook;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class EmotionRecordListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.emotion_record_list);
        final EmotionRecordListController listController = new EmotionRecordListController();
        //Based on StudentPicker tutorial by Abram Hindle: https://www.youtube.com/watch?v=7zKCuqScaRE&list=PL240uJOh_Vb4PtMZ0f7N8ACYkCLv0673O&index=6
        ListView listView = (ListView) findViewById(R.id.emotionListView);
        Collection<EmotionRecord> emotionRecordCollection = EmotionRecordListController.getEmotionRecordList().getEmotionRecords();
        ArrayList<EmotionRecord> list = new ArrayList<EmotionRecord>(emotionRecordCollection);
        final ArrayAdapter<EmotionRecord> emotionAdapter = new ArrayAdapter<EmotionRecord>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(emotionAdapter);


        //Selecting item from list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EmotionRecord emotionRecord = (EmotionRecord) parent.getAdapter().getItem(position);
                Intent intent = new Intent(EmotionRecordListActivity.this, EditEmotionRecordActivity.class);

                //From https://stackoverflow.com/questions/7074097/how-to-pass-integer-from-one-activity-to-another
                intent.putExtra("index", position );
                startActivity(intent);
                emotionAdapter.notifyDataSetChanged();
            }
        });
    }
}
