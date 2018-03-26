package com.example.android.musicbox;

/**
 * Created by AHMED HASSAN on 3/22/2018.
 */
public class Songs {

    private String mSongName;

    private String mArtistName;

    private int mImageArtist;

    private int mAudioFile ;

    public Songs (String sName, String artName, int imageArtist, int AudioFile){
        mSongName = sName;
        mArtistName = artName;
        mImageArtist = imageArtist;
        mAudioFile = AudioFile;

    }

    public String getSonName(){
        return mSongName;
    }

    public String getArtistName (){
        return mArtistName;
    }
    public int ImageArtist(){
            return mImageArtist;
        }
    public int getmAudioFile(){
        return mAudioFile;
    }

}
