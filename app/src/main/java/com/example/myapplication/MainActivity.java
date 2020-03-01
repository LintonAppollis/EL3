package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity
{

    private EditText MessageEditText;
    private TextView resultTextView;
    private TextView confirmation;
    public String message;
    public static final String EXTRA_TEXT = "com.example.myapplication";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        Intent intent = getIntent();
        message = intent.getStringExtra(LastActivity.EXTRA_TEXT);
        confirmation = (TextView) findViewById(R.id.resultTextView);
        confirmation.setText(message);


        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                MessageEditText = (EditText) findViewById(R.id.MessageEditText);
                resultTextView = (TextView) findViewById(R.id.resultTextView);
                message = MessageEditText.getText() + ".";


                if (!(MessageEditText.getText().toString().isEmpty())) {


                    Activity2();
                } else {

                    resultTextView.setText("Error encountered: No valid input entered...");
                }

            }
        });
    }

    public void Activity2() {

        String textBox = MessageEditText.getText().toString();

        Intent intent = new Intent(this, Activity2.class);

        intent.putExtra(EXTRA_TEXT, textBox);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}