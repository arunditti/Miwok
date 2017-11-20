package com.arunditti.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create an ArrayList of words
        final ArrayList<Word> words = new ArrayList<Word>();

        // Word w = new Word("One", "lutti");
        // words.add(w);
        words.add(new Word("red", "weṭeṭṭi",R.drawable.color_red, R.raw.color_red));
        words.add(new Word("green", "chokokki",R.drawable.color_green, R.raw.color_green));
        words.add(new Word("brown", "ṭakaakki",R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("gray", "ṭopoppi",R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("black", "kululli",R.drawable.color_black, R.raw.color_black));
        words.add(new Word("white", "kelelli",R.drawable.color_white, R.raw.color_white));
        words.add(new Word("dusty yellow", "ṭopiisә",R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("mustard yellow", "chiwiiṭә",R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        //Log.v("NumbersActivity", "Word at index 0: " + words);

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_listyout file.
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Toast.makeText(NumbersActivity.this, "List item clicked", Toast.LENGTH_SHORT).show();

                //Get the object at the given position the user clicked on
                Word word = words.get(position);

                //Create and setup the audio resource associated with that world
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });

    }
}
