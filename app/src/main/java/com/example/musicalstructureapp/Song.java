package com.example.musicalstructureapp;


/**
 * {@link Song} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */
public class Song {

    /**Song Artist*/
    private String mArtistName;

    /**Song Name*/
    private String mSongName;

    // Drawable resource ID
    private int mImageResourceId;


    /*
     * Create a new Song object.
     *
     * @param vArtistName is the name of the Artist (e.g. Lana del Rey)
     * @param vSongName is the name of the Song (e.g. Summertime Sadness)
     * @param image is drawable reference ID that corresponds to the Album and Artist
     *
     * public Song(String vArtistName, String vSongName, int imageResourceId)
     * */
    public Song(String vArtistName, String vSongName, int imageResourceId)
    {
        mArtistName = vArtistName;
        mSongName = vSongName;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the Artist Name
     */
    public String getArtistName() { return mArtistName; }

    /**
     * Get the Song Name
     */
    public String getSongName() { return mSongName; }

    /**
     * Get the image resource ID

     */
    public int getImageResourceId() { return mImageResourceId; }
}



