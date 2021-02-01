package com.example.musicalstructureapp;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.LayoutInflater;
import java.util.ArrayList;
import androidx.annotation.NonNull;

public class SongAdapter extends ArrayAdapter<Song> {
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     */
    public SongAdapter(Activity context, ArrayList<Song> songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songs);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        artistTextView.setText(currentSong.getArtistName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView songTextView = (TextView) listItemView.findViewById(R.id.song_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        songTextView.setText(currentSong.getSongName());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.album_icon);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setImageResource(currentSong.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}

