package com.mkt.tp2;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;



public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.mkt.tp2.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private EditText mMessageEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);

    }


    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, Activity_2.class);
        String message = mMessageEditText.getText().toString();
        if(message.isEmpty())  {
            message="OOOPS!!!\n Vous n'avez rien saisi";
        }
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }
    public void launchThirdActivity(View view) {
        Intent intent = new Intent(this, Activity_3.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void launchEventActivity(View view){
        Calendar DateTime = Calendar.getInstance();
        DateTime.set(2022, 11, 31, 23, 00);
        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra(CalendarContract.Events.TITLE, "Event Title");
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, DateTime.getTimeInMillis());
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, DateTime.getTimeInMillis());
        intent.putExtra(CalendarContract.Events.ALL_DAY, false);
        intent.putExtra(CalendarContract.Events.DESCRIPTION, "Event Description");
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Event Location");
        startActivity(Intent.createChooser(intent, "Add to calendar"));
    }


}