package ca.ualberta.cs.adj_feelsbook;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;


//Activity that launches when a user goes to edit an emotion record
public class EditEmotionRecordActivity extends AppCompatActivity {
    EmotionRecordList recordList = EmotionRecordListController.getEmotionRecordList();
    EmotionRecord emotionRecord;
    TextView dateTextView;
    TextView commentTextView;
    TextView emotionIconTextView;
    DatePickerDialog.OnDateSetListener dateSetListener;
    TimePickerDialog.OnTimeSetListener timeSetListener;
    SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd'T'hh:mm:ss");

    //This variable stores a date object for when the user decides whether to save changes
    private Date stagedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_emotion);
    }

    protected void onResume() {
        super.onResume();
        dateTextView = findViewById(R.id.dateTextView);
        commentTextView = findViewById(R.id.commentTextView);
        emotionIconTextView = findViewById(R.id.emotionIconTextView);

        //We receive the index from the list of the record the user wants to edit
        Intent intent = getIntent();
        int recordIndex = intent.getExtras().getInt("index");
        emotionRecord = recordList.getRecord(recordIndex);

        //Setting stagedDate to be the original date of the record
        stagedDate = emotionRecord.getDate();

        //These set the textviews to show the current values of the emotion record
        dateTextView.setText(dateFormat.format(emotionRecord.getDate()));
        commentTextView.setText(emotionRecord.getComment());

        //This sets the emoji title at the top of the screen
        emotionIconTextView.setText(emotionRecord.getEmoji());
    }

    public void openDatePicker(View v) {
        //Based on tutorial https://www.youtube.com/watch?v=hwe1abDO2Ag by Mitch Tabian
        Calendar calendar = Calendar.getInstance();
        Date oldDate = stagedDate;
        calendar.setTime(oldDate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        //The following three are final -- we want time to carry over from what was set to before
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);
        final int second = calendar.get(Calendar.SECOND);

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar cal = Calendar.getInstance();
                cal.set(year, month, dayOfMonth, hour, minute, second);
                Date newDate = cal.getTime();
                dateTextView.setText(dateFormat.format(newDate));

                //We store the new date in a class variable if we decide to save it later
                stagedDate = newDate;
            }
        };
        DatePickerDialog dialog = new DatePickerDialog(EditEmotionRecordActivity.this,
                android.R.style.Theme_DeviceDefault_Light_Dialog_Alert, dateSetListener,
                year, month, day);
        dialog.show();


    }

    public void openTimePicker(View v) {
        //Based on tutorial https://www.youtube.com/watch?v=hwe1abDO2Ag by Mitch Tabian
        Calendar calendar = Calendar.getInstance();
        Date oldDate = stagedDate;
        calendar.setTime(oldDate);
        //The following three are final -- we want date to carry over from what was set before
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Calendar cal = Calendar.getInstance();
                cal.set(year, month, day, hourOfDay, minute, 0);
                Date newDate = cal.getTime();
                dateTextView.setText(dateFormat.format(newDate));

                //We store the new date in a class variable if we decide to save it later
                stagedDate = newDate;
            }
        };
        TimePickerDialog dialog = new TimePickerDialog(EditEmotionRecordActivity.this,
                android.R.style.Theme_DeviceDefault_Light_Dialog_Alert,
                timeSetListener, hour, minute,
                DateFormat.is24HourFormat(EditEmotionRecordActivity.this));
        dialog.show();


    }

    public void saveEdit(View v) {
        String newComment = commentTextView.getText().toString();
        try {
            emotionRecord.setComment(newComment);
        } catch (CommentTooLongException e) {
            Toast.makeText(this, "Comment is too long! Comment not saved.",
                    Toast.LENGTH_SHORT).show();
        }

        emotionRecord.setDate(stagedDate);
        EmotionRecordListController.sortRecords();
        EmotionRecordListManager.saveFile(this);
        finish();
    }

    public void deleteRecord(View v) {
        try {
            recordList.removeRecord(emotionRecord);
        } catch (RecordNotInListException e) {
            Toast.makeText(this, "Error: Record not in list.", Toast.LENGTH_SHORT).show();
        }
        EmotionRecordListManager.saveFile(this);
        finish();
    }

    public void cancelEdit(View v) {
        finish();
    }
}
