package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {
    public String message;
    public static final String EXTRA_TEXT = "package com.example.myapplication";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Intent intent = getIntent();
        message = intent.getStringExtra(Activity2.EXTRA_TEXT);

        TextView textView7 = (TextView) findViewById(R.id.textView7);
        textView7.setText(message);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity4();
            }
        });
    }

    public void Activity4()
    {
        message = message + "\nActivity3: I have read the message.";
        Intent intent = new Intent(this, Activity4.class);
        intent.putExtra(EXTRA_TEXT, message);
        startActivity(intent);
    }
}
