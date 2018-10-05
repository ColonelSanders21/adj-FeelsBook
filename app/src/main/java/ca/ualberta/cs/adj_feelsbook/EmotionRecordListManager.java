package ca.ualberta.cs.adj_feelsbook;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;


//Saves and loads the EmotionRecordList as necessary to file (methods called when changes are made)
public class EmotionRecordListManager {

    public EmotionRecordListManager() {
    }

    static public void loadFile(Context context) {
        try {
            //First three lines based off of lonelyTwitter by Joshua Charles Campbell and Cody
            //Rosevear https://github.com/Rosevear/lonelyTwitter
            FileInputStream fis = context.openFileInput("feelsbook.sav");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);

            //Since EmotionRecord is an abstract class, we have to use EmotionRecordTypeAdapter
            //to serialize and deserialize the data to save into file.sav
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(EmotionRecord.class, new EmotionRecordTypeAdapter());
            Gson gson = gsonBuilder.create();
            EmotionRecordList savedList = gson.fromJson(reader, EmotionRecordList.class);
            EmotionRecordListController.setEmotionRecordList(savedList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public void saveFile(Context context) {
        try {
            //First three lines based off of lonelyTwitter by Joshua Charles Campbell and Cody
            //Rosevear https://github.com/Rosevear/lonelyTwitter
            FileOutputStream fos = context.openFileOutput("feelsbook.sav", 0);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter writer = new BufferedWriter(osw);

            //Since EmotionRecord is an abstract class, we have to use EmotionRecordTypeAdapter
            //to serialize and deserialize the data to save into file.sav
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(EmotionRecord.class, new EmotionRecordTypeAdapter());
            Gson gson = gsonBuilder.create();
            gson.toJson(EmotionRecordListController.getEmotionRecordList(), writer);
            writer.flush();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

