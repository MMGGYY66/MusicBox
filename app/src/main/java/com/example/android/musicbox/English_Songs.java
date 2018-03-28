package com.example.android.musicbox;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class English_Songs extends AppCompatActivity {
    MediaPlayer mPlayer;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);
        // Create an ArrayList of enSongs objects
        final ArrayList<Songs> enSongs = new ArrayList<Songs>();
        enSongs.add(new Songs(getString(R.string.Thats_More), getString(R.string.Dean_Martin), R.drawable.deanmartin, R.raw.thatsmore));
        enSongs.add(new Songs(getString(R.string.Im_Into_You), getString(R.string.Jennifer_lopez), R.drawable.jenniferlopez, R.raw.iamintoyou));
        enSongs.add(new Songs(getString(R.string.Repeat), getString(R.string.Shaggy), R.drawable.shaggy, R.raw.repeat));
        enSongs.add(new Songs(getString(R.string.Free_from_desire), getString(R.string.Gala), R.drawable.gala, R.raw.freefromdesire));
        enSongs.add(new Songs(getString(R.string.If_You_Had_My_Love), getString(R.string.Jennifer_lopez), R.drawable.jenniferlopez, R.raw.ifyouhadmylove));
        enSongs.add(new Songs(getString(R.string.I_Feel_Like_a_Woman), getString(R.string.Shania_Twain), R.drawable.shina, R.raw.ifeellikeawoman));
        enSongs.add(new Songs(getString(R.string.i_swear), getString(R.string.backstreet_boys), R.drawable.backstreet, R.raw.iswear));
        enSongs.add(new Songs(getString(R.string.I_REMEMBER_THE_TIME), getString(R.string.NANA), R.drawable.nana, R.raw.irememberthetime));
        enSongs.add(new Songs(getString(R.string.Sway), getString(R.string.Pussy_Cat_Dolls), R.drawable.pussycatdolls, R.raw.sway));
        enSongs.add(new Songs(getString(R.string.lonly), getString(R.string.NANA), R.drawable.nana, R.raw.lonly));

        // Create an SongsAdapter, whose data source is a list of
        //  Songs . The adapter knows how to create list item views for each item
        // in the list.

        SongsAdaptor AdaptorForList = new SongsAdaptor(this, enSongs);

        // Get a reference to the ListView, and attach the adapter to the listView.
        final ListView ListView = (ListView) findViewById(R.id.list);

        ListView.setAdapter(AdaptorForList);
        // Set a Item Click Listener on that list view to play media player.
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // get position of each song in arraylist and save it in a variable .
                Songs play = enSongs.get(position);
                // to avoid a crash , i stop the player only if this was created before.

                if (currentPosition != position) {
                    if (mPlayer != null) {
                        mPlayer.stop();
                    }
                }
                // this would help avoiding lopping song when i click a song is already playing.so it start gian.
                if (mPlayer != null) {
                    currentPosition = position;
                    mPlayer.stop();
                }
                // start media player when i chose a song.
                mPlayer = MediaPlayer.create(English_Songs.this, play.getmAudioFile());
                mPlayer.start();
            }
        });
    }

    // stop media player when English_Songs.activity is close.
    @Override
    protected void onStop() {
        super.onStop();
        if (mPlayer != null) {
            mPlayer.stop();
        }
    }
}