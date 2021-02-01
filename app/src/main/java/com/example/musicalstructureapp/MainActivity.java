/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //Find the view with the music library
        TextView musicLibrary = (TextView) findViewById(R.id.music_library);

        //Set a clickListener on that view
        musicLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent musicLibraryIntent  = new Intent(MainActivity.this, MusicLibraryActivity.class);
                startActivity(musicLibraryIntent);
            }
        });

        //Find the view with the currently playing song
        TextView currentlyPlaying = (TextView) findViewById(R.id.music_now_playing);

        //Set a clickListener on that view
        currentlyPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent currentlyPlayingIntent  = new Intent(MainActivity.this, NowPlayingActivity.class);
                startActivity(currentlyPlayingIntent);
            }
        });
    }
}