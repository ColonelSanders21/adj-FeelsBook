package ca.ualberta.cs.adj_feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.edit_emotion);

        //for button testing
        /*final Button button = findViewById(R.id.newJoy);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setContentView(R.layout.edit_emotion);
            }
        });*/
    }
}
