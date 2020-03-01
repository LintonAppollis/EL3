package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LastActivity extends AppCompatActivity {
    public String message;
    public static final String EXTRA_TEXT = "package com.example.myapplication";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        Intent intent = getIntent();
        message = intent.getStringExtra(Activity4.EXTRA_TEXT);

        TextView textView7 = (TextView) findViewById(R.id.textView7);
        textView7.setText(message);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity();
            }
        });
    }

    public void MainActivity()
    {
        message = message + "\nLastActivity: All Activities .\nMessages of 5 Activities Displayed Here";
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_TEXT, message);
        startActivity(intent);
    }
}
