package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    public String message;
    public static final String EXTRA_TEXT = "package com.example.myapplication";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_TEXT);

        TextView textView7 = (TextView) findViewById(R.id.textView7);
        textView7.setText(message);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity3();
            }
        });
    }

    public void Activity3()
    {
        message = message + "\n\nRead receipt confirmation\n------------------------------------------\nActivity2: I have read the message.";
        Intent intent = new Intent(this, Activity3.class);
        intent.putExtra(EXTRA_TEXT, message);
        startActivity(intent);
    }
}
