package com.example.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import java.util.ArrayList;

public class MusicLibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        // crate an arrayList of songs
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Lana del Rey","Video Games",R.drawable.album_lana));
        songs.add(new Song("Lana del Rey","Blue Jeans",R.drawable.album_lana));
        songs.add(new Song("Lana del Rey","Off To The Races",R.drawable.album_lana));
        songs.add(new Song("Lana del Rey","Dark Paradise",R.drawable.album_lana));
        songs.add(new Song("Lana del Rey","Carmen",R.drawable.album_lana));
        songs.add(new Song("Norah Jones","Sunrise",R.drawable.album_norah));
        songs.add(new Song("Norah Jones","What Am I To You",R.drawable.album_norah));
        songs.add(new Song("Norah Jones","In The Morning",R.drawable.album_norah));
        songs.add(new Song("Norah Jones","Toes",R.drawable.album_norah));
        songs.add(new Song("Norah Jones","Humble Me",R.drawable.album_norah));
        songs.add(new Song("Norah Jones","Above Ground",R.drawable.album_norah));
        songs.add(new Song("Them","Richard Cory",R.drawable.album));
        songs.add(new Song("The Beatles","Sgt. Peppers Lonely Hearts Club Band",R.drawable.album_beatles));
        songs.add(new Song("The Beatles","Let it be",R.drawable.album_beatles));

        //find the root view of the whole layout
        //LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        SongAdapter adapter = new SongAdapter(this, songs);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // When clicked, show a toast with the TextView text
                TextView currentArtist = (TextView) view.findViewById(R.id.artist_text_view);
                String ArtistPlaying = currentArtist.getText().toString();

                TextView currentSong = (TextView) view.findViewById(R.id.song_text_view);
                String SongPlaying = currentSong.getText().toString();

                Intent nowPlayingIntent  = new Intent(MusicLibraryActivity.this, NowPlayingActivity.class);
                //pass the information for the user chosen Song and artist to the NowpPlayingActivity
                nowPlayingIntent.putExtra("ArtistName", ArtistPlaying);
                nowPlayingIntent.putExtra("SongName", SongPlaying);

                startActivity(nowPlayingIntent );
            }
        });
    }
}