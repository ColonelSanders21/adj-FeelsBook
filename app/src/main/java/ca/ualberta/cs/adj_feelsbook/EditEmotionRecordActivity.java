package ca.ualberta.cs.adj_feelsbook;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class EditEmotionRecordActivity extends AppCompatActivity {
    EmotionRecordList recordList = EmotionRecordListController.getEmotionRecordList();
    EmotionRecord emotionRecord;
    TextView dateTextView;
    TextView commentTextView;
    TextView emotionIconTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_emotion);

        dateTextView = (TextView) findViewById(R.id.dateTextView);
        commentTextView = (TextView) findViewById(R.id.commentTextView);
        emotionIconTextView = (TextView) findViewById(R.id.emotionIconTextView);

        Intent intent = getIntent();
        int recordIndex = intent.getExtras().getInt("index");
        emotionRecord = recordList.getRecord(recordIndex);

        //These set the textviews to show the current values of the emotion record
        dateTextView.setText(emotionRecord.getDate().toString());
        commentTextView.setText(emotionRecord.getComment());

        //This sets the emoji title at the top
        emotionIconTextView.setText(emotionRecord.getEmoji());





    }

    public void openDatePicker(View v){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    public void openTimePicker(View v){
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }
    public void saveEdit(View v){
        String newComment = commentTextView.getText().toString();
        emotionRecord.setComment(newComment);
        finish();
    }
    public void deleteRecord(View v){
        recordList.removeRecord(emotionRecord);
        finish();
    }
}
