/*
    FeelsBook: Allows recording of feelings to analyze these feelings over time

    Copyright (C) 2018 Anders Johnson adj@ualberta.ca

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.


 */

package ca.ualberta.cs.adj_feelsbook;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private EmotionRecordList emotionRecords = new EmotionRecordList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //CITE THIS -- large portion based on Student Picker tutorial
    public void viewLog(View v){
        Intent intent = new Intent(MainActivity.this, EmotionRecordListActivity.class);
        startActivity(intent);
    }

    public void addNewLove(View v){
        EmotionRecordListController listController = new EmotionRecordListController();
        listController.addRecord(new LoveRecord());
        //Toast.makeText(this, "Feeling of love recorded!", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Test");
        builder.setMessage("Feeling of love saved! Add comment?");
        builder.setNegativeButton(R.string.comment_dialog_decline, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton(R.string.comment_dialog_confirm, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                /* This code block would launch the edit comment window -- Is this necessary?
                Intent intent = new Intent(MainActivity.this, EditEmotionRecordActivity.class);
                startActivity(intent);
                */

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

}
