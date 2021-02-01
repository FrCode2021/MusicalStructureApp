package com.example.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_now_playing);

        //check for extra information that came with the intent
        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            // using SharedPreferences to store data accessible from any activity in the app
            SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
            // Creating an Editor object to store to file
            SharedPreferences.Editor myEdit = sharedPreferences.edit();

            // write song and artist information received from intent to the sharedPreferences Editor
            myEdit.putString("playingArtist",extras.getString("ArtistName"));
            myEdit.putString("playingSong", extras.getString("SongName"));
            // Save the changes in SharedPreferences
            myEdit.apply();  // commit changes
        }

        // Retrieving the song and artist information from the shared value
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String currentArtistPlaying = sharedPreferences.getString("playingArtist", "");
        String currentSongPlaying = sharedPreferences.getString("playingSong", "");

        //show artist and song information for song clicked by user in TextView for current_song_playing
        TextView songPlaying = (TextView) findViewById(R.id.current_song_playing);
        songPlaying.setText("Now Playing:" + "\n" + "\n" + currentSongPlaying + "\n" + currentArtistPlaying);

        //Find the view for return to Main Menu
        TextView mainMenu = (TextView) findViewById(R.id.main_menu);

        //Set a clickListener on that view
        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainMenuIntent  = new Intent(NowPlayingActivity.this, MainActivity.class);
                startActivity(mainMenuIntent );
            }
        });
    }
}