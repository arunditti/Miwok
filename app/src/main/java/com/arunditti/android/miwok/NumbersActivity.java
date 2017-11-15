package com.arunditti.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        //Create an ArrayList of words
        ArrayList<String> words = new ArrayList<>();
        words.add("One");
        words.add("Two");
        words.add("Three");
        words.add("Four");
        words.add("Five");
        words.add("Six");
        words.add("Seven");
        words.add("Eight");
        words.add("Nine");
        words.add("ten");
        //Log.v("NumbersActivity", "Word at index 0: " + words);

        //Find the LinearLayout called rootview so that we can add child views to it
        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);

        for(int index = 0; index < words.size(); index++) {
            //Add TextView to this LinearLayout by creating TextView object called wordView
            TextView wordView = new TextView(this);

            // Set the text to be word at the current index
            wordView.setText(words.get(index));

            // Add this TextView as another child to the root view of this layout
            rootView.addView(wordView);

           // Log.v("NumbersActivity", "Index: " + index + " Value:" + words.get(index));
        }

    }
}
