package com.example.android.musicbox;

/**
 * Created by AHMED HASSAN on 3/22/2018.
 */
public class Songs {
    // Name of the song.
    private String mSongName;
    // Name of the artist.
    private String mArtistName;
    // Drawable resource ID (image of artist).
    private int mImageArtist;
    // raw resource ID (mp3. file of song)
    private int mAudioFile;

    //Create a new Songs object.

    public Songs(String sName, String artName, int imageArtist, int AudioFile) {
        mSongName = sName;
        mArtistName = artName;
        mImageArtist = imageArtist;
        mAudioFile = AudioFile;

    }

    // Get the name of the song.
    public String getSonName() {
        return mSongName;
    }

    // Get the name of the Artist
    public String getArtistName() {
        return mArtistName;
    }

    // Get the image resource  of the artist.
    public int ImageArtist() {
        return mImageArtist;
    }

    // Get the audio file resource  of the song .
    public int getmAudioFile() {
        return mAudioFile;
    }

}
