package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        ArrayList<String> strList = new ArrayList<String>();
        strList.add("one");
        strList.add("two");
        strList.add("three");
        strList.add("four");
        strList.add("five");
        strList.add("six");
        strList.add("seven");
        strList.add("eight");
        strList.add("nine");
        strList.add("ten");

        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);

        for(String str : strList){
            TextView wordView = new TextView(this);
            wordView.setText(str);
            rootView.addView(wordView);
        }
    }

}
