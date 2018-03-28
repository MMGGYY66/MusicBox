package com.example.android.musicbox;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Arabic_Songs extends AppCompatActivity {
    MediaPlayer mPlayer;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);
        // Create an ArrayList of arabicSongs objects
        final ArrayList<Songs> arabicSongs = new ArrayList<Songs>();
        arabicSongs.add(new Songs(getString(R.string.Ghammed_Einak), getString(R.string.Cairokee), R.drawable.cairokee, R.raw.ghammed_einak));
        arabicSongs.add(new Songs(getString(R.string.Al_Leila), getString(R.string.Amr_Diab), R.drawable.amrdiab, R.raw.al_ieila));
        arabicSongs.add(new Songs(getString(R.string.Alby_Tab), getString(R.string.Sandy), R.drawable.sandy, R.raw.alby_tab));
        arabicSongs.add(new Songs(getString(R.string.Mosh_Fare2), getString(R.string.Ramy_Sabry), R.drawable.ramysabry, R.raw.mosh_fareh));
        arabicSongs.add(new Songs(getString(R.string.Ya_Latif), getString(R.string.Samira_Said), R.drawable.samirasaid, R.raw.ya_latif));
        arabicSongs.add(new Songs(getString(R.string.Darga), getString(R.string.Tamer_Hosny), R.drawable.tamerhosny, R.raw.daraga));
        arabicSongs.add(new Songs(getString(R.string.El_Ward_El_Balady), getString(R.string.Assala), R.drawable.assala, R.raw.elward_elbalady));
        arabicSongs.add(new Songs(getString(R.string.Hob_Gamed), getString(R.string.Jannat), R.drawable.jannat, R.raw.hob_gamed));
        arabicSongs.add(new Songs(getString(R.string.Hob_Kol_Hayaty), getString(R.string.Elissa), R.drawable.elissa, R.raw.hob_kol_hayaty));
        arabicSongs.add(new Songs(getString(R.string.Fengan_Elnesian), getString(R.string.Angham), R.drawable.angham, R.raw.fengan_elsahada));

        // Create an SongsAdapter, whose data source is a list of
        //  Songs . The adapter knows how to create list item views for each item
        // in the list.

        SongsAdaptor AdaptorForList = new SongsAdaptor(this, arabicSongs);

        // Get a reference to the ListView, and attach the adapter to the listView.

        final ListView ListView = (ListView) findViewById(R.id.list);

        ListView.setAdapter(AdaptorForList);
        // Set a Item Click Listener on that list view to play media player.
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // get position of each song in arraylist and save it in a variable .
                Songs play = arabicSongs.get(position);

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
                mPlayer = MediaPlayer.create(Arabic_Songs.this, play.getmAudioFile());
                mPlayer.start();
            }
        });
    }

    // stop media player when Arabic_Songs.activity is close.
    @Override
    protected void onStop() {
        super.onStop();
        if (mPlayer != null) {
            mPlayer.release();
        }
    }
}
