package ca.ualberta.cs.adj_feelsbook;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


//This creates custom serialization and deserialization for gson to use, since you can't deserialize
//abstract classes (ie. it tries to make an EmotionRecord, which can't be initialized)
public class EmotionRecordTypeAdapter implements JsonSerializer<EmotionRecord>, JsonDeserializer<EmotionRecord>{
    @Override
    public JsonElement serialize(EmotionRecord emotionRecord, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();

        //Convert date to iso since we use this format a few times
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        String date = dateFormat.format(emotionRecord.getDate());
        //jsonObject.addProperty("emotion", emotionRecord.getClass().getSimpleName());
        jsonObject.addProperty("emoji", emotionRecord.getEmoji());
        jsonObject.addProperty("comment", emotionRecord.getComment());
        jsonObject.addProperty("date", date);
        Log.d("cmput","Date saved was" +date);
        return jsonObject;
    }

    @Override
    public EmotionRecord deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        JsonObject jsonObject = json.getAsJsonObject();
        String emoji = jsonObject.get("emoji").getAsString();
        EmotionRecord record;
        switch(emoji){
            case "\uD83D\uDE0D":
                //😍 Love
                record = new LoveRecord();
                break;
            case "\uD83D\uDE0A":
                //😊 joy
                record = new JoyRecord();
                break;
            case "\uD83D\uDE2E":
                //😮 surprise
                record = new SurpriseRecord();
                break;
            case "\uD83D\uDE20":
                //😠 anger
                record = new AngerRecord();
                break;
            case "\uD83D\uDE22":
                //😢 sadness
                record = new SadnessRecord();
                break;
            case "\uD83D\uDE28":
                //😨 fear
                record = new FearRecord();
                break;
            default:
                //this should never go off, but we will log if it does
                Log.d("cmput", "Deserializer had fault determining emoji");
                record = new LoveRecord();
        }
        try {
            record.setComment(jsonObject.get("comment").getAsString());
        }catch (CommentTooLongException e){
            //This should never trip, since we are resubmitting an already approved comment
            e.printStackTrace();
        }
        Date date;
        try{
            date = dateFormat.parse(jsonObject.get("date").getAsString());
        }catch(ParseException e){
            //We are resubitting an already approved date, so this shouldn't trip
            date = new Date();
            Log.d("cmput","Date was not parsed properly");
        }
        record.setDate(date);

        return record;


    }
}
