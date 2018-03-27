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
        setContentView(R.layout.activity_arabic__songs);

        final ArrayList<Songs> arabicSongs = new ArrayList<Songs>();
        arabicSongs.add(new Songs("Ghammed Einak", "Cairokee", R.drawable.cairokee, R.raw.ghammed_einak));
        arabicSongs.add(new Songs("Al Leila", "Amr Diab", R.drawable.amrdiab, R.raw.al_ieila));
        arabicSongs.add(new Songs("Alby Tab", "Sandy", R.drawable.sandy, R.raw.alby_tab));
        arabicSongs.add(new Songs("Mosh Fare2", "Ramy Sabry", R.drawable.ramysabry, R.raw.mosh_fareh));
        arabicSongs.add(new Songs("Ya Latif", "Samira Said", R.drawable.samirasaid, R.raw.ya_latif));
        arabicSongs.add(new Songs("Darga", "Tamer Hosny", R.drawable.tamerhosny, R.raw.daraga));
        arabicSongs.add(new Songs("El Ward El Balady", "Assala", R.drawable.assala, R.raw.elward_elbalady));
        arabicSongs.add(new Songs("Hob Gamed", "Jannat", R.drawable.jannat, R.raw.hob_gamed));
        arabicSongs.add(new Songs("Hob Kol Hayaty", "Elissa", R.drawable.elissa, R.raw.hob_kol_hayaty));
        arabicSongs.add(new Songs("Fengan Elnesian", "Angham", R.drawable.angham, R.raw.fengan_elsahada));

        SongsAdaptor AdaptorForList = new SongsAdaptor(this, arabicSongs);


        final ListView ListView = (ListView) findViewById(R.id.list);

        ListView.setAdapter(AdaptorForList);

        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Songs play = arabicSongs.get(position);

               if(currentPosition!= position){
                   if (mPlayer != null){
                       mPlayer.stop();
                   }

               }
                if(mPlayer!=null){
                    currentPosition = position ;
                    mPlayer.stop();

                }
                mPlayer = MediaPlayer.create(Arabic_Songs.this,play.getmAudioFile());
                mPlayer.start();



            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPlayer.release();
    }
}
